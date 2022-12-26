package com.benyaamin.bamachallenge.data.remote

import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.data.remote.dto.User
import retrofit2.http.GET
import retrofit2.http.Path

interface TypiCodeApi {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post
}