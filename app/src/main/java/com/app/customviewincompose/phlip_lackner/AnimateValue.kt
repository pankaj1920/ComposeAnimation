package com.app.customviewincompose.phlip_lackner

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimateValue() {
    Column(modifier = Modifier.fillMaxSize()) {
        var isVisible by remember { mutableStateOf(false) }
        var isRound by remember { mutableStateOf(false) }

        val tansation = updateTransition(targetState = isRound, label = "")

        val borderTransaction by tansation.animateInt(
            transitionSpec = {
                tween(
                    durationMillis = 3000,
                    delayMillis = 500
                )
            },
            label = "",
            targetValueByState = { isRound ->
                if (isRound) 100 else 0
            }
        )
        val borderRadiusState by animateIntAsState(
            targetValue = if (isRound) 100 else 0, label = "",
            animationSpec = tween(
                durationMillis = 3000,
                delayMillis = 500
            )
        )

        val colorByTransaction by tansation.animateColor (
            transitionSpec = { tween(2000) },
            label = "",
            targetValueByState = {isRound->
                if (isRound) Color.Green else Color.Red

            }
        )

        Button(onClick = {
            isVisible = !isVisible
            isRound = !isRound
        }) {
            Text(text = "Toogle")
        }

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderTransaction))
                .background(colorByTransaction)
        ) {

        }
    }

}


@Preview(showBackground = true)
@Composable
fun AnimateValuePreview() {
    AnimateValue()

}