package com.abhi.ieee.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhi.ieee.FireBase.dataClass.EventData
import com.abhi.ieee.R
import com.abhi.ieee.ViewModel.EventsViewModel
import com.abhi.ieee.utils.EventCard
import com.abhi.ieee.utils.EventsList


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Events(navController : NavHostController,

){
Column(
    Modifier
        .fillMaxSize()
        .background(Color.White),
    ) {

    val scrollableState = rememberScrollState()
    val scrollableState1 = rememberScrollState()


    val eventViewModel  : EventsViewModel = viewModel()
    val events by eventViewModel.events.observeAsState()

    var eventsList = events ?: listOf(EventData(description = "event" , title = "events" , activeStatus = "ongoing",
            members = "Abhi K S " , first = "first" , second = "222" , third = "333" ))





    Column(
        Modifier
            .padding(horizontal = 10.dp )
            .padding( top = 20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start) {
        Text(text ="All Events" ,
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold)

        EventsList(eventsList , navController )


    }


}
}




