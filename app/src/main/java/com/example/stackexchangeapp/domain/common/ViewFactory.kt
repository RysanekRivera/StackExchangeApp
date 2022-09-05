package com.example.stackexchangeapp.domain.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stackexchangeapp.ui.views.item.QuestionsListItemViewImpl
import com.example.stackexchangeapp.ui.views.recyclerview.QuestionsRecyclerViewImpl

class ViewFactory(
    private val layoutInflater: LayoutInflater
){

    fun getQuestionsRecyclerView(parent: ViewGroup?) = QuestionsRecyclerViewImpl(layoutInflater, parent, this)

    fun getQuestionSingleItemView(parent: ViewGroup?) = QuestionsListItemViewImpl(layoutInflater, parent)
}