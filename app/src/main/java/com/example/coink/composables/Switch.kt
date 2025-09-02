package com.example.coink.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coink.R

@Composable
fun ThemeSwitcher(
    isDarkTheme: Boolean,
    onToggle: () -> Unit
) {
    val thumbOffset by animateDpAsState(
        targetValue = if (isDarkTheme) 36.dp else 0.dp,
        label = "Switch Animation"
    )

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(48.dp))
            .background(Color(255, 236, 128))
            .height(50.dp)
            .width(320.dp)
            .border(
                2.dp,
                Color(216, 54, 144),
                RoundedCornerShape(48.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = "Modo Claro",
                color = Color(216, 54, 144),
                fontFamily = FontFamily(Font(R.font.opciones_letra)),
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // 🔧 Switch personalizado

            val maxOffset = 50.dp - 25.dp  // ancho padre - tamaño thumb
            val limitedOffset = thumbOffset.coerceIn(0.dp, maxOffset)

            Box(
                modifier = Modifier
                    .padding(start = 3.dp)
                    .width(50.dp)
                    .height(25.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(216, 54, 144))
                    .clickable { onToggle() }
            ) {
                Box(
                    modifier = Modifier
                        .size(25.dp)  // Igual al alto del padre para que no sobresalga
                        .offset(x = limitedOffset)
                        .background(Color(255, 236, 128), CircleShape)
                        .border(2.dp, Color(216, 54, 144), CircleShape)
                )
            }


            Text(
                text = "Modo Oscuro",
                color = Color(216, 54, 144),
                fontFamily = FontFamily(Font(R.font.opciones_letra)),
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 4.dp, start = 3.dp)
            )
        }
    }
}
