package com.example.coink.appMes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButtonDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import com.example.coink.R
import java.time.LocalDate
import java.util.Locale
import java.time.format.TextStyle.FULL

@Composable

fun AppMesScreen(aceptarClick: () -> Unit) {

    val mesActual = LocalDate.now().month.getDisplayName(FULL, Locale("es"))
    val mesCapitalizado = mesActual.replaceFirstChar { it.uppercase() }
    var numeroMaximoMes by remember { mutableStateOf("") }
    var mostrarDialogo by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //FONDO

        Image(
            painter = painterResource(id = R.drawable.fondo2),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.elipse),
            contentDescription = "Img Inicio",
            modifier = Modifier
                .size(width = 300.dp, height = 200.dp)
                .align(Alignment.BottomEnd)
                .padding(bottom = 0.dp)
                .offset(y = (25).dp)
                .offset(x = (-40).dp)

        )

        Image(
            painter = painterResource(id = R.drawable.cuatro),
            contentDescription = "Img Inicio",
            modifier = Modifier
                .width(294.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 43.dp, start = 20.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(105.dp)
                    .drawBehind {
                        drawRoundRect(
                            color =  Color(216, 54, 144),
                            style = Stroke(width = 8.dp.toPx()),
                            cornerRadius = CornerRadius(16.dp.toPx())
                        )
                    }
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(255, 163, 214)),
                contentAlignment = Alignment.Center
            ) {

                // Texto borde (simulando contorno)
                Text(
                    text = mesCapitalizado,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.titulo_letra)),
                        fontSize = 80.sp,
                        color = Color(216, 54, 144),
                        drawStyle = Stroke(width = 18f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center

                )

                // Texto relleno encima
                Text(
                    text = mesCapitalizado,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.titulo_letra)),
                        fontSize = 80.sp,
                        color = Color(255, 236, 128)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center
                )
            }


            // CAJA GASTAR MAXIMO

            Box(
                modifier = Modifier
                    .padding(top = 55.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(255, 236, 128))
                    .height(110.dp)
                    .width(270.dp)
                    .border(
                        2.dp,
                        Color(216, 54, 144),
                        RoundedCornerShape(20.dp)
                    )
            ) {
                Text(
                    text = "Quiero gastar \n un máximo de: ",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = (-4.5).dp),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.opciones_letra)),
                        fontSize = 35.sp,
                        color = Color(216, 54, 144)
                    )
                )
            }

            // CAJA INGRESAR DINERO

            var numeroMaximoMes by remember { mutableStateOf("") }
            val focusManager = LocalFocusManager.current

            Box(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .clip(RoundedCornerShape(48.dp))
                    .background(Color(255, 163, 214))
                    .height(60.dp)
                    .width(180.dp)
                    .border(
                        2.dp,
                        Color(216, 54, 144),
                        RoundedCornerShape(48.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    value = numeroMaximoMes,
                    onValueChange = {
                        numeroMaximoMes = it
                        if (it.isEmpty()) {
                            focusManager.clearFocus()
                        }
                    },
                    placeholder = {
                        Text(
                            text = "Ingrese aquí",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        unfocusedPlaceholderColor = Color(255, 236, 128),
                        focusedPlaceholderColor = Color(255, 236, 128, 117),
                        focusedTextColor = Color(255, 236, 128),
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                    ),
                    textStyle = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            //BOTON ACEPTAR

            Button(
                onClick = {
                    if (numeroMaximoMes.isEmpty()) {
                        mostrarDialogo = true
                    } else {
                        aceptarClick() // tu función para aceptar datos válidos
                    }
                },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(255, 236, 128),  // Fondo del botón
                    contentColor = Color(216, 54, 144)      // Color del texto
                ),
                border = BorderStroke(2.dp, Color(216, 54, 144)),
                modifier = Modifier
                    .padding(top = 37.dp)
                    .width(100.dp)
            ) {
                Text(
                    text = "Aceptar",
                    modifier = Modifier.offset(y = (-3).dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.opciones_letra)),
                        fontSize = 20.sp
                    )
                )

                // Diálogo de alerta

                if (mostrarDialogo) {
                    Dialog(onDismissRequest = { mostrarDialogo = false }) {
                        Box(
                            modifier = Modifier
                                .size(width = 300.dp, height = 210.dp)
                                .background(Color.Transparent) // Fondo transparente
                                .clip(RoundedCornerShape(20.dp))
                                .border(2.dp, Color(216, 54, 144), RoundedCornerShape(20.dp))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fondo_alerts),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .matchParentSize()
                                    .clip(RoundedCornerShape(20.dp))
                            )

                            Box(
                                modifier = Modifier
                                    .background(Color(255, 163, 214))
                                    .fillMaxWidth()
                                    .height(40.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.exclamacion),
                                    contentDescription = "Exclamacion",
                                    modifier = Modifier
                                        .align(Alignment.CenterStart)
                                        .padding(start = 15.dp)
                                        .size(20.dp)
                            )

                                Text(
                                    text = "Atención",
                                    fontSize = 27.sp,
                                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                                    fontWeight = FontWeight.Bold,
                                    color = Color(255, 236, 128),
                                    modifier = Modifier.padding(start = 35.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.cerrar_icon),
                                    contentDescription = "Cerrar",
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .padding(end = 10.dp)
                                        .size(35.dp)
                                        .clip(RoundedCornerShape(30.dp))
                                        .clickable(
                                            interactionSource = remember { MutableInteractionSource() },
                                            indication = LocalIndication.current
                                        ) {
                                            mostrarDialogo = false
                                        }

                                )
                                // Línea inferior
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .fillMaxWidth()
                                        .height(3.dp)
                                        .background(Color(216, 54, 144))
                                )
                            }

                            Text(
                                text = "Debes introducir una\n\ncifra antes de continuar !",
                                fontSize = 28.sp,
                                fontFamily = FontFamily(Font(R.font.opciones_letra)),
                                color = Color(216, 54, 144),
                                modifier = Modifier.padding(start = 15.dp, top = 50.dp)

                            )

                            Image(
                                painter = painterResource(id = R.drawable.img_alert),
                                contentDescription = "IMG ALERT",
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .size(140.dp)
                                    .padding(top = 50.dp, start = 20.dp)

                            )
                        }
                    }

                }
            }

        }
    }
}



