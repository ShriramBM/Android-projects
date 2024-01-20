package com.billa.life_cycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.billa.life_cycle.ui.theme.Life_cycleTheme
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

private const val create = "life_bro";
private const val resume = "life_bro";
private const val destroy = "life_bro";
private const val start = "life_bro";
private const val restart = "life_bro";
private const val pause = "life_bro";
private const val stop = "life_bro";


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(create, "created bro")
        setContent {
            Life_cycleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
    override fun onResume(){
        super.onResume()
        Log.d(resume, "Resume is called bro")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(destroy, "Destroyed bro")
    }

    override fun onPause() {
        super.onPause()
        Log.d(pause, "Paused bro")
    }

    override fun onStop() {
        super.onStop()
        Log.d(stop, "Stopped bro")
    }

    override fun onStart() {
        super.onStart()
        Log.d(start, "Started Bro")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(restart, "Restarted bro")
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var txt by rememberSaveable { mutableIntStateOf(0) }
    var names by rememberSaveable { mutableStateOf("") }
    Column{
        Text(
            text = "Hello ${txt}!",
            modifier = modifier
        )
        Text(
            text = names,
            modifier = modifier
        )
        Button(onClick = { txt += 1 }) {
            Text(text = "click")
        }
        TextField(value = names, onValueChange = {names = it})
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Life_cycleTheme {
        Greeting("Android")
    }
}