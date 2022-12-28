package com.benyaamin.bamachallenge.util

import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.domain.model.PostEntity

fun PostEntity.toPost(): Post {
    return Post(
        userId,
        postId,
        title,
        body
    )
}

fun Post.toEntity(): PostEntity {
    return PostEntity(
        id,
        userId,
        title,
        body
    )
}