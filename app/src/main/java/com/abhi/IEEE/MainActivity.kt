package com.abhi.IEEE

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.abhi.IEEE.Navigation.NavGraph
import com.abhi.IEEE.ui.theme.IEEETheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        installSplashScreen()
        setContent {
            IEEETheme {


                val navController = rememberNavController()
                NavGraph(navHostController = navController)





               // StartScreen()
            }
        }
    }
}

