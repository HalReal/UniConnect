package com.example.appointmentsappuam.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.appointmentsappuam.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    var showMenu by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    val appointments = listOf(
        Appointment("Norman Cash Arcia", "10:00 AM", "Virtual", "Lunes"),
        Appointment("Erika Mejia Carcache", "2:00 PM", "Presencial", "Jueves")
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Citas agendadas", fontFamily = FontFamily(
                    Font(R.font.neuehassdisplay_light)
                ))
                },
                navigationIcon = {
                    IconButton(onClick = { showMenu = true }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { showDialog = true }) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(id = R.color.aqua)),
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                if (appointments.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(appointments) { appointment ->
                            AppointmentCard(appointment)
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No hay citas programadas", fontFamily = FontFamily(
                            Font(R.font.neuehassdisplay_light))
                        )
                    }
                }
            }
        }
    )

    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false }
    ) {
        DropdownMenuItem(
            text = { Text(text = "Mi Perfil") },
            onClick = { /* Handle option 1 */ })

        DropdownMenuItem(
            text = { Text(text = "Agendar cita") },
            onClick = { /* Handle option 1 */ })

        DropdownMenuItem(
            text = { Text(text = "Lista de docentes") },
            onClick = { /* Handle option 1 */ })

    }

    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
            properties = DialogProperties(dismissOnClickOutside = true)
        ) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Información", fontSize = 20.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Esta es una pantalla de inicio personalizada.",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { showDialog = false }) {
                        Text("Cerrar")
                    }
                }
            }
        }
    }
}

@Composable
fun AppointmentCard(appointment: Appointment) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Docente: ${appointment.docente}", fontSize = 18.sp)
            Text(text = "Hora: ${appointment.hora}", fontSize = 16.sp)
            Text(text = "Modalidad: ${appointment.modalidad}", fontSize = 16.sp)
            Text(text = "Día: ${appointment.dia}", fontSize = 16.sp)
        }
    }
}

data class Appointment(
    val docente: String,
    val hora: String,
    val modalidad: String,
    val dia: String
)