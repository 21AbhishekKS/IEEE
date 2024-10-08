package com.abhi.IEEE.Navigation

sealed class Routes(val route : String) {

    object StartScreen : Routes("StartScreen")
    object Home : Routes("Home")
    object Events : Routes("Events")
    object Results : Routes("Results")
    object AboutUs : Routes("AboutUs")
    object BottomNav : Routes("BottomNav")

    object EventShowScreen : Routes("EventShowScreen")

}