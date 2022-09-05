package com.example.stackexchangeapp.ui.views.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.domain.common.ViewFactory
import com.example.stackexchangeapp.ui.adapters.QuestionsRecyclerViewAdapter
import com.example.stackexchangeapp.ui.views.common.BaseObservableView

class QuestionsRecyclerViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    viewFactory: ViewFactory
) : BaseObservableView<QuestionsRecyclerView.OnQuestionClickedListener>(),
    QuestionsRecyclerView,
    QuestionsRecyclerViewAdapter.OnQuestionClickedListener{

    private val questionsRecyclerViewAdapter: QuestionsRecyclerViewAdapter

    init {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false))
        questionsRecyclerViewAdapter = QuestionsRecyclerViewAdapter(this, viewFactory)
        findViewById<RecyclerView>(R.id.rvQuestionsList).apply {
            adapter = questionsRecyclerViewAdapter
            layoutManager = GridLayoutManager(context, 1)
        }
    }

    override fun onQuestionClicked(question: Question) {
        listeners.forEach { listener -> listener.onQuestionClicked(question) }
    }

    override fun bindQuestions(questions: List<Question>) {
        questionsRecyclerViewAdapter.setQuestions(questions)
    }

}

