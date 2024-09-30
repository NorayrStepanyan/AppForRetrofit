package com.example.appForRetrofit.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MainApi {
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product



    @POST("user/login")
    suspend fun auth(@Body authRequest: AuthRequest): User
}