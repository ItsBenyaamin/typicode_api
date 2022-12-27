package com.benyaamin.bamachallenge.domain.repository

import com.benyaamin.bamachallenge.data.remote.dto.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post
}