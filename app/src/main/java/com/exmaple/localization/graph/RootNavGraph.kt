package com.exmaple.localization.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.exmaple.localization.screen.HomeScreen
import com.exmaple.localization.screen.LoginScreen

@Composable
fun RootNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "auth") {
        navigation(startDestination = "login", route = "auth") {
            composable("login") {
                LoginScreen {
                    navController.navigate("main") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            }
        }

        navigation(startDestination = "home", route = "main") {
            mainNavGraph(navController)
        }
    }
}
