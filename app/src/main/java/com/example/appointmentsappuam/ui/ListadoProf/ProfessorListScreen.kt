package com.example.appointmentsappuam.ui.ListadoProf

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.navigation.NavHostController
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
@Composable
fun ProfessorListScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    val professors = listOf("Ing. Norman Cash", "Ing. Erika Mejia", "Ing. Yader Lopez")
    val scrollState = rememberScrollState()
    var showMenu by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
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
        Text(
            text = "Listado de Profesores",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Divider(
            color = Color(0xFF009688),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        professors.forEach { professor ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.LightGray.copy(alpha = 0.5f))
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("ProfileTeacher")
                    }
            ) {
                Text(professor)
            }
        }
    }
}