package com.example.appointmentsappuam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appointmentsappuam.ui.login.LoginScreen
import com.example.appointmentsappuam.ui.main.MainScreen
import com.example.appointmentsappuam.ui.splash.SplashScreen
import com.example.appointmentsappuam.ui.Register.RegisterScreen
import com.example.appointmentsappuam.ui.AgendaCita.ScheduleMeetingScreen
import com.example.appointmentsappuam.ui.theme.AppointmentsAppUAMTheme
import com.example.appointmentsappuam.ui.TeacherProfile.UserProfileScreen
import com.example.appointmentsappuam.ui.profile.ProfileScreen
import com.example.appointmentsappuam.ui.ListadoProf.ProfessorListScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppointmentsAppUAMTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { LoginScreen(navController) }
        composable("splash") { SplashScreen(navController, onTimeout = { navController.navigate("main") }) }
        composable("main") { MainScreen(navController) }
        composable("Register") { RegisterScreen(navController) }
        composable("Meeting") { ScheduleMeetingScreen(navController) }
        composable("ProfileTeacher") { UserProfileScreen(navController) }
        composable("ProfileStudent") { ProfileScreen(navController) }
        composable("ListadoProf") { ProfessorListScreen(navController) }

    }
}
