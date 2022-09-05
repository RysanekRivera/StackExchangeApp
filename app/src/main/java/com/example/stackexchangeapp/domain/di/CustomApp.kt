package com.example.stackexchangeapp.domain.di

import android.app.Application

class CustomApp: Application() {
    lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()

        compositionRoot = CompositionRoot()
    }

}