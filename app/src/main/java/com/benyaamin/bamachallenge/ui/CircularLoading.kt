package com.benyaamin.bamachallenge.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularLoading(show: Boolean) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (show) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.Center),
                color = Color . Black,
            )
        }
    }
}