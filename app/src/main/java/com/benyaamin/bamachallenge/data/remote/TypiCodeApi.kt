package com.benyaamin.bamachallenge.data.remote

import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.data.remote.dto.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TypiCodeApi {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Response<Post>
}