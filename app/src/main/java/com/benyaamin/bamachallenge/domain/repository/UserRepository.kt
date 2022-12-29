package com.benyaamin.bamachallenge.domain.repository

import com.benyaamin.bamachallenge.data.remote.dto.User
import com.benyaamin.bamachallenge.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(): Flow<Resource<List<User>>>
}