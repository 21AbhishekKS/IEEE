package com.abhi.IEEE.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhi.IEEE.R
import com.abhi.IEEE.ViewModel.EventsViewModel
import com.abhi.IEEE.utils.EventsList


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Events(navController : NavHostController,

){
Column(
    Modifier
        .fillMaxSize()
        .background(Color.White),
    ) {




    val eventViewModel  : EventsViewModel = viewModel()
    val events by eventViewModel.events.observeAsState()

    var eventsList = events // ?: listOf(EventData(description = "event" , title = "events" , activeStatus = "ongoing",
           // members = "Abhi K S " , first = "first" , second = "222" , third = "333" ))



if (eventsList == null){
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        
        Image(painter = painterResource(id = R.drawable.no_intrenet), contentDescription = "")
        
        Text(
            text = "Oops!",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            color = Color.Black,
        )
        
         Spacer(modifier = Modifier.height(20.dp))

        Row(
            Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "We're having trouble connecting" +
                    " Please check your internet connection and try again"
                , color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp)
        }


    }
}
else{
    Column(
        Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 20.dp)
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
}




