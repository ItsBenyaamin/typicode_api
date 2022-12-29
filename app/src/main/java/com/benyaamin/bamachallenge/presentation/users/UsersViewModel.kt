package com.benyaamin.bamachallenge.presentation.users

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benyaamin.bamachallenge.data.remote.dto.Address
import com.benyaamin.bamachallenge.data.remote.dto.Company
import com.benyaamin.bamachallenge.data.remote.dto.Geo
import com.benyaamin.bamachallenge.data.remote.dto.User
import com.benyaamin.bamachallenge.domain.repository.UserRepository
import com.benyaamin.bamachallenge.util.BaseState
import com.benyaamin.bamachallenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersRepository: UserRepository
) : ViewModel() {
    var state by mutableStateOf(BaseState<List<User>>())

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            usersRepository.getUsers()
                .collect { result ->
                    state = when(result) {
                        is Resource.OnLoading -> state.copy(isLoading = result.isLoading)
                        is Resource.OnSuccess -> state.copy(data = result.data)
                        is Resource.OnError -> state.copy(
                            message = result.message,
                            messageId = result.messageId
                        )
                    }
                }
        }
    }

}