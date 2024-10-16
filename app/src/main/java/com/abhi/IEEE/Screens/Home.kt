package com.abhi.IEEE.Screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhi.IEEE.FireBase.dataClass.AnnouncementData
import com.abhi.IEEE.Navigation.Routes
import com.abhi.IEEE.utils.AnnouncementCard
import com.abhi.IEEE.utils.PageIndicator
import kotlinx.coroutines.delay
import com.abhi.IEEE.R
import com.abhi.IEEE.ViewModel.AnnouncementViewModel
import com.abhi.IEEE.ViewModel.EventsViewModel
import com.abhi.IEEE.utils.EventCard
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Home(
    navController : NavHostController

) {

    var showWebView = remember {
        mutableStateOf(false)
    }

    var clickedPrivacy = remember {
        mutableStateOf(false)
    }
    var clickedWebsite = remember {
        mutableStateOf(false)
    }

    val homeViewModel: AnnouncementViewModel = viewModel()

    val eventsViewModel: EventsViewModel = viewModel()


    val announcements by homeViewModel.announcements.observeAsState(null)


    val scrollableState = rememberScrollState()

    var announcementData = announcements ?: listOf(AnnouncementData("Check Your Internet", "We're having trouble connecting. Please check your internet connection and try again."))


    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { announcementData.size }
    )

    var url = ""

    LaunchedEffect(Unit) {
        var currentPage = pagerState.currentPage
        while (true) {

            val nextPage = (currentPage + 1 + pagerState.pageCount) % pagerState.pageCount
            pagerState.animateScrollToPage(
                nextPage,
                animationSpec = tween(500, easing = LinearOutSlowInEasing)
            )
            currentPage = nextPage
            delay(2000)
        }
    }


    if (showWebView.value) {
        Column(Modifier) {
            Column(Modifier.fillMaxWidth()
                .height(30.dp),
                horizontalAlignment = Alignment.End) {
                IconButton(onClick = {
                    showWebView.value = !showWebView.value
                    if(clickedWebsite.value){
                        clickedWebsite.value = false
                    }
                    if(clickedPrivacy.value){
                        clickedPrivacy.value = false

                    }

                }) {
                    Icon(imageVector = Icons.Outlined.Close, contentDescription = "" ,Modifier.background(Color.Red))
                }
            }

            if(clickedPrivacy.value){
                 url = "https://sites.google.com/view/ieeejnnce/home"
            }

            if(clickedWebsite.value){
                url = "https://www.ieee.org/"
            }

            website(url)
        }

      //  https://sites.google.com/view/jnnceieee2k24/home?authuser=2

    } else {
        Column(Modifier) {


            //---------------------Announcement-------------------------------------

            Column(
                Modifier
                    .navigationBarsPadding()
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .background(Color.White)
                ) {
                    Text(
                        text = "Announcements",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }


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
                            if (announcementData != null) {
                                AnnouncementCard(
                                    announcementData.get(currentPager).title,
                                    announcementData.get(currentPager).description
                                )
                            }

                        }

                        if (announcementData != null) {
                            PageIndicator(announcementData.size, pagerState.currentPage)
                        }
                    }

                }


                // -------------------Row of Cards with functions ---------------------------------

                Row(
                    Modifier
                        .padding(10.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                ) {

                    Card(colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        onClick = {
                            navController.navigate(Routes.Events.route)
                        }
                    ) {
                        Column(
                            Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.eventicon),
                                contentDescription = "events"
                            )
                            Text(text = "Events", color = Color.Black)
                        }
                    }

                    Card(colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        onClick = {


                            showWebView.value = !showWebView.value
                            clickedWebsite.value = !clickedWebsite.value

                            //eventsViewModel.saveData()


                            //homeViewModel.saveData("Announcement" , "adf" ,"fa")
                        }
                    ) {
                        Column(
                            Modifier
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.web_icon),
                                contentDescription = "website"
                            )
                            Text(text = "Web", color = Color.Black)
                        }
                    }

                    Card(colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        onClick = {
                            navController.navigate(Routes.AboutUs.route)
                        }
                    ) {
                        Column(
                            Modifier
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.abouticon),
                                contentDescription = "About"
                            )
                            Text(text = "About", color = Color.Black)
                        }
                    }

                    Card(
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        onClick = {
                            clickedPrivacy.value = !clickedPrivacy.value
                            showWebView.value = !showWebView.value
                        }
                    ) {
                        Column(
                            Modifier
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.privacypolicy),
                                contentDescription = "Policy"
                            )
                            Text(text = "Policy", color = Color.Black)
                        }
                    }

                }


                //------------------Events Rew with cards-----------------------


                Row(
                    Modifier
                        .padding(start = 20.dp, top = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Events",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }



                Row(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .horizontalScroll(scrollableState),
                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                ) {

                    EventCard( description = "Anveshana's Pixel Puzzles event offers an immersive platform for enthusiasts to" +
                            "delve into the intricate world of UI/UX interface development. With a blend of" +
                            "creativity and technical prowess, participants are challenged to unravel the" +
                            "complexities of pixel-perfect design. crafting seamless digital experiences that captivate and engage" ,
                        title = "Pixel Puzzles" , activeStatus = "completed" , members = "Abhishek HJ,Abhishek KS,Karthik BK" ,
                        date = "01/03/2024" , first = "Goutham H M" , second = "Indudhar S,Aditya A Navale " ,
                        third = "Sharvari PK,Rakshitha DH" , link = "" , navController = navController )


                    EventCard( description = "Front End Frenzy thrusts participants into the dynamic" +
                            "realm of web development, honing their skills in HTML, CSS, and JavaScript. This" +
                            "exhilarating event presents a series of challenges focused on debugging and coding," +
                            "requiring keen attention to detail and adept problem-solving abilities to achieve " +
                            "precise outputs. Front End Frenzy fosters a spirit of collaboration and innovation.",
                        title = "Front End Frenzy " , activeStatus = "completed" , members = "Aishwarya K P, Archana B H, Chandan S, Dhvaneeth P" ,
                        date = "01/03/2024" , first = "Hari BJ, Rohith D" , second = "Ruchitha SR,Vibha GM" ,
                        third = "Pooja B,Bhavana RM" , link = "", navController = navController  )


                    EventCard( description = "Shark Tank Lite, inspired by the renowned television show," +
                            " created a dynamic environment for aspiring entrepreneurs within the student community." +
                            " Participants presented innovative ideas and solutions to a panel" +
                            " of judges, testing their entrepreneurial acumen and ability to pitch" +
                            " compelling business proposals." ,
                        title = "SharkTank Lite" , activeStatus = "completed" , members = "Ananya B, Bharath C, Dhruthi N, Mizbah Kounain, Pratheeksha D R." ,
                        date = "29/02/2024" , first = "Vaishnavi S,Vandana R" , second = "Trupthi KN,Natasha HN" ,
                        third = "Sushmitha HS,Souparnika KH" , link = "" , navController = navController )

                    Column(
                        Modifier
                            .width(150.dp)
                            .height(200.dp)
                            .padding(8.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextButton(onClick = { navController.navigate(Routes.Events.route) }) {
                            Text(
                                text = "View All",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }
                }


            }


        }

    }
}
@Composable
fun website(url : String , modifier: Modifier = Modifier) {
    //val url = "https://www.ieee.org/"
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient= WebViewClient()
            loadUrl(url)
        }
    })
}
