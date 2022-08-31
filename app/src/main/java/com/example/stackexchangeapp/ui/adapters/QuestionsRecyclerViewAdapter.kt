package com.example.stackexchangeapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.ui.views.item.QuestionsListItemView
import com.example.stackexchangeapp.ui.views.item.QuestionsListItemViewImpl

class QuestionsRecyclerViewAdapter (
    private val inflater: LayoutInflater,
    private val listener: OnQuestionClickedListener
): RecyclerView.Adapter<QuestionsRecyclerViewAdapter.QuestionsViewHolder>(),
    QuestionsListItemView.Listener {

    interface OnQuestionClickedListener {
        fun onQuestionClicked(question: Question)
    }

    private val questions = mutableListOf<Question>()

    class QuestionsViewHolder(
        listItemView: QuestionsListItemView
    ) : RecyclerView.ViewHolder(listItemView.rootView){
        val questionsListItemView: QuestionsListItemView = listItemView
    }

    override fun onQuestionClicked(question: Question) {
        listener.onQuestionClicked(question)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val listItemView: QuestionsListItemView = QuestionsListItemViewImpl(inflater, parent)
        listItemView.registerListener(this)
        return QuestionsViewHolder(listItemView)
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.questionsListItemView.bindQuestion(questions[position])
    }

    override fun getItemCount(): Int = questions.size

    fun setQuestions(newQuestions: List<Question>){
        questions.clear()
        questions.addAll(newQuestions)
        notifyDataSetChanged()
    }
}