package com.example.stackexchangeapp.ui.views.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.adapters.QuestionsRecyclerViewAdapter

class QuestionsRecyclerViewImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : QuestionsRecyclerView, QuestionsRecyclerViewAdapter.OnQuestionClickedListener{

    override val rootView: View
    private val questionsRecyclerViewAdapter: QuestionsRecyclerViewAdapter
    val context: Context get() = rootView.context
    private val listeners = mutableListOf<QuestionsRecyclerView.OnQuestionClickedListener>()

    init {
        rootView = inflater.inflate(R.layout.layout_questions_list, parent, false)
        questionsRecyclerViewAdapter = QuestionsRecyclerViewAdapter(inflater, this)
        findViewById<RecyclerView>(R.id.rvQuestionsList).apply {
            adapter = questionsRecyclerViewAdapter
            layoutManager = GridLayoutManager(context, 1)
        }
    }

    private fun <T: View> findViewById(@IdRes id: Int): T {
        return rootView.findViewById(id)
    }

    override fun onQuestionClicked(question: Question) {
        listeners.forEach { listener -> listener.onQuestionClicked(question) }
    }

    override fun bindQuestions(questions: List<Question>) {
        questionsRecyclerViewAdapter.setQuestions(questions)
    }

    override fun registerListener(listener: QuestionsRecyclerView.OnQuestionClickedListener) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: QuestionsRecyclerView.OnQuestionClickedListener) {
        listeners.remove(listener)
    }
}

