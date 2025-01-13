package com.example.restaurante.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.restaurante.components.FloatButton
import com.example.restaurante.components.MainTopBar
import com.example.restaurante.viewmodel.PedidosViewModel

@Composable
fun HomeView(viewModel: PedidosViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "Lista De Pedidos", onClickAnction = { /*TODO*/ }) {
                navController.navigate("SearchPokeView")
            }
        },
                floatingActionButton = {
            FloatButton {
                navController.navigate("AddView")
            }

        }
    ) {
        ContentHomeView(viewModel = viewModel, it,navController)
    }

}
@Composable
fun ContentHomeView(viewModel: PedidosViewModel, it: PaddingValues, navController: NavController){
  /*  val pedido by viewModel.pedido.collectAsState()
    // Lista vertical
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Make the column fill the available space
            .padding(it) // Add padding around the content (adjust as needed)
    ) {
        items(pedido) { item ->
            // Order information card
            Card(
                modifier = Modifier
                    .fillMaxWidth() // Make the card span the full width
                    .padding(5.dp) // Add some padding inside the card
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth() // Ensure content stays within card
                ) {
                    Row( // Horizontal row for order details
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "ID:",
                            // Use appropriate style
                        )
                        Spacer(modifier = Modifier.weight(1f)) // Spacer for alignment
                        Text(text = item.id.toString())
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Fecha:")
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = item.fecha)
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Cliente:")
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = item.cliente)
                    }


                    // List of items with separator
                    this@LazyColumn.items(item.items) { listItem ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                            // Add padding between items
                        ) {
                            Text(text = listItem.nombreItem)
                            Spacer(modifier = Modifier.weight(1f)) // Spacer for alignment
                            Text(text = listItem.cantidad.toString())
                            Text(text = listItem.precioUnitario.toString())
                        }
                        // Add a divider line after each item (optional)
                        Divider(modifier = Modifier.padding(horizontal = 8.dp))
                    }
                }
            }
        }
    }*/
}