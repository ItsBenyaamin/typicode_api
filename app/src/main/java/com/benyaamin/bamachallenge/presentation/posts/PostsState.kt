package com.benyaamin.bamachallenge.presentation.posts

import androidx.annotation.StringRes
import com.benyaamin.bamachallenge.data.remote.dto.Post

data class PostsState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val message: String = "",
    @StringRes val messageId: Int? = null
)
