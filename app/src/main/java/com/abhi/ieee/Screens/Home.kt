package com.abhi.ieee.Screens

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhi.ieee.R
import com.abhi.ieee.helper.LottieLoader
import com.abhi.ieee.utils.AnnouncementCard
import com.abhi.ieee.utils.PageIndicator
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Home(){



    val images = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.a,
        R.drawable.b,

        )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { images.size }
    )

    LaunchedEffect(Unit) {
        var currentPage = pagerState.currentPage
        while (true) {

            val nextPage = (currentPage + 1 + pagerState.pageCount) % pagerState.pageCount
            pagerState.animateScrollToPage(
                nextPage,
                animationSpec =  tween(500, easing = LinearOutSlowInEasing)
            )
            currentPage = nextPage
            delay(2000)
        }
    }


    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                    //.padding(10.dp)
                ) { currentPager ->

                    AnnouncementCard("First", "MY firest annoucemt in tis app how is working man")

                }

                PageIndicator(images.size  , pagerState.currentPage)
            }

        }

    }

}


// Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
//
//
//            Surface(
//                color = Color(0x4E, 0x12, 0x69, 0xFF),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(.45f)
//                    .align(Alignment.TopStart)) {
//
//                Column(Modifier.padding(10.dp)
//                    .fillMaxHeight(),
//                    verticalArrangement = Arrangement.Top,
//                    horizontalAlignment = Alignment.CenterHorizontally){
//                    LottieLoader(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight(.8f),
//                        image = R.raw.innovaiton )
//                }
//
//
//
//
//            }
//            Surface(color = Color.White,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxSize(.65f),
//                shape = RoundedCornerShape(topStart = 60.dp )
//            ) {
//
//            }
//
//
//    }