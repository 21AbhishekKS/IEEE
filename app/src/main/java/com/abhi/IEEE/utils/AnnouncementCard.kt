package com.abhi.IEEE.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhi.IEEE.R
import com.abhi.IEEE.helper.LottieLoader


@Preview(showBackground = true)
@Composable
fun AnnouncementCard(
    title: String = "ComingSoon",
    info: String = "Something exciting is brewing! Stay tuned for upcoming updates"){
        Column(
            Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(
                    Brush.horizontalGradient(


                        0.0f to Color(0xFF0F0C29),
                        1.0f to Color(0xFF24243E),

                        //    0.0f to Color(0xFF141E30),
                        //  1.0f to Color(0xFF243B55),


                    )
                )
                .padding(15.dp),

            verticalArrangement = Arrangement.SpaceEvenly

        ) {

            Row(verticalAlignment = Alignment.CenterVertically){

                Column(modifier = Modifier.fillMaxWidth(.3f),
                ) {
                    LottieLoader(modifier = Modifier.size(150.dp), image = R.raw.announce )
                }


            Column() {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Text(
                    text = info,
                //    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )

            }

            }
        }
}
