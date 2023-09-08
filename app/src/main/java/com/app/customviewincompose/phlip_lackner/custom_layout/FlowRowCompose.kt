package com.app.customviewincompose.phlip_lackner.custom_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun FlowRowCompose() {
    Column(modifier = Modifier.fillMaxSize()) {
        FlowRow {
            repeat(10){
                Box(modifier = Modifier.width(Random.nextInt(50,200).dp).height(100.dp)
                    .background(Color(Random.nextLong(0xFFFFFFFFF)))) {

                }
            }
        }
    }

}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(modifier = modifier, measurePolicy ={measurables,constraints->
        val placeable = measurables.map { it.measure(constraints) }
        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ){
            placeable.forEach{placeable ->
                var xPosition = 0
                placeable.place(
                    x=xPosition,
                    y=0
                )
                xPosition += placeable.width
            }
        }
    }, content = content)
}


@Preview(showBackground = true)
@Composable
fun FlowRowComposePreview() {
    FlowRowCompose()

}