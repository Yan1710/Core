package com.example.restaurante.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.restaurante.components.FloatButton
import com.example.restaurante.components.FloatButtonAdd
import com.example.restaurante.components.MainTopBar
import com.example.restaurante.viewmodel.PedidosViewModel

@Composable
fun AddView(viewModel: PedidosViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "Add Pedido", onClickAnction = { /*TODO*/ }) {
                navController.navigate("SearchPokeView")
            }
        }

    ) {
        ContentAddView(viewModel = viewModel, it,navController)
    }

}
@Composable
fun ContentAddView(viewModel: PedidosViewModel, it: PaddingValues, navController: NavController){
    var nombre by remember { mutableStateOf("") }
    var pedido by remember { mutableStateOf("") }
      OutlinedTextField(value = nombre, onValueChange = {nombre = it})
      OutlinedTextField(value = pedido, onValueChange = {pedido = it})

}