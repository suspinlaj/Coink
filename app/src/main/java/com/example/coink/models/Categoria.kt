package com.example.coink.models

import com.example.coink.R
import com.example.coink.models.NombreCategorias.*


data class Categoria(
    val nombre: NombreCategorias,
    val iconoId: Int
)

val categorias = listOf(
    Categoria(COMIDA, R.drawable.ic_comida),
    Categoria(COCHE, R.drawable.ic_coche),
    Categoria(BEBIDA, R.drawable.ic_bebida),
    Categoria(NOMINA, R.drawable.ic_nomina),
    Categoria(TELEFONO, R.drawable.ic_telefono),
    Categoria(REGALO, R.drawable.ic_regalo),
    Categoria(DEPORTE, R.drawable.ic_deporte),
    Categoria(VIAJE, R.drawable.ic_viaje),
    Categoria(ROPA, R.drawable.ic_ropa),
    Categoria(CALZADO, R.drawable.ic_calzado),
    Categoria(BELLEZA, R.drawable.ic_belleza),
    Categoria(TRANSPORTE, R.drawable.ic_transporte),
    Categoria(AGUA, R.drawable.ic_agua),
    Categoria(LUZ, R.drawable.ic_luz),
    Categoria(GAS, R.drawable.ic_gas),
    Categoria(MEDICAMENTO, R.drawable.ic_medicamento),
    Categoria(DEVOLUCION, R.drawable.ic_devolucion),
    Categoria(CREAR, R.drawable.ic_crear),
)
