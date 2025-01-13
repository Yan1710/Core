package com.example.restaurante.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.restaurante.R

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun cardSplash() {

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(),
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(15.dp)) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.gif_splash) // URL del GIF
                        .decoderFactory(ImageDecoderDecoder.Factory()) // Usar decoder para GIFs
                        .size(Size.ORIGINAL) // Tamaño original del GIF
                        .build(),
                    contentDescription = "Gif animado",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Altura del contenedor
                )
              }
         }
     }
}
