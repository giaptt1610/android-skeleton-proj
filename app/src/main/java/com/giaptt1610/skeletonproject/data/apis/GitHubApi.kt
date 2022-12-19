package com.giaptt1610.skeletonproject.data.apis

import com.giaptt1610.skeletonproject.data.models.GitHubSearchResponse
import com.giaptt1610.skeletonproject.data.models.GithubUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitHubApi {

    @Headers("Accept: application/vnd.github+json")
    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10
    ): Response<GitHubSearchResponse>
}