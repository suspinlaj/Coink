package com.example.coink.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.example.coink.R
import com.example.coink.models.Categoria

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridCategorias(
    categorias: List<Categoria>,
    onCategoriaClick: (Categoria) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categorias) { categoria ->
            Column(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .width(90.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .clickable { onCategoriaClick(categoria) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .width(88.dp)
                        .height(72.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .border(2.dp, Color(216, 54, 144), RoundedCornerShape(22.dp))
                        .background(Color(255, 236, 128))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = categoria.iconoId),
                        contentDescription = categoria.nombre.toString(),
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                /*Text(
                    text = categoria.nombre,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.opciones_letra)),
                    color = Color(216, 54, 144)
                )*/
            }
        }
    }
}
