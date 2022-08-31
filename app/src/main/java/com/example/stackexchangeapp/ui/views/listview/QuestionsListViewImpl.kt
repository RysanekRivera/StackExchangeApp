package com.example.stackexchangeapp.ui.views.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.annotation.IdRes
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.adapters.QuestionsAdapter

class QuestionsListViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : QuestionsAdapter.OnQuestionClickListener, QuestionsListView {

    override val rootView: View
    private val questionsListAdapter: QuestionsAdapter
    val context: Context get() = rootView.context
    private val listeners = mutableListOf<QuestionsListView.OnQuestionClickedListener>()

    init {
        rootView = inflater.inflate(R.layout.layout_questions_list, parent, false)
        questionsListAdapter = QuestionsAdapter(context, this)
        findViewById<ListView>(R.id.lst_questions).adapter = questionsListAdapter
    }

    private fun <T: View> findViewById(@IdRes id: Int): T {
        return rootView.findViewById(id)
    }

    override fun onQuestionClicked(question: Question) {
        listeners.forEach { listener -> listener.onQuestionClicked(question) }
    }

    override fun bindQuestions(questions: List<Question>) {
        questionsListAdapter.bindQuestions(questions)
    }

    override fun registerListener(listener: QuestionsListView.OnQuestionClickedListener) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: QuestionsListView.OnQuestionClickedListener) {
        listeners.remove(listener)
    }
}

