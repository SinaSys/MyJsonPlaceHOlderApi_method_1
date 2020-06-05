package com.example.myjsonplaceholderapi.apiservice

import com.example.myjsonplaceholderapi.model.Post
import com.example.myjsonplaceholderapi.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPost {
    @GET("comments")
    fun getPostItem(): Call<Post>

}