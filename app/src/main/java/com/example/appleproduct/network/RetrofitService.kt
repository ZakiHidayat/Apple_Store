package com.example.appleproduct.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    private val client = OkHttpClient.Builder()
        .build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://apple-product-fd284-default-rtdb.asia-southeast1.firebasedatabase.app")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    fun <T>buildservice (service: Class<T>) : T{
        return retrofit.create(service)
    }

}