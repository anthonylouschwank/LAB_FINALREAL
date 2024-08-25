package com.example.lab3.ejemplos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab3.ui.theme.LAB3Theme

@Composable
fun WeightEnLayouts(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .background(MaterialTheme.colorScheme.error),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(MaterialTheme.colorScheme.primary),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(MaterialTheme.colorScheme.secondary),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewWeightEnLayouts() {
    LAB3Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            WeightEnLayouts(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
