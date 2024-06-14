package com.abhi.ieee.Screens

import android.provider.CalendarContract.Colors
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.abhi.ieee.Navigation.Routes
import com.abhi.ieee.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun StartScreen(navController: NavHostController){
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.background5))
    val progress by animateLottieCompositionAsState(
        composition = composition.value,
        iterations = LottieConstants.IterateForever)

    //for button color transition
    val infinateTransition = rememberInfiniteTransition()
    val color by infinateTransition.animateColor(
        initialValue = Color(0xFF8F8D8D),
        targetValue = Color(0xFF808080),
        animationSpec = infiniteRepeatable(
            animation =  tween(durationMillis = 2000 , easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart){


        LottieAnimation(
            modifier = Modifier.fillMaxSize(),
            composition = composition.value,
            progress = {progress})


        Column(modifier = Modifier
            .padding(bottom = 60.dp)
            .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
                textAlign = TextAlign.Center,
                text = "IEEE JNNCE",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            //Text(modifier = Modifier
            //                .fillMaxWidth()
            //                .padding(5.dp),
            //                textAlign = TextAlign.Start,
            //                text = "JNNCE",
            //                fontSize = 30.sp,
            //                color = Color.White,
            //                fontWeight = FontWeight.Bold
            //            )

            Spacer(modifier =Modifier.height(6.dp))
            
            Text(modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Join us on this exciting journey of exploration, discovery and growth" +
                        "Join us on this exciting journey of exploration, discovery and growth",
                fontSize = 14.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Thin
            )

            Spacer(modifier =Modifier.height(15.dp))

            Button(onClick = {

                navController.navigate(Routes.BottomNav.route){
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop=true
                }


                             } ,
                Modifier.width(400.dp),
                border = BorderStroke(1.dp , Color.LightGray),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = color)) {
                Text(text = "Start",
                    fontSize = 20.sp ,
                    color = Color.White)
            }
            
        }
    }
}