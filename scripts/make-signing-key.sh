#!/usr/bin/env bash
# Makes the key that signs Netflixx, and prints the four GitHub secrets the
# build needs. Run it once, on any machine with Docker or Java:
#   bash scripts/make-signing-key.sh
#
# Android only installs an update if it's signed with the same key as the app
# already on the TV, so keep netflixx.keystore and its password somewhere safe.
# Lose them and the next build has to be installed fresh, losing the app's settings.
set -euo pipefail

out=${1:-netflixx.keystore}
if [[ -e "$out" ]]; then
  echo "$out already exists. Delete it or pass another file name." >&2
  exit 1
fi
pass=$(head -c 24 /dev/urandom | base64 | tr -d '/+=' | head -c 24)
alias=netflixx
args=(-genkeypair -v -storetype PKCS12 -keystore "/work/$(basename "$out")" -alias "$alias"
      -keyalg RSA -keysize 4096 -validity 36500 -storepass "$pass" -keypass "$pass"
      -dname "CN=Netflixx, O=Statixx Solutions, C=US")

if command -v keytool >/dev/null; then
  args[5]="$out"
  keytool "${args[@]}" >/dev/null 2>&1
else
  dir=$(cd "$(dirname "$out")" && pwd)
  docker run --rm -v "$dir:/work" eclipse-temurin:21-jre keytool "${args[@]}" >/dev/null 2>&1
  [[ "$(id -u)" = 0 ]] || sudo chown "$(id -u):$(id -g)" "$out" 2>/dev/null || true
fi

cat <<EOF
Made $out. Keep it and this password safe (a password manager is ideal).

Add these four secrets in GitHub: the Netflixx-TV repo > Settings >
Secrets and variables > Actions > New repository secret.

  KEY_ALIAS           $alias
  KEY_PASSWORD        $pass
  KEY_STORE_PASSWORD  $pass
  SIGNING_KEY         (the long line below)

$(base64 -w0 "$out" 2>/dev/null || base64 "$out" | tr -d '\n')

Then push anything to main, or run "Netflixx build" from the Actions tab.
EOF
