package com.example.stackexchangeapp.ui.views.item

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.common.BaseObservableView

class QuestionsListItemViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
): BaseObservableView<QuestionsListItemView.Listener>(), QuestionsListItemView {

    private val txtTitle: TextView
    private lateinit var curQuestion: Question

    init {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false))
        rootView.setOnClickListener { listeners.forEach { listener -> listener.onQuestionClicked(curQuestion) } }
        txtTitle = findViewById(R.id.txt_title)
    }

    override fun bindQuestion(question: Question) {
        curQuestion = question
        txtTitle.text = question.title
    }
}