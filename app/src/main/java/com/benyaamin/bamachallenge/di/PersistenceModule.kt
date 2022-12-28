package com.benyaamin.bamachallenge.di

import android.content.Context
import androidx.room.Room
import com.benyaamin.bamachallenge.data.local.AppDatabase
import com.benyaamin.bamachallenge.data.local.PostsDao
import com.benyaamin.bamachallenge.data.local.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "bama.db"
        ).build()
    }

    @Singleton
    @Provides
    fun providePostsDao(db: AppDatabase): PostsDao {
        return db.getPostsDao()
    }

    @Singleton
    @Provides
    fun provideUsersDao(db: AppDatabase): UsersDao {
        return db.getUsersDao()
    }

}
