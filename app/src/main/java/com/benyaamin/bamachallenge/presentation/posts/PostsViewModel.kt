package com.benyaamin.bamachallenge.presentation.posts

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benyaamin.bamachallenge.domain.repository.PostRepository
import com.benyaamin.bamachallenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {
    var state by mutableStateOf(PostsState())

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            postRepository.getPosts()
                .collect {result ->
                    state = when(result) {
                        is Resource.OnLoading -> state.copy(isLoading = result.isLoading)
                        is Resource.OnSuccess -> state.copy(posts = result.data!!)
                        is Resource.OnError -> state.copy(
                            message = result.message,
                            messageId = result.messageId
                        )
                    }
                }

        }
    }

}