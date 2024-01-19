package com.billa.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.billa.happybirthday.ui.theme.HappyBirthDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Happy Birth Day  Sam!")
                }
            }
        }
    }
}

@Composable
fun Greeting(message:String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = message,
            modifier = modifier,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "from linda",
            fontSize = 40.sp,
            modifier = modifier
                .align(alignment = Alignment.End)
                .padding(10.dp)
        )
        Box(modifier = modifier
            .align(alignment = Alignment.CenterHorizontally)
            .background(color = Color.DarkGray)

        ){
            Image(
                painter = painterResource(R.drawable.party),
                contentDescription = "celebrate",
                modifier = modifier
                    .width(200.dp)
                    .height(190.dp)

            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    HappyBirthDayTheme {
        Greeting("Happy BirthDay  Sam!")
    }
}