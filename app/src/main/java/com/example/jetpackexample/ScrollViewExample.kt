package com.example.jetpackexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetpackexample.ui.theme.CustomTheme
import com.google.accompanist.glide.rememberGlidePainter

class ScrollViewExample : ComponentActivity() {

    private val numberList = mutableListOf<String>()

    init {
        for (i in 0..1000) {
            numberList.add("Current index is $i")
        }
    }

    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var offSet by remember { mutableStateOf(0f) }
                    /**Still in Progress Block**/
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .scrollable(
                                state = rememberScrollableState { delta ->
                                    offSet += delta
                                    delta
                                },
                                orientation = Orientation.Vertical
                            ),

                        ) {

                        Column {

                            Column {
                                Text(
                                    "Images",
                                    fontSize = TextUnit(20.0F, TextUnitType.Sp),
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(10.dp)
                                )
                                LazyRow {
                                    items(100) {
                                        ImageCardView()
                                    }
                                }
                            }

                            Column {

                                Text(
                                    "Texts",
                                    fontSize = TextUnit(20.0F, TextUnitType.Sp),
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(10.dp)
                                )

                                LazyColumn {
                                    items(numberList) { number ->
                                        CustomView(item = number)
                                    }
                                }

                            }

                        }
                    }

                }

            }
        }
    }

}

@Composable
fun ImageCardView() {

    val imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
    val spareUrl = "https://picsum.photos/300/300"

    Card(
        modifier = Modifier
            .padding(10.dp),
        border = BorderStroke(4.dp, Color.LightGray),
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            painter = rememberGlidePainter(imageUrl),
            contentDescription = "Example Image",
            modifier = Modifier
                .fillMaxWidth(0.24f)
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Fit,
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CustomView(item: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .padding(vertical = 20.dp),
            text = item,
            fontSize = TextUnit(18.0F, TextUnitType.Sp),
            color = Color.Black,
        )
    }

}