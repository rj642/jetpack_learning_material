package com.example.jetpackexample.login.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.jetpackexample.R
import com.example.jetpackexample.ui.theme.CustomTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {

                    LoginView()

                }

            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginView() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var userName by remember {
            mutableStateOf(TextFieldValue(""))
        }

        var password by remember {
            mutableStateOf(TextFieldValue(""))
        }

        Image(
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp),
            painter = painterResource(id = R.drawable.ic_network),
            contentDescription = "user profile",
            alignment = Alignment.Center
        )

        CustomTextField(value = userName, label = "Username", onValueChange = { newValue ->
            userName = newValue
        })

        CustomTextField(value = password, label = "Password", onValueChange = { newValue ->
            password = newValue
        })

        Text(
            "Forgot Password?",
            modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(end = 10.dp),
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontSize = TextUnit(14F, TextUnitType.Sp)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp),
            onClick = {

            }
        ) {
            Text(
                "Log In",
                modifier = Modifier
                    .padding(5.dp),
                color = Color.White
            )
        }

    }
}

@Composable
fun CustomTextField(value: TextFieldValue, label: String, onValueChange: (TextFieldValue) -> Unit) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(10.dp))
            .background(Color.Transparent),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        singleLine = true
    )

}