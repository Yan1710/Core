package com.example.restaurante.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurante.R
import com.example.restaurante.ui.theme.Color1

@Composable
fun menuIcon(){
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(15.dp)) {
            Column(modifier = Modifier.align(Alignment.Center),horizontalAlignment = Alignment.CenterHorizontally) {
             Image(painter = painterResource(id = R.drawable.menu), contentDescription = "")
            }
        }

    }
}