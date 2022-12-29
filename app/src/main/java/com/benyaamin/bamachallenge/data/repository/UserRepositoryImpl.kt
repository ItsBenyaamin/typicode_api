package com.benyaamin.bamachallenge.data.repository

import com.benyaamin.bamachallenge.R
import com.benyaamin.bamachallenge.data.local.UsersDao
import com.benyaamin.bamachallenge.data.mapper.toEntity
import com.benyaamin.bamachallenge.data.mapper.toUser
import com.benyaamin.bamachallenge.data.remote.TypiCodeApi
import com.benyaamin.bamachallenge.data.remote.dto.User
import com.benyaamin.bamachallenge.domain.repository.UserRepository
import com.benyaamin.bamachallenge.util.NetworkHelper
import com.benyaamin.bamachallenge.util.Resource
import com.benyaamin.bamachallenge.util.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val usersDao: UsersDao,
    private val typiCodeApi: TypiCodeApi,
    private val networkHelper: NetworkHelper
) : UserRepository {

    override suspend fun getUsers(): Flow<Resource<List<User>>> {
        return flow {
            emit(Resource.OnLoading(true))
            val users = usersDao.getUsers().map { it.toUser() }
            if (users.isNotEmpty()) {
                emit(Resource.OnSuccess(users))
                emit(Resource.OnLoading(false))
            }
            if (networkHelper.isAvailable()) {
                val result = typiCodeApi.getUsers()
                if (result.isSuccessful) {
                    usersDao.insertUsers(result.body()!!.map { it.toEntity() })
                    emit(Resource.OnSuccess(result.body()!!))
                }else {
                    emit(Resource.OnError(messageId = R.string.fetch_error))
                }
            }
        }
    }

}