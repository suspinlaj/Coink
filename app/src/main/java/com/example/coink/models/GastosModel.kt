package com.example.coink.models

import java.util.Date


data class GastosModel(val id: Int, val cantidad: Double, val fecha: Date, val nombre: String, val comentario: String? = null)
