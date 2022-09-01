package com.example.stackexchangeapp.ui.views.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.adapters.QuestionsAdapter
import com.example.stackexchangeapp.ui.views.common.BaseObservableView

class QuestionsListViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableView<QuestionsListView.OnQuestionClickedListener>(), QuestionsAdapter.OnQuestionClickListener, QuestionsListView {

    private val questionsListAdapter: QuestionsAdapter

    init {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false))
        questionsListAdapter = QuestionsAdapter(context, this)
        findViewById<ListView>(R.id.lst_questions).adapter = questionsListAdapter
    }

    override fun onQuestionClicked(question: Question) {
        listeners.forEach { listener -> listener.onQuestionClicked(question) }
    }

    override fun bindQuestions(questions: List<Question>) {
        questionsListAdapter.bindQuestions(questions)
    }

}

