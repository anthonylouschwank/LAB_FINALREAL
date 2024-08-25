package com.example.lab3.ejemplos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.LAB3Theme

@Composable
fun LASLINEAS(){

}









@Preview(showBackground = true)
@Composable
private fun PreviewColumnAndRow() {
    LAB3Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LASLINEAS()
        }
    }
}

@Composable
fun EjerciciosLabsTheme(content: () -> Unit) {

}
