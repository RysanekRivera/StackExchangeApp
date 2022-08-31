package com.example.stackexchangeapp.data.models

import com.google.gson.annotations.SerializedName

data class QuestionDetailsDto(
    @SerializedName("items") val questions: List<QuestionDto>
)