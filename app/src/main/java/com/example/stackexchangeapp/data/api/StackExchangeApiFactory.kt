package com.example.stackexchangeapp.data.api

import com.example.stackexchangeapp.data.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StackExchangeApiFactory{
    fun provideStackExchangeApi(): StackExchangeApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
                .build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StackExchangeApi::class.java)
}



