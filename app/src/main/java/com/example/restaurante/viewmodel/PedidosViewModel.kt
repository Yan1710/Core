package com.example.restaurante.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurante.model.Pedidos
import com.example.restaurante.repository.PedidoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PedidosViewModel @Inject constructor(private val repository: PedidoRepository) : ViewModel() {
    private val _pedi = MutableStateFlow<List<Pedidos>>(emptyList())
    val pedido = _pedi.asStateFlow()

    init {
       fetchPedido()
    }
    private fun fetchPedido() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getPedidos()
                _pedi.value = (result ?: emptyList()) as List<Pedidos>
            }
        }
    }
}