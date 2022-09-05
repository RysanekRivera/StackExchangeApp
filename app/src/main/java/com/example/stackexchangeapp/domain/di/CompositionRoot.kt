package com.example.stackexchangeapp.domain.di

import com.example.stackexchangeapp.data.api.StackExchangeApi
import com.example.stackexchangeapp.data.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CompositionRoot {
    private var retrofit: Retrofit? = null

    fun getStackExchangeApi(): StackExchangeApi = getRetrofit().create(StackExchangeApi::class.java)

    private fun getRetrofit(): Retrofit {
        return retrofit ?: run {
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(
                    OkHttpClient().newBuilder()
                        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit!!
        }
    }

}