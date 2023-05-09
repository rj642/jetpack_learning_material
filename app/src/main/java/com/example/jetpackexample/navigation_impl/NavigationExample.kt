package com.example.jetpackexample.navigation_impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.jetpackexample.ui.theme.CustomTheme

class NavigationExample: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CustomTheme {
                Surface {

                }
            }

        }
    }

}