package com.example.kmmtest.android

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
import com.example.kmmtest.App
import com.example.kmmtest.Greeting
import com.example.kmmtest.android.di.MyAppComponent
import com.example.kmmtest.android.di.create
import com.example.kmmtest.di.AppComponent
import com.example.kmmtest.di.create
import com.example.kmmtest.feature.login.MyLoginUseCase
import dev.icerock.moko.graphics.BuildConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(AppComponent::class.create())
                    BuildConfig.DEBUG
//                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

//class Testing() {
//    lateinit var useCase: MyLoginUseCase
//
//    fun call() {
//        useCase = AppComponent::class.create().myLoginUseCase
//    }
//}

//fun main() {
//    Testing().call()
//}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
