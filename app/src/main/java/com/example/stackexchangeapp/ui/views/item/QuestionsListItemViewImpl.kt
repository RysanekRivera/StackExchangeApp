package com.example.stackexchangeapp.ui.views.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question

class QuestionsListItemViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup
): QuestionsListItemView {

    private val root: View
    private val listeners = mutableListOf<QuestionsListItemView.Listener>()
    private val txtTitle: TextView
    private lateinit var curQuestion: Question

    init {
        root = inflater.inflate(R.layout.layout_question_list_item, parent, false)
        root.setOnClickListener { listeners.forEach { listener -> listener.onQuestionClicked(curQuestion) } }
        txtTitle = findViewById(R.id.txt_title)
    }

    override val rootView: View
        get() = root

    private fun <T: View> findViewById(@IdRes int: Int): T {
        return rootView.findViewById(int)
    }

    override fun registerListener(listener: QuestionsListItemView.Listener) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: QuestionsListItemView.Listener) {
        listeners.remove(listener)
    }

    override fun bindQuestion(question: Question) {
        curQuestion = question
        txtTitle.text = question.title
    }
}