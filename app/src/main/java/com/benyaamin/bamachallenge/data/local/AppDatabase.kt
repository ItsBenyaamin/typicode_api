package com.benyaamin.bamachallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.benyaamin.bamachallenge.domain.model.PostEntity
import com.benyaamin.bamachallenge.domain.model.UserEntity

@Database(
    entities = [
        UserEntity::class,
        PostEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostsDao(): PostsDao
    abstract fun getUsersDao(): UsersDao
}