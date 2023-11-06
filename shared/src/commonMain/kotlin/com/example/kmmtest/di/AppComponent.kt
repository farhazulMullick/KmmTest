package com.example.kmmtest.di

import com.example.kmmtest.feature.login.MyLoginDataSource
import com.example.kmmtest.feature.login.MyLoginDataSourceImpl
import com.example.kmmtest.feature.login.MyLoginUseCase
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class AppComponent {
    abstract val myLoginUseCase: MyLoginUseCase

    companion object {
        fun create() = AppComponent::class.create()
    }

    @Provides
    fun provideMyLoginDs(bind: MyLoginDataSourceImpl): MyLoginDataSource = bind
}