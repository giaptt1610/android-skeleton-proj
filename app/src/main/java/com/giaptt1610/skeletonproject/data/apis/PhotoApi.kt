package com.giaptt1610.skeletonproject.data.apis

import com.giaptt1610.skeletonproject.data.models.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PhotoApi {

    @GET("/photos")
    suspend fun getPhotos(
        @Query("_page") page: Int = 1,
        @Query("_limit") limit: Int = 10,
    ): Response<List<Photo>>
}