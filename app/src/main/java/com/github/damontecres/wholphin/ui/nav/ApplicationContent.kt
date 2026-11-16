package com.github.damontecres.wholphin.ui.nav

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.rememberDrawerState
import com.github.damontecres.wholphin.data.model.JellyfinServer
import com.github.damontecres.wholphin.data.model.JellyfinUser
import com.github.damontecres.wholphin.preferences.UserPreferences
import com.github.damontecres.wholphin.services.BackdropService
import com.github.damontecres.wholphin.services.NavigationManager
import com.github.damontecres.wholphin.ui.components.ErrorMessage
import com.github.damontecres.wholphin.ui.launchIO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Page changes: the new page fades in while settling into place, the old one fades out quickly
private val pageEnterTransition =
    fadeIn(tween(durationMillis = 280, delayMillis = 60, easing = FastOutSlowInEasing)) +
        scaleIn(tween(durationMillis = 340, easing = FastOutSlowInEasing), initialScale = 0.97f)
private val pageExitTransition = fadeOut(tween(durationMillis = 160))

// Top scrim configuration for text readability (clock, season tabs)
const val TOP_SCRIM_ALPHA = 0.55f
const val TOP_SCRIM_END_FRACTION = 0.25f // Fraction of backdrop image height

@HiltViewModel
class ApplicationContentViewModel
    @Inject
    constructor(
        val backdropService: BackdropService,
    ) : ViewModel() {
        fun clearBackdrop() {
            viewModelScope.launchIO { backdropService.clearBackdrop() }
        }
    }

/**
 * This is generally the root composable of the of the app
 *
 * Here the navigation backstack is used and pages are rendered in the nav drawer or full screen
 */
@Composable
fun ApplicationContent(
    server: JellyfinServer,
    user: JellyfinUser,
    navigationManager: NavigationManager,
    preferences: UserPreferences,
    modifier: Modifier = Modifier,
    enableTopScrim: Boolean = true,
    viewModel: ApplicationContentViewModel = hiltViewModel(),
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Box(
        modifier = modifier,
    ) {
        val backdropStyle = preferences.appPreferences.interfacePreferences.backdropStyle
        Backdrop(
            drawerIsOpen = drawerState.isOpen,
            backdropStyle = backdropStyle,
            enableTopScrim = enableTopScrim,
            viewModel = viewModel,
        )
        val navDrawerListState = rememberLazyListState()
        NavDisplay(
            backStack = navigationManager.backStack,
            onBack = { navigationManager.goBack() },
            entryDecorators =
                listOf(
                    rememberSaveableStateHolderNavEntryDecorator(),
                    rememberViewModelStoreNavEntryDecorator(),
                ),
            transitionSpec = { pageEnterTransition togetherWith pageExitTransition },
            popTransitionSpec = { pageEnterTransition togetherWith pageExitTransition },
            entryProvider = { key ->
                key as Destination
                val contentKey = "${key}_${server?.id}_${user?.id}"
                NavEntry(key, contentKey = contentKey) {
                    if (key.fullScreen) {
                        DestinationContent(
                            destination = key,
                            preferences = preferences,
                            onClearBackdrop = viewModel::clearBackdrop,
                            modifier = Modifier.fillMaxSize(),
                        )
                    } else if (user != null && server != null) {
                        NavDrawer(
                            destination = key,
                            preferences = preferences,
                            user = user,
                            server = server,
                            drawerState = drawerState,
                            navDrawerListState = navDrawerListState,
                            onClearBackdrop = viewModel::clearBackdrop,
                            modifier = Modifier.fillMaxSize(),
                        )
                    } else {
                        ErrorMessage("Trying to go to $key without a user logged in", null)
                    }
                }
            },
        )
    }
}
