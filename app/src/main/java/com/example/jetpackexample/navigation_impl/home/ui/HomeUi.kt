package com.example.jetpackexample.navigation_impl.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

object HomeUi {

    @OptIn(ExperimentalUnitApi::class)
    @Composable
    fun HomeScreen() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(modifier = Modifier
                .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = TextUnit(20F, TextUnitType.Sp),
                text = "Welcome to Home Screen")
        }

    }

}