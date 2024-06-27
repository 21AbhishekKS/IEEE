package com.abhi.ieee.utils


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.abhi.ieee.FireBase.dataClass.EventData
import com.abhi.ieee.Navigation.Routes
import com.abhi.ieee.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun EventsList(eventList: List<EventData>, navController: NavController ) {




    val isListEmpty = eventList?.isEmpty() ?: true

    var  context = LocalContext.current

    Box( // Use Box for full-screen coverage
        modifier = Modifier.fillMaxSize()
    ) {
        if (isListEmpty) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "No Events" , color = Color.Black)
                // Image(
                //    painter = painterResource(id = R.drawable.no_transaction),
                //    contentDescription = "No transactions found",
                //    Modifier
                //        .height(10.dp)
                //       .width(10.dp)
                //  )
            }
        } else {



            LazyColumn(
                content = {
                    itemsIndexed(eventList!!) { index, item ->
                        var passingTitle = item.title
                        var passingMembers = item.members
                        var passingDescription = item.description
                        var ActiveStatus = item.activeStatus
                        var first = item.first
                        var second = item.second
                        var third = item.third
                        var link = item.link
                        var date = item.date

                        EventsCard(item = eventList[index] , onClick = {
                            navController.navigate(
                                route = "${Routes.EventShowScreen.route}?description=$passingDescription&title=$passingTitle&members=$passingMembers&activeStatus=$ActiveStatus&first=$first&second=$second&third=$third&link=$link&date=$date")
                        }
                        )
                    }
                }, modifier = Modifier.fillMaxSize()
            )
        }
        }
}