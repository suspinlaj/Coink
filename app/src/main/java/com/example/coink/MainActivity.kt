package com.example.coink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.coink.ui.theme.CoinkTheme
import com.example.coink.navigation.NavigationWrapper
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.foundation.isSystemInDarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Permite que el contenido se dibuje detrás de la barra de estado
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CoinkTheme(false) {
                val isDarkTheme = isSystemInDarkTheme()
                val statusBarColor = Color.Black

                SideEffect {
                    // Cambia el color del fondo de la barra de estado
                    window.statusBarColor = statusBarColor.toArgb()

                    // Cambia el color de los íconos según el tema
                    val insetsController = WindowInsetsControllerCompat(window, window.decorView)
                    insetsController.isAppearanceLightStatusBars = !isDarkTheme
                }

                NavigationWrapper()
            }
        }
    }
}
