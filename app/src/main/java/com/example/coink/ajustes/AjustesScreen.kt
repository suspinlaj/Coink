package com.example.coink.ajustes

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coink.R
import com.example.coink.composables.ThemeSwitcher

@Composable

fun AjustesScreen(appClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //FONDO

        Image(
            painter = painterResource(id = R.drawable.fondo1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.elipse_ajustes),
            contentDescription = "Sombra",
            modifier = Modifier
                .size(width = 370.dp, height = 200.dp)
                .align(Alignment.BottomEnd)
                .padding(start = 70.dp)
                .offset(y = (25).dp)
                .offset(x = (-40).dp)

        )

        Image(
            painter = painterResource(id = R.drawable.img_ajustes),
            contentDescription = "Img Ajustes",
            modifier = Modifier
                .width(340.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp, start = 20.dp)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .drawBehind {
                    drawRoundRect(
                        color =  Color(216, 54, 144),
                        style = Stroke(width = 8.dp.toPx()),
                        cornerRadius = CornerRadius(16.dp.toPx())
                    )
                }
                .clip(RoundedCornerShape(16.dp))
                .background(Color(255, 236, 128)),
            contentAlignment = Alignment.Center
        ) {
            // ICONO AJUSTES

            Image(
                painter = painterResource(id = R.drawable.ajustes_icon2),
                contentDescription = "Icono Ajustes",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 20.dp,top = 33.dp)
                    .size(width = 35.dp, height = 35.dp)
            )

            // ICONO ATRAS

            Image(
                painter = painterResource(id = R.drawable.atras_icon),
                contentDescription = "Icono Añadir",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(width = 65.dp, height = 65.dp)
                    .padding(end = 20.dp, top = 33.dp)
                    .clip(RoundedCornerShape(30.dp)) // Redondea la silueta del ripple
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = LocalIndication.current // Usar ripple por defecto
                    ) {
                        appClick()
                    }
            )
            Text(
                text = "Ajustes",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 67.dp, top = 33.dp)
                    .offset(y = (-4.5).dp),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                    fontSize = 38.sp,
                    color = Color(216, 54, 144)
                )
            )
        }

        // BOX CAMBIAR GASTO MAXIM

        Box(
            modifier = Modifier
                .padding(top = 38.dp)
                .clip(RoundedCornerShape(48.dp))
                .background(Color(255, 163, 214))
                .height(40.dp)
                .width(320.dp)
                .border(
                    2.dp,
                    Color(216, 54, 144),
                    RoundedCornerShape(48.dp)
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current
                ) {
                    //cambiarGastoMaximo()
                },
            contentAlignment = Alignment.Center
        ) {
            Text (
                text = "Cambiar Gasto Máximo",
                modifier = Modifier.offset(y = (-3).dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                    fontSize = 25.sp,
                    color = Color(255, 236, 128)
                )
            )
        }

        // CAJA CAMBIAR MODO

        var isDarkTheme by remember { mutableStateOf(false) }

        // Aplica el tema según el estado
        MaterialTheme(
            colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()
        ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            ThemeSwitcher(
                isDarkTheme = isDarkTheme,
                onToggle = {
                    isDarkTheme = !isDarkTheme // 🔁 Cambia el tema
                }
            )
        } }

        // BOX CAMBIAR IDIOMA

        Box(
            modifier = Modifier
                .padding(top = 38.dp)
                .clip(RoundedCornerShape(48.dp))
                .background(Color(255, 163, 214))
                .height(40.dp)
                .width(320.dp)
                .border(
                    2.dp,
                    Color(216, 54, 144),
                    RoundedCornerShape(48.dp)
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current
                ) {
                    //cambiarIdioma()
                },
            contentAlignment = Alignment.Center
        ) {
            Text (
                text = "Cambiar Idioma",
                modifier = Modifier.offset(y = (-3).dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                    fontSize = 25.sp,
                    color = Color(255, 236, 128)
                )
            )
        }

    }
}