package com.example.kmmtest.feature.login

import com.example.kmmtest.di.AppComponent
import me.tatarka.inject.annotations.Inject

@Inject
class MyLoginUseCase(
    myLoginDataSource: MyLoginDataSource
) {
    init {
        myLoginDataSource.print()
        println("LoginUsecase injected")
    }
    fun tempuseCase(){
        println("tempuseCase function injected")
    }
}