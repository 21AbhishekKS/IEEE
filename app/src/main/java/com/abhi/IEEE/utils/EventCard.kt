package com.abhi.IEEE.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.abhi.IEEE.Navigation.Routes
import com.abhi.IEEE.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCard(
    navController : NavHostController,
    description : String, title: String , members: String ,
              activeStatus: String , first: String , second: String ,
              third: String , link : String ,date : String) {


    Card(colors = CardDefaults.cardColors(Color(0xFFC0DCF3)),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(200.dp),
        onClick = {
            navController.navigate(
                route = "${Routes.EventShowScreen.route}?description=$description&title=$title&members=$members&activeStatus=$activeStatus&first=$first&second=$second&third=$third&link=$link&date=$date")
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start) {

          //Image(
            //                painter = painterResource(id = image),
            //                contentDescription = "Pixel Puzzle event image",
            //                modifier = Modifier
            //                    .fillMaxWidth()
            //                    .fillMaxHeight(.85f)
            //
            //            )



            Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )

            Text(
                    text = date,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            Text(
                    text = activeStatus,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            Column(Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End) {
                Image(painter = painterResource(id = R.drawable.completed), contentDescription = "" )
            }
            }
        }
}

