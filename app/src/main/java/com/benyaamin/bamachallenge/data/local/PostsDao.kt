package com.benyaamin.bamachallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.benyaamin.bamachallenge.domain.model.PostEntity

@Dao
interface PostsDao {
    @Query("select * from postentity")
    suspend fun getPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPosts(list: List<PostEntity>)
}