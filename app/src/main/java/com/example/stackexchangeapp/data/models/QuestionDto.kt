package com.example.stackexchangeapp.data.models

import com.google.gson.annotations.SerializedName

data class QuestionDto(
    @SerializedName("question_id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("owner") val owner: UserDto
)
