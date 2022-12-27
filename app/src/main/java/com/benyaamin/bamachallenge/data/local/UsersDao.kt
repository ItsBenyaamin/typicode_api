package com.benyaamin.bamachallenge.data.local

import androidx.room.Dao
import androidx.room.Query
import com.benyaamin.bamachallenge.domain.model.UserEntity

@Dao
interface UsersDao {
    @Query("select * from userentity")
    suspend fun getUsers(): List<UserEntity>
}