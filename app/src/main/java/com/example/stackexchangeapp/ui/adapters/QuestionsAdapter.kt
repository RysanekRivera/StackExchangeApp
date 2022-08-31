package com.example.stackexchangeapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.stackexchangeapp.R
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.item.QuestionsListItemView
import com.example.stackexchangeapp.ui.views.item.QuestionsListItemViewImpl

class QuestionsAdapter(
    context: Context,
    private val onQuestionClickListener: OnQuestionClickListener
) : ArrayAdapter<Question>(context, R.layout.layout_questions_list),
    QuestionsListItemView.Listener {

    interface OnQuestionClickListener {
        fun onQuestionClicked(question: Question)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val questionsListItemView: View = convertView ?: run {
            val view = QuestionsListItemViewImpl(LayoutInflater.from(context), parent) as QuestionsListItemView
            view.registerListener(this@QuestionsAdapter)
            view.rootView.tag = view
            view.rootView
        }

        val view: QuestionsListItemView = (questionsListItemView.tag as QuestionsListItemView)

        val question = getItem(position)

        question?.let { view.bindQuestion(question) }

        questionsListItemView.setOnClickListener {
            question?.let { onQuestionClicked(question) }
        }

        return questionsListItemView
    }

    override fun onQuestionClicked(question: Question) {
        onQuestionClickListener.onQuestionClicked(question)
    }

    fun bindQuestions(newQuestions: List<Question>){
        clear()
        addAll(newQuestions)
        notifyDataSetChanged()
    }

}