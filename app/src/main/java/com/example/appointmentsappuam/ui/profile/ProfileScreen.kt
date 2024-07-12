package com.example.appointmentsappuam.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
    ) {
        TopBar(navController)
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xFF203D3F))
                .padding(12.dp)
        ) {
            BasicText(
                text = "Perfil",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.align(Alignment.Start)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                ProfileHeader()
                Spacer(modifier = Modifier.height(8.dp))
                CareerCard("Ingeniería en Sistemas de Información")
                Spacer(modifier = Modifier.height(40.dp))
                SubjectCard("Física Aplicada (Grupo 1)")
                Spacer(modifier = Modifier.height(8.dp))
                SubjectCard("Administración y Gestión de Base de Datos (Grupo 2)")
                Spacer(modifier = Modifier.height(8.dp))
                SubjectCard("Programación Orientada a Objetos 2 (Grupo 2)")
                Spacer(modifier = Modifier.height(8.dp))
                SubjectCard("Análisis y Diseño Orientado a Objetos (Grupo 1)")
            }
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB71C1C)),
                shape = RoundedCornerShape(8.dp)
            ) {
                BasicText(
                    text = "Cerrar Sesión",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(138.dp)
            .background(Color(0xFF256767))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                IconButton(onClick = { expanded = true }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Mi Perfil") },
                        onClick = {
                            navController.navigate("ProfileStudent")
                            expanded = false
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = "Agendar cita") },
                        onClick = {
                            navController.navigate("Meeting")
                            expanded = false
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = "Lista de docentes") },
                        onClick = {
                            navController.navigate("ListadoProf")
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            BasicText(
                text = "Edmundo Gabriel Martinez De Valle",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun ProfileImage() {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(Color.Gray, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = "EM",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun CareerCard(career: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = career,
            style = TextStyle(
                fontSize = 16.sp
            )
        )
    }
}

@Composable
fun SubjectCard(subject: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            modifier = Modifier.fillMaxWidth(),
            text = subject,
            style = TextStyle(
                fontSize = 16.sp
            )
        )
    }
}
