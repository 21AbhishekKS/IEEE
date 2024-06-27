package com.abhi.ieee.utils


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhi.ieee.FireBase.dataClass.EventData
import com.abhi.ieee.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun EventsCard(
    item: EventData,
    onClick: () -> Unit
){

    Card(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                onClick()
            }
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(0xFFC0DCF3))
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically){


            Row(Modifier.fillMaxWidth()
                ,verticalAlignment = Alignment.CenterVertically){

                Column(
                    Modifier
                        .fillMaxWidth(.8f)
                        .wrapContentHeight()) {
                    Text(text = item.title ,
                        Modifier.padding(bottom = 3.dp) ,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp)

                    Text(text = item.description,
                        Modifier.padding(bottom = 3.dp) ,
                        maxLines =3,
                        overflow = TextOverflow.Ellipsis
                        , color = Color.Black,
                        fontSize = 15.sp)



                    Text(text = item.activeStatus  ,

                        color =
                        if(item.activeStatus  == "upcoming" ){
                            Color(0xFF0F2392)
                        }
                        else if (item.activeStatus  == "ongoing"){
                            Color(0xFFDDA603)
                        }
                        else{
                            Color(0xFFF03B2E)
                        } ,
                        fontWeight = FontWeight.Bold)

                    Text(text = item.date ,
                        Modifier.padding(top = 3.dp) ,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold)


                }
            Column(Modifier.align(Alignment.Bottom),
                horizontalAlignment = Alignment.End) {


                Image(painter = painterResource(id =
                if(item.activeStatus  == "upcoming" ){R.drawable.upcoming}
                else if (item.activeStatus  == "ongoing"){R.drawable.ongoing}
                else{R.drawable.completed}
                ),
                    contentDescription = "" ,
                    Modifier
                        .padding(10.dp)
                        .size(40.dp)
                )
            }
            }



        }

    }

}
