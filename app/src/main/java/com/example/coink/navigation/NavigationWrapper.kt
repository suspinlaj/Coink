package com.example.coink.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.coink.add.AddScreen
import com.example.coink.ajustes.AjustesScreen
import com.example.coink.app.AppScreen
import com.example.coink.app.AppViewModel
import com.example.coink.appMes.AppMesScreen
import com.example.coink.historial.HistorialScreen
import com.example.coink.inicio.InicioScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    val isFirst = true

    NavHost(navController, startDestination = Inicio) {
        composable<Inicio> {
            InicioScreen({
                if (isFirst) {
                    navController.navigate(AppMes)
                } else {
                    navController.navigate(App)
                }
            }, {
                navController.navigate(Historial)
            }, {
                navController.navigate(Ajustes)
            }
            )
        }
        composable<AppMes> {
            AppMesScreen({
                navController.navigate(App)
            })
        }

        composable<App> {
            val viewModel = AppViewModel()

            AppScreen(
                viewModel,
                {
                    navController.navigate(Historial)
                }, {
                    navController.navigate(Ajustes)
                }, {
                    navController.navigate(AddGasto)
                }
            )
        }

        composable<Historial> {
            HistorialScreen()
        }

        composable<Ajustes> {
            AjustesScreen({
                navController.popBackStack() // PARA IR A LA SCREEN ANTERIOR
            })
        }

        composable<AddGasto> {
            AddScreen({
                navController.popBackStack()
            })
        }
    }
}

