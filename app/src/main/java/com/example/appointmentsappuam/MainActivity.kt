package com.example.appointmentsappuam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appointmentsappuam.ui.login.LoginScreen
import com.example.appointmentsappuam.ui.theme.AppointmentsAppUAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppointmentsAppUAMTheme {
                    LoginScreen()
            }
        }
    }
}

