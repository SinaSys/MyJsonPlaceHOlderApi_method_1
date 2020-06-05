package com.example.myjsonplaceholderapi.apiservice

import com.example.myjsonplaceholderapi.model.PostItem
import retrofit2.Response
import retrofit2.http.GET

interface GetPost {
    @GET("comments")
   suspend fun getPostItem(): Response<PostItem>

}