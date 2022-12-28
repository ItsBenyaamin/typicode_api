package com.benyaamin.bamachallenge.util

import androidx.annotation.StringRes

sealed class Resource<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val message: String = "",
    @StringRes val messageId: Int? = null
) {
    class OnLoading<T>(isLoading: Boolean) : Resource<T>(isLoading = isLoading)
    class OnSuccess<T>(data: T) : Resource<T>(data = data)
    class OnError<T>(messageId: Int? = null, message: String = "") : Resource<T>(message = message, messageId = messageId)
}
