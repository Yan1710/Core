package com.example.restaurante.viewmodel

import androidx.lifecycle.ViewModel
import com.example.restaurante.repository.LoginRepository
import com.example.restaurante.repository.PedidoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val repository: LoginRepository) : ViewModel() {

}