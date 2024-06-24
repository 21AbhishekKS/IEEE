package com.abhi.ieee.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhi.ieee.R

@Composable
fun AboutUs(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {

        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.b), contentDescription = "" )
        }

        Column(Modifier.padding(15.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {



        Text(text = "Who we are ?",
            color = Color.Black ,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp)

            Text(text =
                "We are a dynamic community committed to fostering " +
                "innovation and excellence in technology" +
                ", bringing together students, professionals, " +
                "and enthusiasts with diverse expertise. Driven by" +
                " a shared dedication to advancing technology and " +
                "positively impacting society, we empower individuals" +
                " to reach their full potential through collaboration, " +
                "networking, and engaging events. ",
            color = Color.Black)

        }


        }}