package com.example.stackexchangeapp.ui.views.recyclerview

import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.common.IBaseView

interface QuestionsRecyclerView: IBaseView {

    interface OnQuestionClickedListener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestions(questions: List<Question>)
    fun registerListener(listener: OnQuestionClickedListener)
    fun unregisterListener(listener: OnQuestionClickedListener)
}