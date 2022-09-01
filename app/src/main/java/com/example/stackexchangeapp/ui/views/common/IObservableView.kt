package com.example.stackexchangeapp.ui.views.common

interface IObservableView<ListenerType> : IBaseView {

    fun registerListener(listener: ListenerType)
    fun unregisterListener(listener: ListenerType)
}