package com.example.appointmentsappuam.ui.AgendaCita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon

@Composable
fun ScheduleMeetingScreen(navController: NavHostController) {
    var professorName by remember { mutableStateOf("") }
    var isOnline by remember { mutableStateOf(true) }
    var location by remember { mutableStateOf("") }
    var hour by remember { mutableStateOf("") }
    var minute by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }

    var showMenu by remember { mutableStateOf(false) }

    val isFormValid by remember {
        derivedStateOf {
            professorName.isNotBlank() &&
                    (isOnline || location.isNotBlank()) &&
                    hour.isNotBlank() &&
                    minute.isNotBlank() &&
                    day.isNotBlank() &&
                    month.isNotBlank() &&
                    year.isNotBlank()
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Dropdown menu in the top right corner
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            IconButton(onClick = { showMenu = true }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Mi Perfil") },
                    onClick = { navController.navigate("ProfileStudent") }
                )
                DropdownMenuItem(
                    text = { Text(text = "Agendar cita") },
                    onClick = { navController.navigate("Meeting") }
                )
                DropdownMenuItem(
                    text = { Text(text = "Lista de docentes") },
                    onClick = { navController.navigate("ListadoProf") }
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Agendar una cita", fontSize = 25.sp)

        OutlinedTextField(
            value = professorName,
            onValueChange = { professorName = it },
            label = { Text("Nombre profesor") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isOnline,
                    onCheckedChange = {
                        isOnline = true
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF009688),
                        uncheckedColor = Color.Gray,
                        checkmarkColor = Color.White
                    )
                )
                Text("Online")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = !isOnline,
                    onCheckedChange = {
                        isOnline = false
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF009688),
                        uncheckedColor = Color.Gray,
                        checkmarkColor = Color.White
                    )
                )
                Text("Presencial")
            }
        }
        if (!isOnline) {
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Ubicación") },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Hora", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(25.dp))
            OutlinedTextField(
                value = hour,
                onValueChange = { hour = it },
                label = { Text("00") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(":", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = minute,
                onValueChange = { minute = it },
                label = { Text("00") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(64.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Fecha", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = day,
                onValueChange = { day = it },
                label = { Text("dd") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("/")
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = month,
                onValueChange = { month = it },
                label = { Text("mm") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("/")
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = year,
                onValueChange = { year = it },
                label = { Text("yy") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(64.dp)
            )
        }
        OutlinedTextField(
            value = reason,
            onValueChange = { reason = it },
            label = { Text("Motivo") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { navController.navigate("main") },
            enabled = isFormValid,
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
        ) {
            Text("Enviar propuesta")
        }
    }
}
