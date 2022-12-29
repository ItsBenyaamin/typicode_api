package com.benyaamin.bamachallenge.di

import com.benyaamin.bamachallenge.data.local.PostsDao
import com.benyaamin.bamachallenge.data.local.UsersDao
import com.benyaamin.bamachallenge.data.remote.TypiCodeApi
import com.benyaamin.bamachallenge.data.repository.PostsRepositoryImpl
import com.benyaamin.bamachallenge.data.repository.UserRepositoryImpl
import com.benyaamin.bamachallenge.domain.repository.PostRepository
import com.benyaamin.bamachallenge.domain.repository.UserRepository
import com.benyaamin.bamachallenge.util.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Singleton
    @Provides
    fun provideTypiCodeApi(client: OkHttpClient): TypiCodeApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build();
        return retrofit.create(TypiCodeApi::class.java)
    }

    @Singleton
    @Provides
    fun providePostsRepository(
        postsDao: PostsDao,
        api: TypiCodeApi,
        networkHelper: NetworkHelper
    ): PostRepository {
        return PostsRepositoryImpl(postsDao, api, networkHelper)
    }

    @Singleton
    @Provides
    fun provideUsersRepository(
        usersDao: UsersDao,
        api: TypiCodeApi,
        networkHelper: NetworkHelper
    ): UserRepository {
        return UserRepositoryImpl(usersDao, api, networkHelper)
    }

}