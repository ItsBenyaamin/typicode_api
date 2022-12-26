package com.benyaamin.bamachallenge.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    val userId: Int,
    val postId: Int,
    val title: String,
    val body: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
