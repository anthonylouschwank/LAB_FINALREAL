package com.example.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5.ui.theme.LAB5Theme
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward

import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB5Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Primera Card - Actualización disponible
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Flecha",
                            tint = Color(0xFF0288D1)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Actualización disponible",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                    }
                    BotonDescargar()
                }
            }

            // Segunda Card - Día y Fecha
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Lunes",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "1 de Enero",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
                Box(
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Button(
                        onClick = {  }, //No se especifico que haria
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7B1FA2)
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(text = "Terminar Jornada")
                    }
                }
            }

            // Tercera Card - Información detallada
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Guenari",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        IconoAbrirUbicacion()
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "16 Calle 2, Cdad. de Guatemala",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "10:00AM - 8:30PM",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ToastButton(text = "Iniciar", message = "Anthony Lou Schwank")
                        ToastButton(text = "Detalles", message = "Comida China\nQQ")
                    }
                }
            }
        }
    }
}

@Composable
fun BotonDescargar() {

    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
        setPackage("com.android.vending")
    }

    TextButton(onClick = {
        context.startActivity(intent)
    }) {
        Text(
            text = "Descargar",
            color = Color(0xFF0288D1)
        )
    }
}

@Composable
fun IconoAbrirUbicacion(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("geo:0,0?q=Guenari, 16 Calle 2, Cdad. de Guatemala 01010")
        setPackage("com.google.android.apps.maps")
    }

    Icon(
        imageVector = Icons.Filled.ArrowForward,
        contentDescription = "Flecha",
        tint = Color(0xFF6200EA),
        modifier = modifier.clickable {
            context.startActivity(intent)
        }
    )
}

@Composable
fun ToastButton(text: String, message: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF6F61)
        ),
        modifier = modifier
    ) {
        Text(text = text)
    }
}
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LAB5Theme {
        MainScreen()
    }
}



