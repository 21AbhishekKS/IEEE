package com.abhi.ieee.Screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhi.ieee.R
import com.abhi.ieee.utils.EventCard


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Events(navController : NavHostController,

){
Column(Modifier.fillMaxSize().background(Color.White),
    ) {

    val scrollableState = rememberScrollState()
    val scrollableState1 = rememberScrollState()



    Row(Modifier.padding(start = 20.dp, top = 20.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Start) {
        Text(text ="Upcoming" ,
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold)
    }



    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollableState),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly) {

        EventCard(R.drawable.pixel_puzzel , "pixel puzzle")
        EventCard(R.drawable.front_frezy , "FrontEnd Fr..")
        EventCard(R.drawable.bgmi , "BGMI")


    }




 Row(Modifier.padding(start = 20.dp, top = 20.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Start) {
        Text(text ="Completed" ,
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold)
    }



    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollableState1),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly) {


        EventCard(R.drawable.t_humt , "Go get it")
        EventCard(R.drawable.shark , "Shark Trank")
        EventCard(R.drawable.bgmi , "BGMI")

    }



}
}




