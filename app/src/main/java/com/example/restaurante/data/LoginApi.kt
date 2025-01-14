package com.example.restaurante.data

import com.example.restaurante.model.DatosRequest
import com.example.restaurante.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("usuarios/login")
    suspend fun login(
       @Body datos: DatosRequest
    ): Response<LoginResponse>

}