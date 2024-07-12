package com.example.appointmentsappuam.ui.AgendaCita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


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
        OutlinedTextField(
            value = professorName,
            onValueChange = { professorName = it },
            label = { Text("Nombre profesor") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Column {
            Row {
                Checkbox(
                    checked = isOnline,
                    onCheckedChange = {
                        isOnline = true
                    }
                )
                Text("Online")
            }
            Row {
                Checkbox(
                    checked = !isOnline,
                    onCheckedChange = {
                        isOnline = false
                    }
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
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = hour,
                onValueChange = { hour = it },
                label = { Text("00") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(56.dp)
            )
            Text(":")
            OutlinedTextField(
                value = minute,
                onValueChange = { minute = it },
                label = { Text("00") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(56.dp)
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
            Text("/")
            OutlinedTextField(
                value = month,
                onValueChange = { month = it },
                label = { Text("mm") },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(64.dp)
            )
            Text("/")
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
            onClick = { /* Acción para enviar la propuesta */ },
            enabled = isFormValid,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar propuesta")
        }
    }
}
