package com.benyaamin.bamachallenge.data.remote.dto

import com.squareup.moshi.Json

data class Post(
    @field:Json(name = "userId") val userId: Int,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "body") val body: String,
)
