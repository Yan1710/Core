package com.example.restaurante.repository

import com.example.restaurante.data.LoginApi
import com.example.restaurante.data.PedidoApi
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiPedido: LoginApi)  {
}