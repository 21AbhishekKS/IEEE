package com.abhi.ieee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.abhi.ieee.Navigation.NavGraph
import com.abhi.ieee.ui.theme.IEEETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IEEETheme {


                val navController = rememberNavController()
                NavGraph(navHostController = navController)





               // StartScreen()
            }
        }
    }
}

