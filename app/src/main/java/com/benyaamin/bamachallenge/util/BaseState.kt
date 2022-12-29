package com.benyaamin.bamachallenge.util

import androidx.annotation.StringRes

data class BaseState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val message: String = "",
    @StringRes val messageId: Int? = null
)