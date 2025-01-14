package com.example.restaurante.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurante.model.LoginResponse
import com.example.restaurante.repository.LoginRepository
import com.example.restaurante.repository.PedidoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {
    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginresponse: MutableLiveData<LoginResponse?> = _loginResponse

    suspend fun Login(email: String, password: String):Boolean {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
              val response =  repository.login(email, password)
                    _loginResponse.value = response
            }
        }
        if(_loginResponse.value != null){
            return true
        }
        return false
    }
}
