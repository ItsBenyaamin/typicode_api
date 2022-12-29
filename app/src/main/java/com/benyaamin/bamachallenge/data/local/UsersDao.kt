package com.benyaamin.bamachallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.benyaamin.bamachallenge.domain.model.UserEntity

@Dao
interface UsersDao {
    @Query("select * from userentity")
    suspend fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUsers(list: List<UserEntity>)
}