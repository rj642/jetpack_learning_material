package com.example.jetpackexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.jetpackexample.ui.theme.JetpackExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListView()
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun ListView() {
    val languages = listOf(
        "C++", "C", "C#", "Java", "Kotlin", "Dart", "Python", "Javascript", "SpringBoot",
        "XML", "Dart", "Node JS", "Typescript", "Dot Net", "GoLang", "MongoDb",
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Simple ListView Example",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ), fontWeight = FontWeight.Black
        )

        LazyColumn {

            items(languages) { language ->

                Card(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    backgroundColor = Color.Green,
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(language, modifier = Modifier.padding(15.dp))
                }

                Divider()

            }

        }

    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp() {
    Scaffold(
        content = {
            BackHomeContent()
        }
    )
}

@Composable
fun BackHomeContent() {

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetpackExampleTheme {
//        Greeting("Android")
//    }
//}