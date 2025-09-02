package com.example.coink.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coink.R

@Composable

fun Botones(principalClick:() -> Unit, historialClick:() -> Unit, ajustesClick:() -> Unit) {

        //BOTON PRINCIPAL

        Button(
            onClick = { principalClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 236, 128)
            ),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(48.dp),
            border = BorderStroke(2.dp, Color(216, 54, 144)),
            modifier = Modifier
                .padding(top = 90 .dp)
                .width(254.dp)
        ) {
            Text (
                text = "Principal",
                modifier = Modifier.offset(y = (-3).dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                    fontSize = 30.sp,
                    color = Color(216, 54, 144)
                )
            )
        }

        //BOTON HISTORIAL

        Button(
            onClick = { historialClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 163, 214),
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(48.dp),
            border = BorderStroke(2.dp, Color(216, 54, 144)),
            modifier = Modifier
                .padding(top = 35.dp)
                .width(254.dp)
        ) {
            Text (
                text = "Historial",
                modifier = Modifier.offset(y = (-3).dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                    fontSize = 30.sp,
                    color = Color(255, 236, 128)
                )
            )
        }

    //BOTON AJUSTES

    Button(
        onClick = { ajustesClick()},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(255, 236, 128)
        ),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(48.dp),
        border = BorderStroke(2.dp, Color(216, 54, 144)),
        modifier = Modifier
            .padding(top = 35.dp)
            .width(254.dp)
    ) {
        Text (
            text = "Ajustes",
            modifier = Modifier.offset(y = (-3).dp),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.opciones_letra)),
                fontSize = 30.sp,
                color = Color(216, 54, 144)
            )
        )
    }
    }
