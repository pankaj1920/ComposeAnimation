package com.app.customviewincompose.phlip_lackner

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        var isVisible by remember { mutableStateOf(false) }

        Button(onClick = {
            isVisible = !isVisible
        }) {
            Text(text = "Toogle")
        }

        AnimatedContent(
            targetState = isVisible, modifier = Modifier
                .fillMaxWidth()
                .weight(1f), content = { isVisble ->
                if (isVisble)
                    Box(modifier = Modifier.background(Color.Red))
                else Box(modifier = Modifier.background(Color.Yellow))

            }, label = "",
            transitionSpec = {
                slideInHorizontally (
                    initialOffsetX = {
                        -it
                    }
                ) with slideOutHorizontally (
                    targetOffsetX = {it}
                )
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun AnimateContentPreview() {
    AnimateContent()

}