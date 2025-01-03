package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class CalculatorActivity : ComponentActivity() {
    val calculation =
        mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp(): Unit {
    var calculationText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 30.dp, start = 10.dp, end = 10.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Text(
                text = calculationText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                textAlign = TextAlign.End,
                fontSize = 32.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        CalculatorRow(elements = listOf("AC", "X", "+/-", "/")){
            calculationText = it
        }
        CalculatorRow(elements = listOf("7", "8", "9", "*")){
            calculationText = it

        }
        CalculatorRow(elements = listOf("4", "5", "6", "-")){
            calculationText = it

        }
        CalculatorRow(elements = listOf("1", "2", "3", "+")){
            calculationText = it

        }
        CalculatorRow(elements = listOf("%", "0", ".", "=")){
            calculationText = it

        }
    }

}

@Composable
fun CalculatorRow(elements: List<String>,onButtonClick:(value:String)->Unit): Unit {

    Row(
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        elements.forEach {
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { onButtonClick(it)}, modifier = Modifier.weight(1f)) {
                Text(text = it)
            }
        }
    }
}
