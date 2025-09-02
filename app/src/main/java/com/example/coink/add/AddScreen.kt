package com.example.coink.add

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
import com.example.coink.composables.GridCategorias
import com.example.coink.models.categorias

@Composable
fun AddScreen(appClick: () -> Unit) {

    // Estado para los botones
    var showFirstImageMas by remember { mutableStateOf(false) }
    var showFirstImageMenos by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.fondo2),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // TITULO
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(216, 54, 144),
                            style = Stroke(width = 8.dp.toPx()),
                            cornerRadius = CornerRadius(16.dp.toPx())
                        )
                    }
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(255, 163, 214)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Icono Añadir",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 10.dp, top = 33.dp)
                        .size(40.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.atras_icon2),
                    contentDescription = "Icono Atrás",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(top = 33.dp, end = 10.dp)
                        .size(43.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current
                        ) {
                            appClick()
                        }
                )

                Text(
                    text = "Añadir Gasto/Ahorro",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 50.dp, top = 35.dp)
                        .offset(y = (-4.5).dp),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.opciones_letra)),
                        fontSize = 33.sp,
                        color = Color(255, 236, 128)
                    )
                )
            }
        }

        // BOTONES OPCIONES
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            GridCategorias(categorias = categorias) { seleccionada ->
                // Aquí haces lo que quieras con la categoría seleccionada
                println("Pulsada: ${seleccionada.nombre}")
            }

        }

        // FORMA CON MUESCA
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Canvas(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(140.dp)
                ) {
                    val width = size.width
                    val height = size.height
                    val notchRadiusHorizontal = 70.dp.toPx()
                    val notchRadiusVertical = 60.dp.toPx()
                    val centerX = width / 2
                    val strokeWidth = 4.dp.toPx()

                    val backgroundPath = Path().apply {
                        moveTo(0f, strokeWidth)
                        lineTo(centerX - notchRadiusHorizontal - 10f, strokeWidth)
                        cubicTo(
                            centerX - notchRadiusHorizontal, strokeWidth,
                            centerX - notchRadiusHorizontal, notchRadiusVertical + strokeWidth,
                            centerX, notchRadiusVertical + strokeWidth
                        )
                        cubicTo(
                            centerX + notchRadiusHorizontal, notchRadiusVertical + strokeWidth,
                            centerX + notchRadiusHorizontal, strokeWidth,
                            centerX + notchRadiusHorizontal + 10f, strokeWidth
                        )
                        lineTo(width, strokeWidth)
                        lineTo(width, height)
                        lineTo(0f, height)
                        close()
                    }

                    drawPath(path = backgroundPath, color = Color(255, 163, 214))

                    val borderPath = Path().apply {
                        moveTo(0f, strokeWidth)
                        lineTo(centerX - notchRadiusHorizontal - 10f, strokeWidth)
                        cubicTo(
                            centerX - notchRadiusHorizontal, strokeWidth,
                            centerX - notchRadiusHorizontal, notchRadiusVertical + strokeWidth,
                            centerX, notchRadiusVertical + strokeWidth
                        )
                        cubicTo(
                            centerX + notchRadiusHorizontal, notchRadiusVertical + strokeWidth,
                            centerX + notchRadiusHorizontal, strokeWidth,
                            centerX + notchRadiusHorizontal + 10f, strokeWidth
                        )
                        lineTo(width, strokeWidth)
                    }

                    drawPath(
                        path = borderPath,
                        color = Color(216, 54, 144),
                        style = Stroke(width = strokeWidth)
                    )
                }

                // BOTÓN MÁS
                Image(
                    painter = painterResource(id = R.drawable.img_add),
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp)
                        .offset(y = (-60).dp)
                )

                Image(
                    painter = painterResource(
                        id = if (showFirstImageMas) R.drawable.add_icon_pulsado else R.drawable.add_icon1
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(110.dp)
                        .padding(start = 30.dp)
                        .offset(y = (-30).dp)
                        .align(Alignment.BottomStart)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            if (showFirstImageMas) {
                                showFirstImageMas = false
                            } else {
                                showFirstImageMas = true
                                showFirstImageMenos = false
                            }
                        }
                )

                // BOTÓN MENOS
                Image(
                    painter = painterResource(
                        id = if (showFirstImageMenos) R.drawable.menos_icon_pulsado else R.drawable.menos_icon1
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(105.dp)
                        .padding(end = 25.dp)
                        .offset(y = (-32).dp)
                        .align(Alignment.BottomEnd)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            if (showFirstImageMenos) {
                                showFirstImageMenos = false
                            } else {
                                showFirstImageMenos = true
                                showFirstImageMas = false
                            }
                        }
                )
            }
        }
    }
}
