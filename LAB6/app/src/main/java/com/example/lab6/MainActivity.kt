package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6.ui.theme.LAB6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB6Theme {
                ContadorPantalla()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorPantalla() {
    var count by remember { mutableStateOf(0) }
    var changes by remember { mutableStateOf(0) }
    var increments by remember { mutableStateOf(0) }
    var decrements by remember { mutableStateOf(0) }
    var history by remember { mutableStateOf(listOf<Pair<Int, Boolean>>()) } // Pair(valor, esIncremento)
    val maxNumber = history.maxOfOrNull { it.first } ?: "No values"
    val minNumber = history.minOfOrNull { it.first } ?: "No values"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "")
        Text(text = "Anthony Lou Schwank")

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
        ) {
            Button(onClick = {
                count--
                changes++
                decrements++
                if (count != 0) {
                    history = history + (count to false) // false para decremento
                }
            }) {
                Text(text = "-")
            }

            Text(
                text = "$count",
                textAlign = TextAlign.End,
                fontSize = 25.sp,
            )

            Button(onClick = {
                count++
                changes++
                increments++
                if (count != 0) {
                    history = history + (count to true) // true para incremento
                }
            }) {
                Text(text = "+")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            // Incrementos
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 5.dp)
            ) {
                Text(
                    text = "Total Incrementos:",
                    fontSize = 25.sp,
                )
                Text(
                    text = "$increments",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    fontSize = 25.sp,
                )
            }
            // Decrementos
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 5.dp)
            ) {
                Text(
                    text = "Total Decrementos:",
                    fontSize = 25.sp,
                )
                Text(
                    text = "$decrements",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    fontSize = 25.sp,
                )
            }
            // Valor Máximo
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 5.dp)
            ) {
                Text(
                    text = "Valor Maximo:",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                )
                Text(
                    text = "$maxNumber",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    fontSize = 25.sp,
                )
            }
            // Valor Mínimo
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 5.dp)
            ) {
                Text(
                    text = "Valor Minimo:",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                )
                Text(
                    text = "$minNumber",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    fontSize = 25.sp,
                )
            }
            // Total Cambios
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 5.dp)
            ) {
                Text(
                    text = "Total Cambios:",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                )
                Text(
                    text = "$changes",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    fontSize = 25.sp,
                )
            }
            // Historial
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp, 5.dp)
            ) {
                Text(
                    text = "Historial:",
                    modifier = Modifier.weight(1f),
                    fontSize = 25.sp,
                )
                Text(
                    text = "",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    fontSize = 25.sp,
                )
            }

            // Botón de Reinicio
            Button(onClick = {
                count = 0
                changes = 0
                increments = 0
                decrements = 0
                history = listOf() // Reiniciar el historial
            }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Reiniciar")
            }

            LazyVerticalGrid(columns = GridCells.Fixed(5)) {
                items(history) { (value, isIncrement) ->
                    val backgroundColor = if (isIncrement) Color.Green else Color.Red

                    OutlinedCard(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .background(backgroundColor),
                        content = {
                            Text(
                                text = "$value",
                                modifier = Modifier.padding(8.dp),
                                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                                color = Color.Black
                            )
                        }
                    )
                }
            }
        }


    }
}

