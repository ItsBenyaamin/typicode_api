package com.benyaamin.bamachallenge.presentation.post

import androidx.annotation.StringRes
import com.benyaamin.bamachallenge.data.remote.dto.Post

data class PostState(
    val isLoading: Boolean = false,
    val post: Post? = null,
    val message: String = "",
    @StringRes val messageId: Int? = null
)