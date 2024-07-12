package com.example.appointmentsappuam.ui.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.appointmentsappuam.R

@Composable
fun AcceptDialog(title: String, content: String, onAccept: () -> Unit, onCancel: () -> Unit) {
    Dialog(
        onDismissRequest = { onCancel() },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = title, fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.neuehassdisplay_light))
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = content,
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                        fontFamily = FontFamily(Font(R.font.neuehassdisplay_light)),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { onCancel() },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.red)),
                        shape = ShapeDefaults.Medium,
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            fontSize = 15.sp,
                            color = colorResource(id = R.color.white),
                            fontFamily = FontFamily(Font(R.font.arial))
                        )
                    }
                    Button(
                        onClick = { onAccept() },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.aqua)),
                        shape = ShapeDefaults.Medium,
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.accept),
                            fontSize = 15.sp,
                            color = colorResource(id = R.color.white),
                            fontFamily = FontFamily(Font(R.font.arial))
                        )
                    }
                }
            }
        }
    }
}