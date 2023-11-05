package com.example.kmmtest.feature.login

import me.tatarka.inject.annotations.Inject


@Inject
class MyLoginDataSourceImpl: MyLoginDataSource {
    init {
        println("MyLoingDataSourceIml instiated")
    }
    override fun login() {

    }

    override fun getOtp() {

    }

    override fun submitOtp() {

    }
}