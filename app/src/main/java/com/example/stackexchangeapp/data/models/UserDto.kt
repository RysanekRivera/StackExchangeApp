package com.example.stackexchangeapp.data.models

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("display_name") val userDisplayName: String,
    @SerializedName("profile_image") val userAvatarUrl: String
)