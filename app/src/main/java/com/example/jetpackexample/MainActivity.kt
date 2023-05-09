package com.example.jetpackexample

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.jetpackexample.navigation_impl.NavigationExample
import com.example.jetpackexample.ui.theme.CustomTheme
import com.example.jetpackexample.ui.theme.JetpackExampleTheme

class MainActivity : ComponentActivity() {

    private val puppyList = mutableListOf<Puppy>()

    init {
        for (i in 0..100) {
            puppyList.add(
                Puppy(
                    i,
                    "Dog $i",
                    if (i % 2 == 0) "F" else "M",
                    i,
                    "This a level $i breed"
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    ListView(applicationContext)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        SearchView()
                        Row {
                            for (i in 0..1) {
                                Button(onClick = {
                                    val intent = Intent(this@MainActivity, if (i == 0) ScrollViewExample::class.java else NavigationExample::class.java)
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .padding(10.dp)) {
                                    Text(color = Color.White,
                                        textAlign = TextAlign.Center,
                                        text = if (i == 0) "Navigate to ScrollView" else "Navigate to Bottom Navigation Bar")
                                }
                            }
                        }
                        AnimalView(puppy = puppyList)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchView() {

    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Image Testing"
        )

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = Color.LightGray,
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search Icon"
                )

                OutlinedTextField(
                    value = searchText, onValueChange = { newText ->
                        searchText = newText
                    }
                )
            }

        }

    }
}

@Composable
fun AnimalView(puppy: List<Puppy>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /**
         * contentPadding is equivalent to xml clipToPadding=false
         */

        LazyVerticalGrid(
            contentPadding = PaddingValues(bottom = 16.dp),
            columns = GridCells.Fixed(2), content = {
                items(puppy) {
                    CardView(it.title)
                }
            })

    }
}

@Composable
fun CardView(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(vertical = 10.dp),
        backgroundColor = Color.LightGray,
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Random Image",
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
            )
            Text(text)
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun ListView(context: Context) {
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

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            "This is going to be better and work like a charm",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    Toast.makeText(context, "clicked button 1", Toast.LENGTH_LONG)
                                        .show()
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.5F)
                                    .padding(10.dp)
                            ) {
                                Text(text = "Click Here")
                            }
                            Button(
                                onClick = {
                                    Toast.makeText(context, "clicked button 2", Toast.LENGTH_LONG)
                                        .show()
                                },
                                modifier = Modifier
                                    .fillMaxWidth(1.0F)
                                    .padding(10.dp)
                            ) {
                                Text(text = "Click Me")
                            }
                        }
                    }

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