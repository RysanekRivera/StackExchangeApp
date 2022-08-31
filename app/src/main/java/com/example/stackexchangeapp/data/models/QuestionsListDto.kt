package com.example.stackexchangeapp.data.models

import com.google.gson.annotations.SerializedName

data class QuestionsListDto(
    @SerializedName("items")
    val questions: List<Question>
)
