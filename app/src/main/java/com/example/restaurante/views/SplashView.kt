package com.example.restaurante.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.restaurante.components.cardSplash
import com.example.restaurante.ui.theme.Color1
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun Splash(navController: NavController) {
    val showSplash = remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    if (showSplash.value) {
        Log.d("Lauched", "Splash: 1 ")
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color1),
            contentAlignment = Alignment.Center,
        ) {
            cardSplash()
        }
    }

    LaunchedEffect(true) {
        Log.d("Lauched", "Splash: 2 ")
        coroutineScope.launch {
            delay(2000)
            Log.d("Lauched", "Splash: ")
            showSplash.value = false
            navController.navigate("licenses")
        }
    }
}