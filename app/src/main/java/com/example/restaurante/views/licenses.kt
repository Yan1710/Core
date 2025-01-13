package com.example.restaurante.views

import android.Manifest
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.example.restaurante.components.Loading
import com.example.restaurante.viewmodel.LincenseVM

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.delay


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Licenses(lincenseVM: LincenseVM, navController: NavController) {
    val permissions = rememberMultiplePermissionsState(
        lincenseVM.requestPermissions()
    )
    val allPermissionsGranted = permissions.allPermissionsGranted
    LaunchedEffect(allPermissionsGranted) {
        if (allPermissionsGranted) {
            navController.navigate("login")
        } else {
            permissions.launchMultiplePermissionRequest()
        }
    }

    if (!allPermissionsGranted) {
        Loading(isLoading = true)
    } else {
        Loading(isLoading = false)
    }

}
