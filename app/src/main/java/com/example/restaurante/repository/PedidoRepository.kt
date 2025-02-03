package com.example.restaurante.repository

import com.example.restaurante.data.PedidoApi
import com.example.restaurante.model.PedidoModel
import com.example.restaurante.model.Pedidos
import okio.IOException
import javax.inject.Inject

class PedidoRepository @Inject constructor(private val apiPedido:PedidoApi) {

    suspend fun getPedidos(): List<Pedidos>? {
     try {
         val response = apiPedido.getPedido()
         if(response.isSuccessful){
             return response.body()?.toList()
         }
     }catch (e: IOException){
         return emptyList();
     }
        return emptyList();
    }
}