package com.example.restaurante.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun WelcomeBackCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background( brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFFFFC),
                    Color(0xFFFFFFFC),
                    Color(0xFFFFFFFC)
                )
            )),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Orange Wave
            drawPath(
                path = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(width * 0.3f, 0f)
                    cubicTo(
                        width * 0.4f, height * 0.1f,
                        width * 0.2f, height * 0.3f,
                        0f, height * 0.4f
                    )
                    close()
                },
                color = Color(0xFFFF7F11)
            )

            // Blue Wave
            drawPath(
                path = Path().apply {
                    moveTo(width, height)
                    lineTo(width * 0.7f, height)
                    cubicTo(
                        width * 0.6f, height * 0.8f,
                        width * 0.8f, height * 0.6f,
                        width, height * 0.5f
                    )
                    close()
                },
                color = Color(0xFFFF7F11)
            )
        }

    }
}