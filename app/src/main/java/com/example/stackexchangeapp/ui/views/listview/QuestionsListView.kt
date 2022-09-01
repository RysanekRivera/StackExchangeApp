package com.example.stackexchangeapp.ui.views.listview

import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.common.IObservableView

interface QuestionsListView : IObservableView<QuestionsListView.OnQuestionClickedListener> {

    interface OnQuestionClickedListener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestions(questions: List<Question>)

}