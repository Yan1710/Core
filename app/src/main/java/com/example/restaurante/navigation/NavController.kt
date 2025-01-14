package com.example.restaurante.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.restaurante.viewmodel.LincenseVM
import com.example.restaurante.viewmodel.LoginViewModel
import com.example.restaurante.viewmodel.PedidosViewModel
import com.example.restaurante.views.AddView
import com.example.restaurante.views.HomeView
import com.example.restaurante.views.Licenses
import com.example.restaurante.views.LoginView
import com.example.restaurante.views.Splash

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavManager(viewModel: PedidosViewModel,viewModel1: LincenseVM,loginViewModel: LoginViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash"){
        composable("Home"){
            HomeView(viewModel, navController)
        }
        composable("AddView"){
            AddView(viewModel, navController)
        }
        composable("Splash"){
            Splash(navController)
        }
        composable("licenses") {
            Licenses(viewModel1, navController)
        }
        composable("login"){
            LoginView(loginViewModel,navController = navController)
        }

    }
}