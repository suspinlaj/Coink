package com.example.coink.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
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

@Composable
fun AppScreen(viewModel: AppViewModel, historialClick:() -> Unit, ajustesClick:() -> Unit, addClick:() -> Unit) {

    val gastos = viewModel.gastos.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //FONDO

        Image(
            painter = painterResource(id = R.drawable.fondo2),
            contentDescription = "prueba",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.elipse),
            contentDescription = "Sombra",
            modifier = Modifier
                .size(width = 300.dp, height = 200.dp)
                .align(Alignment.BottomEnd)
                .padding(bottom = 0.dp)
                .offset(y = (25).dp)
                .offset(x = (-40).dp)

        )

        Image(
            painter = painterResource(id = R.drawable.seis),
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
                    .height(90.dp)
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

                // ICONO HISTORIAL

                Image(
                    painter = painterResource(id = R.drawable.historial_icon),
                    contentDescription = "Icono Historial",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp, top = 30.dp)
                        .size(width = 45.dp, height =45.dp)
                        .clip(RoundedCornerShape(10.dp)) // Redondea la silueta del ripple
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current // Usar ripple por defecto
                        ) {
                            historialClick()
                        }
                )

                // ICONO AÑADIR

                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Icono Añadir",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 30.dp)
                        .size(width = 60.dp, height = 60.dp)
                        .clip(RoundedCornerShape(30.dp)) // Redondea la silueta del ripple
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current // Usar ripple por defecto
                        ) {
                            addClick()
                        }
                )

                // ICONO AJUSTES

                Image(
                    painter = painterResource(id = R.drawable.ajustes_icon),
                    contentDescription = "Icono Ajustes",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 20.dp,top = 30.dp)
                        .size(width = 35.dp, height = 35.dp)
                        .clip(RoundedCornerShape(30.dp)) // Redondea la silueta del ripple
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current // Usar ripple por defecto
                        ) {
                            ajustesClick()
                        }
                )
            }

          gastos.value.let {
              if(it.isEmpty()) {

                  Image(
                      painter = painterResource(id = R.drawable.flecha),
                      contentDescription = " Flecha ",
                      modifier = Modifier
                          .padding(top = 25.dp)
                          .align(Alignment.CenterHorizontally)
                          .width(60.dp)
                  )

                  Box(
                      modifier = Modifier
                          .padding(top = 20.dp)
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
                          text = "Empieza añadiendo \n un nuevo gasto",
                          modifier = Modifier
                              .align(Alignment.Center)
                              .offset(y = (-4.5).dp),
                          textAlign = TextAlign.Center,
                          style = TextStyle(
                              fontFamily = FontFamily(Font(R.font.opciones_letra)),
                              fontSize = 30.sp,
                              color = Color(216, 54, 144)
                          )
                      )
                  }
              } else {
                  Column() {

                  }
              }
          }
        }
    }
}