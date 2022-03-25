package com.strive.xwanandroid.ui.theme

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally

@OptIn(ExperimentalAnimationApi::class)
object Transitions {

    private const val VisibilityAnimationDuration = 1000

    val visibilityEnter = fadeIn(animationSpec = tween(durationMillis = VisibilityAnimationDuration)) +
        expandHorizontally(animationSpec = tween(durationMillis = VisibilityAnimationDuration))

    val visibilityExit = fadeOut(animationSpec = tween(durationMillis = VisibilityAnimationDuration)) +
        shrinkHorizontally(animationSpec = tween(durationMillis = VisibilityAnimationDuration))
}
