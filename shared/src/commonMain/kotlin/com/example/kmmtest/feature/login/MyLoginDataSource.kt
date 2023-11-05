package com.example.kmmtest.feature.login

interface MyLoginDataSource {
    fun login()
    fun getOtp()
    fun submitOtp()
    fun print() {
        println("MyLoginDataSource injected")
    }
}