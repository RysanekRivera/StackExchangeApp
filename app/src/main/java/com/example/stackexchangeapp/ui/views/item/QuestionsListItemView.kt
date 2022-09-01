package com.example.stackexchangeapp.ui.views.item

import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.common.IObservableView

interface QuestionsListItemView : IObservableView<QuestionsListItemView.Listener> {

    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestion(question: Question)
}