package com.apllication.pantaucovid.retrofit

import retrofit2.Call
import com.apllication.pantaucovid.MainModel
import retrofit2.http.*

interface ApiEndpoint {

    @GET("indonesia")
    fun getData(): Call<List<MainModel>>
}