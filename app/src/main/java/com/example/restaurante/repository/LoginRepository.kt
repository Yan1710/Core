package com.example.restaurante.repository

import com.example.restaurante.data.LoginApi
import com.example.restaurante.data.PedidoApi
import com.example.restaurante.model.DatosRequest
import com.example.restaurante.model.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiPedido: LoginApi) {

    suspend fun login(email: String, password: String): LoginResponse? {
        var datosrequest = DatosRequest(email, password)
        val response = apiPedido.login(datosrequest)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}