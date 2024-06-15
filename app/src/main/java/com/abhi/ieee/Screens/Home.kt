package com.abhi.ieee.Screens

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhi.ieee.FireBase.dataClass.AnnouncementData
import com.abhi.ieee.Navigation.Routes
import com.abhi.ieee.ViewModel.HomeScreenViewModel
import com.abhi.ieee.utils.AnnouncementCard
import com.abhi.ieee.utils.PageIndicator
import kotlinx.coroutines.delay
import com.abhi.ieee.R

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController : NavHostController,
    homeScreenViewModel: HomeScreenViewModel = viewModel()
){


    var announcementData = homeScreenViewModel.state

    if (announcementData.isEmpty()) {
        announcementData.addAll(0,
            listOf(
                AnnouncementData("ComingSoon ", "Something exciting is brewing! Stay tuned for upcoming updates "),
                AnnouncementData("UpdateAlert", "We've got a secret... but we can't keep it quiet for much longer!"),

            ))
    }



    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { announcementData.size }
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


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally){


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                    //.padding(10.dp)
                ) { currentPager ->
                    AnnouncementCard(
                        announcementData.get(currentPager).title,
                        announcementData.get(currentPager).description
                    )

                }

                PageIndicator(announcementData.size, pagerState.currentPage)
            }

        }

           Row(
               Modifier
                   .fillMaxWidth()
                   .wrapContentHeight(),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly) {

            Card(colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.elevatedCardElevation(5.dp),
                onClick = {
                    navController.navigate(Routes.Events.route)
                }
                ) {
                Column(Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.eventicon), contentDescription ="events")
                    Text(text = "Events", color = Color.Black)
                }
            }

            Card(colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.elevatedCardElevation(5.dp)
            ) {
            Column(
                Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.web_icon), contentDescription ="website")
                Text(text = "Web", color = Color.Black)
            }}

            Card(colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.elevatedCardElevation(5.dp),
                onClick = {
                    navController.navigate(Routes.AboutUs.route)
                }
            ) {
            Column(
                Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.abouticon), contentDescription ="About")
                Text(text = "About", color = Color.Black)
            }}

            Card(colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.elevatedCardElevation(5.dp)
            ) {
            Column(
                Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.share_icon), contentDescription ="Share")
                Text(text = "Share", color = Color.Black)
            }}

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