package com.app.customviewincompose.phlip_lackner

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        var isVisible by remember { mutableStateOf(false) }


        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toogle")
        }
        AnimatedVisibility(visible = isVisible, modifier = Modifier.weight(1f),
            enter = slideInHorizontally()+ fadeIn(),
            exit = slideOutHorizontally()+ fadeOut()
            ,) {
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxSize())
        }
    }

}


@Preview(showBackground = true)
@Composable
fun AnimationScreenPreview() {
    AnimatedVisibilityScreen()

}