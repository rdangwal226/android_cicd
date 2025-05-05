package com.exmaple.localization.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.exmaple.localization.screen.HomeScreen
import com.exmaple.localization.screen.SettingScreen

fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    composable("home") {
        HomeScreen(onSettingsClick = {
            navController.navigate("settings")
        })
    }
    composable("settings") {
        SettingScreen(onBack = {
            navController.popBackStack()
        })
    }
}