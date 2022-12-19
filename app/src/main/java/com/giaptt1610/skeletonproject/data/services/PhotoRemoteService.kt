package com.giaptt1610.skeletonproject.data.services

import android.util.Log
import com.giaptt1610.skeletonproject.base.network.BaseRemoteService
import com.giaptt1610.skeletonproject.base.network.NetworkResult
import com.giaptt1610.skeletonproject.data.apis.PhotoApi
import com.giaptt1610.skeletonproject.data.models.Photo
import javax.inject.Inject

class PhotoRemoteService @Inject constructor(
    private val photoApi: PhotoApi
) : BaseRemoteService() {
    suspend fun getListPhoto(page: Int, limit: Int): NetworkResult<List<Photo>> {
        return callApi {
            photoApi.getPhotos(page, limit)
        }
    }
}