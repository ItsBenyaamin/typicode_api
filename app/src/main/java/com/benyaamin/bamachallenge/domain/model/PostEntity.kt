package com.benyaamin.bamachallenge.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey()
    val postId: Int,
    val userId: Int,
    val title: String,
    val body: String,
)
