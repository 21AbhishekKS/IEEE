package com.abhi.ieee.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abhi.ieee.Model.BottomNavItem
import com.abhi.ieee.Navigation.Routes


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BottomNav(navHostController: NavHostController){

    val navController1 = rememberNavController()

    Scaffold(bottomBar = { MyBottomBar(navController1) }) { innerPadding ->

        NavHost(navController = navController1 , startDestination = Routes.Home.route ,
            modifier = Modifier.padding(innerPadding)){
            composable(Routes.Home.route){
                Home(navController1)
            }
            composable(Routes.Events.route){
                Events(navController1)
            }
            composable(Routes.Results.route){
                Results()
            }
            composable(Routes.AboutUs.route){
                AboutUs()
            }
            composable(Routes.EventShowScreen.route + "?description={description}&title={title}&members={members}&activeStatus={activeStatus}&first={first}&second={second}&third={third}&link={link}&date={date}"){
                var description = it.arguments?.getString("description")
                var title = it.arguments?.getString("title")
                var members = it.arguments?.getString("members")
                var activeStatus = it.arguments?.getString("activeStatus")
                var first = it.arguments?.getString("first")
                var second = it.arguments?.getString("second")
                var third = it.arguments?.getString("third")
                var link = it.arguments?.getString("link")
                var date = it.arguments?.getString("date")

                //  AddScreen(moneyViewModel , description ?: "" , amount ?: "" , updateMode?: false)


                    EventShowScreen(description ?: "" , title ?: "",
                        members ?: "", activeStatus ?: "" , first ?: "",
                        (second ?: "").toString(), (third ?: "").toString() , link?: "" ,date?: ""
                    )


            }

        }

    }
}

@Composable
fun MyBottomBar(navController1: NavHostController) {

    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItem(
            "Home",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ),

        BottomNavItem(
            "Events",
            Icons.Filled.DateRange,
            Icons.Outlined.DateRange
        ),
    
    BottomNavItem(
            "AboutUs",
            Icons.Filled.Info,
            Icons.Outlined.Info
        )
    )


    BottomAppBar(containerColor = Color.White, contentColor = Color.White){
        list.forEach{
            val selected = it.title == backStackEntry.value?.destination?.route

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor =  Color(84, 75, 100, 255),
                ),
                selected = selected,
                onClick = { navController1.navigate(it.title){
                    popUpTo(navController1.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                } },
                icon = { Icon(
                    imageVector = it.selectedIcon,
                    contentDescription = it.title,
                    tint = if (selected) Color.White else Color.Black // Set icon color based on selection
                )},
                label = { Text(text = it.title, color = Color.Black)})
        }
    }


}
