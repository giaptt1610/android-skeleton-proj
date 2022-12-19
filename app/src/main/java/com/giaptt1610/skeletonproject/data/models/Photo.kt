package com.giaptt1610.skeletonproject.data.models

import com.giaptt1610.skeletonproject.data.database.entities.PhotoEntity

data class Photo(
    val thumbnailUrl: String? = null,
    val title: String? = null,
    val url: String? = null
)

fun Photo.from(photoEntity: PhotoEntity): Photo {
    return Photo(
        thumbnailUrl = photoEntity.thumbnailUrl,
        title = photoEntity.title,
        url = photoEntity.url
    )
}

fun Photo.toEntity(): PhotoEntity {
    return PhotoEntity(
        thumbnailUrl = thumbnailUrl ?: "",
        title = title ?: "",
        url = url ?: ""
    )
}