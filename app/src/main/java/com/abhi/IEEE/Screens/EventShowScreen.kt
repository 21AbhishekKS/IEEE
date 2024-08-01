package com.abhi.IEEE.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhi.IEEE.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun EventShowScreen(description : String, title: String , members: String ,
                    activeStatus: String , first: String , second: String ,
                    third: String , link :String ,date : String) {

    var scrollableState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            ) {


        val isCelebrationVisible = remember {
            mutableStateOf(false)
        }



        Box(modifier = Modifier.fillMaxSize(),
         //   contentAlignment = Alignment.BottomStart
        ){
            

           

            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollableState)
                //.padding(bottom = 60.dp)
                .padding(horizontal = 20.dp),
               ) {
                Column(Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = title ,
                        Modifier.padding(bottom = 3.dp) ,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 30.sp,)
                }

                Row(Modifier.fillMaxWidth(),) {
                    Text(text = "Description :" ,Modifier.fillMaxWidth(.4f), color = Color.Black , fontWeight = FontWeight.Bold)

                    Text(text = description , color = Color.Black)
                }
                Row(Modifier.fillMaxWidth()) {
                    Text(text = "Members :" ,Modifier.fillMaxWidth(.4f), color = Color.Black , fontWeight = FontWeight.Bold)

                    Text(text = members , color = Color.Black )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(text = "Event Status :" ,Modifier.fillMaxWidth(.4f), color = Color.Black , fontWeight = FontWeight.Bold)

                    Text(text = activeStatus , color = Color.Black)
                }
                Row(Modifier.fillMaxWidth()) {
                    Text(text = "Date :" ,Modifier.fillMaxWidth(.4f), color = Color.Black , fontWeight = FontWeight.Bold)
                    Text(text = date , color = Color.Black)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.Center){
                    Button(
                        onClick = { isCelebrationVisible.value = !isCelebrationVisible.value},
                        colors = ButtonDefaults.buttonColors(Color(84, 75, 100, 255))) {



                        Text(text = if(isCelebrationVisible.value){"Hide Result"}else{"Show Result"} ,
                            color = Color.White)
                    }
                }



                if (isCelebrationVisible.value && (first=="" || second=="" || third=="")){
                    Text(text = "Result not updated!" , color = Color.Black)
                }
                
                if (isCelebrationVisible.value && first!="" && second!="" && third!="") {
                    Column(Modifier.fillMaxHeight()){


                        Box(Modifier.fillMaxHeight()) {


                            val composition1 =
                                rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.celebration))


                            val progress1 by animateLottieCompositionAsState(
                                composition = composition1.value,
                                speed = 1.5f,
                                iterations = LottieConstants.IterateForever
                            )


                            Column(Modifier.fillMaxSize()
                               ) {
                                Spacer(modifier = Modifier.height(20.dp))
                                FirstCard(first)
                                Spacer(modifier = Modifier.height(20.dp))
                                SecondCard(second)
                                Spacer(modifier = Modifier.height(20.dp))
                                ThirdCard(third)


                            }


                            LottieAnimation(
                                modifier = Modifier.fillMaxSize(),
                                composition = composition1.value,
                                progress = { progress1 }
                            )
                        }
                    }
                }
            }


        }





    }
    



}

//@Preview(showBackground = true)
@Composable
fun FirstCard(name : String ="Name"){

    Card(
        Modifier
            .fillMaxWidth()
            .height(80.dp),
        border = BorderStroke(1.dp,Color.Black),
        colors = CardDefaults.cardColors(Color.White)) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Column(Modifier.fillMaxWidth(.8f)) {
                Text(text = name , color=Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 22.sp ,
                    fontWeight = FontWeight.ExtraBold)
            }

            Image(painter = painterResource(id = R.drawable.first), contentDescription = name ,
                Modifier.size(65.dp),)
        }
    }

}
//@Preview(showBackground = true)
@Composable
fun SecondCard(name : String ="Name"){

    Card(
        Modifier
            .fillMaxWidth()
            .height(80.dp),
        border = BorderStroke(1.dp,Color.Black),
        colors = CardDefaults.cardColors(Color.White)) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Column(Modifier.fillMaxWidth(.8f)) {
                Text(text = name ,
                    color=Color.Black,
                    fontSize = 22.sp ,
                    maxLines =1,
                    overflow = TextOverflow.Ellipsis,fontWeight = FontWeight.ExtraBold)
            }

            Image(painter = painterResource(id = R.drawable.second), contentDescription = name ,
                Modifier.size(65.dp),)
        }
    }

}

//@Preview(showBackground = true)
@Composable
fun ThirdCard(name : String ="Name"){

    Card(
        Modifier
            .fillMaxWidth()
            .height(80.dp),
        border = BorderStroke(1.dp,Color.Black),
        colors = CardDefaults.cardColors(Color.White)) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Column(Modifier.fillMaxWidth(.8f)) {
                Text(text = name ,
                    color=Color.Black,
                    fontSize = 22.sp ,
                    maxLines =1,
                    overflow = TextOverflow.Ellipsis,fontWeight = FontWeight.ExtraBold)
            }

            Image(painter = painterResource(id = R.drawable.third), contentDescription = name ,
                Modifier.size(65.dp),)
        }
    }

}