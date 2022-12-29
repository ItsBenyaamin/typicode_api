package com.benyaamin.bamachallenge.presentation.post

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.domain.repository.PostRepository
import com.benyaamin.bamachallenge.util.BaseState
import com.benyaamin.bamachallenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {
    var state by mutableStateOf(BaseState<Post>())

    fun getPost(postId: Int) {
        viewModelScope.launch {
            postRepository.getPost(postId)
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