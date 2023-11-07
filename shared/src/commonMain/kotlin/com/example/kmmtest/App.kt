package com.example.kmmtest

import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kmmtest.di.AppComponent
import com.example.kmmtest.feature.login.loginViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    app:AppComponent
) {

        val viewModel = getViewModel(
            key = "contact-list-screen",
            factory = viewModelFactory {
                loginViewModel(app.myLoginUseCase)
            }
        )

    viewModel.testLogin()
    Text("My sucess *****")
//    Image(painter = painterResource(MR.images.test_2),contentDescription = null)
}