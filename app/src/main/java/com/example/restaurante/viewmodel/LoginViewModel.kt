package com.example.restaurante.viewmodel

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurante.model.LoginResponse
import com.example.restaurante.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository, application: Application) : AndroidViewModel(application) {
    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginresponse: MutableLiveData<LoginResponse?> = _loginResponse

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.login(email, password)
                _loginResponse.postValue(response)
                response.let {  saveToken(_loginResponse.value.toString()) }
                true // Login exitoso
            } catch (e: Exception) {
                _loginResponse.postValue(null)
                false // Login fallido
            }
        }
    }

    fun saveToken(token:String){
        val prefs: SharedPreferences = getApplication<Application>().getSharedPreferences("my_prefs", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("jwt_token", token)
        editor.apply()
    }

    suspend fun loginForFingerprint(email: String, password: String): Boolean {

        val prefs: SharedPreferences = getApplication<Application>().getSharedPreferences("my_prefs", MODE_PRIVATE)

        if(prefs.contains(email)){

        }
        return true
    }

}

