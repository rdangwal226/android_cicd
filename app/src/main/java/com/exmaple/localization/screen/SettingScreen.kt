package com.exmaple.localization.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen(onBack: () -> Unit) {
    Column {
        Text("Settings")
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}