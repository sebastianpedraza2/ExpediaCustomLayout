package com.example.expediacustomlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expediacustomlayout.ui.theme.ExpediaCustomLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpediaCustomLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {


                    }

                    LazyColumn {
                        items(1) {
                            Card(modifier = Modifier.fillMaxWidth()) {
                                PlannedItemCardLayout(
                                    modifier = Modifier.wrapContentHeight(),
                                    image = { ImageTest() },
                                    menu = { MenuTest() },
                                    content = { ContentTest() },
                                    price = { PriceTest() },
                                    votesAndComments = { VotesTest() })

                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ImageTest(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(60.dp),
        color = Color.Blue
    ) {
        Greeting("Image")
    }
}

@Composable
fun MenuTest(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .height(20.dp)
            .width(20.dp),
        color = Color.Cyan
    ) {
        Greeting("Menu")
    }
}

@Composable
fun ContentTest(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier,
        color = Color.Green
    ) {
        Greeting("ContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContentContent")
    }
}

@Composable
fun VotesTest(
    modifier: Modifier = Modifier.width(60.dp)
) {
    Greeting(
        "VotesVotesVotesVotesVotesVotesVotesVotesVotesVotesVotesVotesVotesVotesVotes",
        modifier
    )

}

@Composable
fun PriceTest(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier,
        color = Color.Red
    ) {
        Greeting("PriceP")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpediaCustomLayoutTheme {
        Greeting("Android")
    }
}