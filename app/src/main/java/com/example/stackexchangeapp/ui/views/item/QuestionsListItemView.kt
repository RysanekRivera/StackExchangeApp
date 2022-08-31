package com.example.stackexchangeapp.ui.views.item

import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.common.BaseView

interface QuestionsListItemView : BaseView {

    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    fun registerListener(listener: Listener)

    fun unregisterListener(listener: Listener)

    fun bindQuestion(question: Question)
}