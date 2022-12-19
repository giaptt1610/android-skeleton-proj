package com.giaptt1610.skeletonproject.data.services


import com.giaptt1610.skeletonproject.data.database.dao.PhotoDao
import com.giaptt1610.skeletonproject.data.models.Photo
import com.giaptt1610.skeletonproject.data.models.toEntity
import javax.inject.Inject

class PhotoLocalService @Inject constructor(
    private val photoDao: PhotoDao
) {
    suspend fun addNewPhoto(photo: Photo) {
        photoDao.insert(photo.toEntity())
    }

    suspend fun updatePhoto(photo: Photo) {
        photoDao.update(photo.toEntity())
    }

    suspend fun deletePhoto(photo: Photo) {
        photoDao.delete(photo.toEntity())
    }

}