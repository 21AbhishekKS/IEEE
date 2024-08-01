package com.abhi.IEEE.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abhi.IEEE.Screens.AboutUs
import com.abhi.IEEE.Screens.BottomNav
import com.abhi.IEEE.Screens.Events
import com.abhi.IEEE.Screens.Home
import com.abhi.IEEE.Screens.Results
import com.abhi.IEEE.Screens.StartScreen

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController , startDestination = Routes.StartScreen.route ){

        composable(Routes.StartScreen.route){
        StartScreen(navHostController)
        }
        composable(Routes.Home.route){
        Home(navHostController)
        }
        composable(Routes.Events.route){
        Events(navHostController)
        }
        composable(Routes.Results.route){
        Results()
        }
        composable(Routes.AboutUs.route){
        AboutUs()
        }
        composable(Routes.BottomNav.route){
        BottomNav(navHostController)
        }

    }
}