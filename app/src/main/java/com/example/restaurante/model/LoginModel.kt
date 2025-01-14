package com.example.restaurante.model

data class DatosRequest(
    val email:String,
    val password:String
)
data class LoginResponse(
    val token:String
)