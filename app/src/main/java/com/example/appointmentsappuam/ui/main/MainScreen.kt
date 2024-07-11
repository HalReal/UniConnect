package com.example.appointmentsappuam.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyApp() {
//    var showMenu by remember { mutableStateOf(false) }
//    var showDialog by remember { mutableStateOf(false) }
//    val appointments = listOf(
//        Appointment("Dr. Smith", "10:00 AM", "Online", "Monday"),
//        Appointment("Dr. Brown", "2:00 PM", "In Person", "Tuesday")
//    )
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Inicio") },
//                navigationIcon = {
//                    IconButton(onClick = { showMenu = true }) {
//                        Icon(Icons.Default.Menu, contentDescription = "Menu")
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { showDialog = true }) {
//                        Icon(Icons.Default.Info, contentDescription = "Info")
//                    }
//                },
//                backgroundColor = Color.Blue,
//                contentColor = Color.White
//            )
//        },
//        content = {
//            if (appointments.isNotEmpty()) {
//                LazyColumn(
//                    modifier = Modifier.fillMaxSize(),
//                    contentPadding = PaddingValues(16.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    items(appointments) { appointment ->
//                        AppointmentCard(appointment)
//                    }
//                }
//            } else {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "No hay citas programadas")
//                }
//            }
//        }
//    )
//
//    if (showMenu) {
//        DropdownMenu(
//            expanded = showMenu,
//            onDismissRequest = { showMenu = false }
//        ) {
//            DropdownMenuItem(onClick = { /* Handle option 1 */ }) {
//                Text("Opción 1")
//            }
//            DropdownMenuItem(onClick = { /* Handle option 2 */ }) {
//                Text("Opción 2")
//            }
//            DropdownMenuItem(onClick = { /* Handle option 3 */ }) {
//                Text("Opción 3")
//            }
//            DropdownMenuItem(onClick = { /* Handle option 4 */ }) {
//                Text("Opción 4")
//            }
//        }
//    }
//
//    if (showDialog) {
//        Dialog(
//            onDismissRequest = { showDialog = false },
//            properties = DialogProperties(dismissOnClickOutside = true)
//        ) {
//            Surface(
//                shape = MaterialTheme.shapes.medium,
//                elevation = 24.dp
//            ) {
//                Column(
//                    modifier = Modifier.padding(16.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "Información", fontSize = 20.sp, color = Color.Black)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(text = "Esta es una pantalla de inicio personalizada.", color = Color.Black)
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = { showDialog = false }) {
//                        Text("Cerrar")
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun AppointmentCard(appointment: Appointment) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        elevation = 8.dp
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "Docente: ${appointment.docente}", fontSize = 18.sp)
//            Text(text = "Hora: ${appointment.hora}", fontSize = 16.sp)
//            Text(text = "Modalidad: ${appointment.modalidad}", fontSize = 16.sp)
//            Text(text = "Día: ${appointment.dia}", fontSize = 16.sp)
//        }
//    }
//}
//
//data class Appointment(val docente: String, val hora: String, val modalidad: String, val dia: String)
