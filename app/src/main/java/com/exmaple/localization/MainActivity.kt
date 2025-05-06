@file:Suppress("unused", "unused", "unused")

package com.exmaple.localization

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LanguageAwareUI()
        }
    }
}

@Composable
fun MyComposable(){
    var counter by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Lifecycle.State.STARTED) {
        while (true) {
            delay(1000) // Delay for 1 second
            counter++
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Counter: $counter")
            Button(onClick = { counter++ }) {
                Text(text = "Increment")
            }
        }
    }
}

@Composable
fun LanguageAwareUI() {
    var language by remember { mutableStateOf("en") }

    // Update translations
    TranslationManager.setLanguage(language)

    // Determine layout direction
    val layoutDirection = if (language == "ar") LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = TranslationManager.getString("greeting"),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = TranslationManager.getString("welcome_message"),
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        language = if (language == "en") "ar" else "en"
                    }
                ) {
                    Text(TranslationManager.getString("switch_language"))
                }
            }
        }
    }
}
