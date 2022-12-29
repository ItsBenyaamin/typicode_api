package com.benyaamin.bamachallenge.data.repository

import com.benyaamin.bamachallenge.R
import com.benyaamin.bamachallenge.data.local.PostsDao
import com.benyaamin.bamachallenge.data.remote.TypiCodeApi
import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.domain.repository.PostRepository
import com.benyaamin.bamachallenge.util.NetworkHelper
import com.benyaamin.bamachallenge.util.Resource
import com.benyaamin.bamachallenge.util.toEntity
import com.benyaamin.bamachallenge.util.toPost
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepositoryImpl(
    private val postsDao: PostsDao,
    private val typiCodeApi: TypiCodeApi,
    private val networkHelper: NetworkHelper
) : PostRepository {
    override suspend fun getPosts(): Flow<Resource<List<Post>>> {
        return flow {
            emit(Resource.OnLoading(true))
            val posts = postsDao.getPosts().map { it.toPost() }
            if (posts.isNotEmpty()) {
                emit(Resource.OnSuccess(posts))
                emit(Resource.OnLoading(false))
            }
            if (networkHelper.isAvailable()) {
                val result = typiCodeApi.getPosts()
                if (result.isSuccessful) {
                    postsDao.insertPosts(result.body()!!.map { it.toEntity() })
                    emit(Resource.OnSuccess(result.body()!!))
                }else {
                    emit(Resource.OnError(messageId = R.string.fetch_error))
                }
            }
        }
    }

    override suspend fun getPost(id: Int): Flow<Resource<Post>> {
        return flow {
            emit(Resource.OnLoading(true))
            if (networkHelper.isAvailable()) {
                val result = typiCodeApi.getPost(id)
                if (result.isSuccessful) {
                    emit(Resource.OnSuccess(result.body()!!))
                }else {
                    emit(Resource.OnError(messageId = R.string.fetch_error))
                }
            }else {
                emit(Resource.OnError(messageId = R.string.internet_unavailable))
            }
            emit(Resource.OnLoading(false))
        }
    }
}