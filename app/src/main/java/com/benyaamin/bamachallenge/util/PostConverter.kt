package com.benyaamin.bamachallenge.util

import com.benyaamin.bamachallenge.data.remote.dto.Post
import com.benyaamin.bamachallenge.domain.PostEntity

fun PostEntity.toPost(): Post {
    return Post(
        postId,
        userId,
        title,
        body
    )
}

fun Post.toEntity(): PostEntity {
    return PostEntity(
        userId,
        id,
        title,
        body
    )
}