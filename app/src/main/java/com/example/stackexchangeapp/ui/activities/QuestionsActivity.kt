package com.example.stackexchangeapp.ui.activities

import android.os.Bundle
import android.widget.Toast
import com.example.stackexchangeapp.data.api.StackExchangeApiFactory
import com.example.stackexchangeapp.data.models.Question
import com.example.stackexchangeapp.data.models.QuestionsListDto
import com.example.stackexchangeapp.data.utils.Constants.QUESTIONS_LIST_PAGE_SIZE
import com.example.stackexchangeapp.domain.common.BaseActivity
import com.example.stackexchangeapp.ui.views.recyclerview.QuestionsRecyclerView
import com.example.stackexchangeapp.ui.views.recyclerview.QuestionsRecyclerViewImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionsActivity: BaseActivity(), QuestionsRecyclerView.OnQuestionClickedListener {

    private val questionsRecyclerView by lazy { QuestionsRecyclerViewImpl(layoutInflater, null) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questionsRecyclerView.registerListener(this)

        fetchQuestions()

        setContentView(questionsRecyclerView.rootView)
    }

    private fun fetchQuestions() = StackExchangeApiFactory.provideStackExchangeApi().fetchLastActiveQuestions(QUESTIONS_LIST_PAGE_SIZE)
            .enqueue(object : Callback<QuestionsListDto> {
                override fun onResponse(
                    call: Call<QuestionsListDto>,
                    response: Response<QuestionsListDto>
                ) {
                    questionsRecyclerView.bindQuestions(response.body()!!.questions)
                }

                override fun onFailure(call: Call<QuestionsListDto>, t: Throwable) {
                    Toast.makeText(
                        this@QuestionsActivity,
                        "Error: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

    override fun onQuestionClicked(question: Question) {
        Toast.makeText(this, question.title, Toast.LENGTH_SHORT).show()
    }
}