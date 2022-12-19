package com.giaptt1610.skeletonproject.data.repositories

import com.giaptt1610.skeletonproject.data.models.GithubUser
import com.giaptt1610.skeletonproject.data.services.GithubRemoteService
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubRemoteService: GithubRemoteService
) {

    suspend fun searchUser(query: String): List<GithubUser>? = githubRemoteService.searchUser(query)
}