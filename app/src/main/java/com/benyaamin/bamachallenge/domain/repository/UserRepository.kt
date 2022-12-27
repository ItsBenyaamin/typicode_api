package com.benyaamin.bamachallenge.domain.repository

import com.benyaamin.bamachallenge.data.remote.dto.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}