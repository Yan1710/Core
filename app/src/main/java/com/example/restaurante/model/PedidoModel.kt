package com.example.restaurante.model

data class PedidoModel(
    val result:Array<Pedidos>
)

data class Pedidos(
    val id:Int,
    val cliente:String,
    val fecha:String,
    val items : Array<Items>
)

data class Items(
    val nombreItem:String,
    val cantidad:Int,
    val precioUnitario:Double
)