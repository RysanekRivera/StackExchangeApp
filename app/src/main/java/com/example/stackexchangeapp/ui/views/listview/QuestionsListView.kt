package com.example.stackexchangeapp.ui.views.listview

import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.common.BaseView

interface QuestionsListView : BaseView {

    interface OnQuestionClickedListener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestions(questions: List<Question>)
    fun registerListener(listener: OnQuestionClickedListener)
    fun unregisterListener(listener: OnQuestionClickedListener)
}