package com.example.appointmentsappuam.ui.ListadoProf

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ProfessorListScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val professors = listOf("Ing. Norman Cash", "Ing. Erika Mejia")
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
            ) {
                Text(professor)
            }
        }
    }
}
