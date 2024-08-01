package com.abhi.IEEE.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.ui.graphics.Color
@Composable
fun PageIndicator(size: Int, pagerState: Int){
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(10.dp)){

        repeat(size){
            Indicator(isSelected = it == pagerState)
        }
    }
}


@Composable
fun Indicator( isSelected : Boolean){
    val width = animateDpAsState(targetValue = if(isSelected) 25.dp else 10.dp)

    Box(modifier = Modifier
        .padding(1.dp)
        .height(6.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(if (isSelected) Color.DarkGray else Color.LightGray)
    )
}
