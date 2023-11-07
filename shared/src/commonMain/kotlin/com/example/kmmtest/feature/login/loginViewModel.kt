package com.example.kmmtest.feature.login

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import me.tatarka.inject.annotations.Inject

@Inject
class loginViewModel(
    private val myLoginUseCase: MyLoginUseCase
) : ViewModel() {
    fun testLogin() {
        myLoginUseCase.tempuseCase()
    }
}