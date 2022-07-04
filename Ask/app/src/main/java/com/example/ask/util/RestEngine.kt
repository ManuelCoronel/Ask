package com.example.ask.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RestEngine {
    companion object{

        fun getRestEngine(): Retrofit {
            val interceptor = ServiceInterceptor()
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://164.92.88.6:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()





            return retrofit


        }

    }
}