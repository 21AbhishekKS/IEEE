package com.abhi.IEEE.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.abhi.IEEE.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AboutUs(){
    var scrollableState = rememberScrollState()

    val composition1 =
        rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.events))


    val progress1 by animateLottieCompositionAsState(
        composition = composition1.value,
        speed = 2f,
       // iterations = LottieConstants.IterateForever
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollableState)) {

        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            LottieAnimation(
                modifier = Modifier.fillMaxSize(),
                composition = composition1.value,
                progress = { progress1 }
            )
           // Image(painter = painterResource(id = R.drawable.b), contentDescription = "" )
        }

        Column(
            Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Text(text = "Who we are?",
                color = Color.Black ,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp)
        }

        Column(
            Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

                Text(text =
                "   We are a dynamic community at J N N College of Engineering, " +
                        "Shivamogga, committed to fostering innovation and excellence" +
                        " in technology. We bring together students, professionals, " +
                        "and enthusiasts with diverse expertise to create a vibrant " +
                        "" +
                        "learning environment.\n" +
                        "\n" +
                        "Driven by a shared passion for advancing technology and" +
                        " making a positive impact on society, we empower individuals " +
                        "to reach their full potential. We achieve this through " +
                        "collaboration, networking, and engaging events "+"\n",
                    color = Color.Black,
                    textAlign = TextAlign.Justify)



            Text(text =
            "•\tAvishkaar Tech Fest: Organized by the Department of " +
                    "Computer Science and Engineering," +
                    " Avishkaar is coordinated by Dr. Poornima K M " +
                    "(Professor, CS&E Dept) and Mr. Sathyanarayana S " +
                    "(Assistant Professor, CS&E Dept). This tech fest" +
                    " provides a platform for students to showcase their " +
                    "technical skills and compete in various domains."+"\n",
                color = Color.Black,
                textAlign = TextAlign.Justify)

            Text(text =
                "•\tAnveshana: Meaning \"the search for knowledge and " +
                        "experience,\" Anveshana encourages students to " +
                        "explore their creativity and develop holistic " +
                        "thinking skills. It reflects our commitment to" +
                        " fostering innovation, a passion for learning, " +
                        "and a determination to make a positive impact"+"\n",
            color = Color.Black,
                textAlign = TextAlign.Justify)

            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Column {

                    Text(text = "Coordinators",
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold)
                    Text(text = "Dr.Poornima K M",
                        color = Color.Black)
                    Text(text = "Mr. Sathyanarayana S",
                        color = Color.Black)
                }

                Column {

                    Text(text = "HOD, CSE",
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold)
                    Text(text = "Dr. Jalesh Kumar",
                        color = Color.Black)

                }



            }


        }
        
         Column(
             Modifier
                 .padding(10.dp)
                 .fillMaxWidth()
                 .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                 .padding(10.dp)
             ,) {
            Text(text = "For any technical issues or questions beyond the app's FAQ," +
                    " feel free to contact us at abhishekks@ieee.org" +
                    " We'll do our best to assist you.", color = Color.Black,
                textAlign = TextAlign.Justify)
        }


        }}