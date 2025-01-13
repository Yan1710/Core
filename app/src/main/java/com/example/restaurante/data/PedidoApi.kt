package com.example.restaurante.data

import com.example.restaurante.model.PedidoModel
import com.example.restaurante.model.Pedidos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface PedidoApi {
    @GET("pedidos")
    suspend fun  getPedido() : Response<Array<Pedidos>>
    @POST("pedidos")
    suspend fun addPedido(pedido: PedidoModel) : Response<PedidoModel>

}