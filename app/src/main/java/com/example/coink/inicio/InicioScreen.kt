package com.example.coink.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coink.R
import com.example.coink.composables.Botones

@Composable

fun InicioScreen(principalClick:() -> Unit, historialClick:() -> Unit, ajustesClick:() -> Unit) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .fillMaxSize()
        ) {
            //FONDO

            Image(
                painter = painterResource(id = R.drawable.fondo1),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            //IMAGEN NORMAL

            Image(
                painter = painterResource(id = R.drawable.cero),
                contentDescription = "Img Inicio",
                modifier = Modifier
                    .width(350.dp)
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 0.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.tit1),
                contentDescription = "Decoracion Titulo Rosa",
                modifier = Modifier
                    .width(70.dp)
                    .padding(top = 180.dp, start = 25.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.tit2),
                contentDescription = "Decoracion Titulo Amarillo",
                modifier = Modifier
                    .width(110.dp)
                    .align(Alignment.TopEnd)
                    .padding(top =63.dp)
            )


            // PONER TITULO CON DOS COLORES DIFERENTES

            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(255, 236, 128))) {
                    append("Co")
                }
                withStyle(style = SpanStyle(color = Color(255, 163, 214))) {
                    append("inK")
                }

            }



            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // TITULO

                Box() {
                    // BORDE SIMULADO
                    Text(
                        text = "CoinK",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.titulo_letra)),
                            fontSize = 130.sp,
                            color = Color(216, 54, 144), // COLOR BORDE
                            drawStyle = Stroke(width = 18f) // GROSOR BORDE
                        ),
                        modifier = Modifier.padding(top = 70.dp)
                    )

                    // TEXTO REAL ENCIMA

                    Text(
                        text = text,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.titulo_letra)),
                            fontSize = 130.sp,
                            color = Color.Unspecified // usa los colores definidos en el buildAnnotatedString
                        ),
                        modifier = Modifier.padding(top = 70.dp)
                    )
                }

                Botones(principalClick, historialClick, ajustesClick)
            }

        }
    }
}