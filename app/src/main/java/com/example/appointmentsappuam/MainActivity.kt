package com.example.appointmentsappuam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appointmentsappuam.ui.login.LoginScreen
import com.example.appointmentsappuam.ui.main.MainScreen
import com.example.appointmentsappuam.ui.splash.SplashScreen
import com.example.appointmentsappuam.ui.theme.AppointmentsAppUAMTheme
import com.example.appointmentsappuam.viewmodel.LoginViewModel

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AppointmentsAppUAMTheme {
//                Surface(modifier = Modifier.fillMaxSize()) {
//                    AppNavigation()
//                }
//            }
//        }
//    }
//}
//
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { LoginScreen(navController) }
        composable("splash") {
            SplashScreen(
                navController,
                onTimeout = { navController.navigate("main") })
        }
        composable("main") { MainScreen(navController) }

    }
}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val loginViewModel by viewModels<LoginViewModel>()
        val intent = Intent(this, MainActivity::class.java)
        val idUsuario = intent.getStringExtra("idUsuario")
        Log.d("USUARIOID", "USUARIO ID : ${intent.getStringExtra("idUsuario")}")
        setContent {
            AppointmentsAppUAMTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}