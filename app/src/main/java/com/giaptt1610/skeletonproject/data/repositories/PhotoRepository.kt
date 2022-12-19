package com.giaptt1610.skeletonproject.data.repositories

import com.giaptt1610.skeletonproject.base.network.NetworkResult
import com.giaptt1610.skeletonproject.data.models.Photo
import com.giaptt1610.skeletonproject.data.services.PhotoLocalService
import com.giaptt1610.skeletonproject.data.services.PhotoRemoteService
import com.giaptt1610.skeletonproject.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photoRemoteService: PhotoRemoteService,
    private val photoLocalService: PhotoLocalService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend fun getListPhotos(page: Int, limit: Int) = withContext(dispatcher) {
        when (val result = photoRemoteService.getListPhoto(page, limit)) {
            is NetworkResult.Success -> {
                result.data
            }
            is NetworkResult.Error -> {
                throw result.exception
            }
        }
    }

    suspend fun saveToLocal() {

    }

    suspend fun loadFromLocal() {

    }
}