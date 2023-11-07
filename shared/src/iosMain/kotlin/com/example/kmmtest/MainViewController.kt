package com.example.kmmtest

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmmtest.di.AppComponent

fun MainViewController() = ComposeUIViewController {
    App(AppComponent.create())
}
