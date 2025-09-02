package com.example.coink.app

import androidx.lifecycle.ViewModel
import com.example.coink.models.GastosModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// COMUNICA CON DOMAIN (donde está la lógica)

class AppViewModel(): ViewModel() {

    private val _gastos = MutableStateFlow<List<GastosModel>>(listOf())

    val gastos : StateFlow<List<GastosModel>> = _gastos

}