package com.example.androiddi.data.remote

import com.example.androiddi.model.Poster
import retrofit2.Call
import retrofit2.http.*

interface PosterService {

    @Headers(
        "Content-type:application/json"
    )

    @GET("posts")
    fun listPost(): Call<ArrayList<Poster>>

    @GET("posts/{id}")
    fun singlePost(@Path("id") id: Int): Call<Poster>

    @POST("posts")
    fun createPost(@Body post: Poster): Call<Poster>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: Poster): Call<Poster>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<Poster>

}