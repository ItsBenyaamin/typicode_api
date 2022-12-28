package com.benyaamin.bamachallenge.domain.repository

import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.util.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPosts(): Flow<Resource<List<Post>>>
    suspend fun getPost(id: Int): Flow<Resource<Post>>
}