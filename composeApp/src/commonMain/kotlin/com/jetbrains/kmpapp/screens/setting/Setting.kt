package com.jetbrains.kmpapp.screens.setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingScreen() {
    Text(
        text = "Settings Screen",
        modifier = Modifier.fillMaxSize(),
        style = MaterialTheme.typography.headlineMedium
    )
}
