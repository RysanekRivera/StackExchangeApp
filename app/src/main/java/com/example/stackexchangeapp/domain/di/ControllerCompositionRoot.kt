package com.example.stackexchangeapp.domain.di

import android.app.Activity
import android.view.LayoutInflater
import com.example.stackexchangeapp.domain.common.ViewFactory

class ControllerCompositionRoot(
    private val compositionRoot: CompositionRoot,
    private val activity: Activity
) {

    fun getStackExchangeApi() = compositionRoot.getStackExchangeApi()

    private fun layoutInflater(): LayoutInflater {
        return LayoutInflater.from(activity)
    }

    fun viewFactory() = ViewFactory(layoutInflater())
}