package com.abhi.ieee.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abhi.ieee.Screens.AboutUs
import com.abhi.ieee.Screens.BottomNav
import com.abhi.ieee.Screens.Events
import com.abhi.ieee.Screens.Home
import com.abhi.ieee.Screens.Results
import com.abhi.ieee.Screens.StartScreen

@Composable
fun NavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController , startDestination = Routes.StartScreen.route ){

        composable(Routes.StartScreen.route){
        StartScreen(navHostController)
        }
        composable(Routes.Home.route){
        Home()
        }
        composable(Routes.Events.route){
        Events()
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