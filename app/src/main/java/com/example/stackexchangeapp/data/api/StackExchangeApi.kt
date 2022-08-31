package com.example.stackexchangeapp.data.api

import com.example.stackexchangeapp.data.models.QuestionDetailsDto
import com.example.stackexchangeapp.data.models.QuestionsListDto
import com.example.stackexchangeapp.data.utils.Constants.STACKOVERFLOW_API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StackExchangeApi {
    @GET("/questions?key=${STACKOVERFLOW_API_KEY}&sort=activity&order=desc&site=stackoverflow&filter=withbody")
    fun fetchLastActiveQuestions(@Query("pagesize") pageSize: Int?): Call<QuestionsListDto>

    @GET("/questions/{questionId}?key=${STACKOVERFLOW_API_KEY}&site=stackoverflow&filter=withbody")
    fun fetchQuestionDetails(@Path("questionId") questionId: String?): Call<QuestionDetailsDto>
}