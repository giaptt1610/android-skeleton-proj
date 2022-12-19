package com.giaptt1610.skeletonproject.data.services

import android.util.Log
import com.giaptt1610.skeletonproject.data.apis.GitHubApi
import com.giaptt1610.skeletonproject.data.models.GithubUser
import javax.inject.Inject

class GithubRemoteService @Inject constructor(
    private val gitHubApi: GitHubApi
) {

    suspend fun searchUser(query: String): List<GithubUser>? {
        try {
            val response = gitHubApi.searchUser(query)
            if (response.isSuccessful) {
                val body = response.body()
                return body?.items
            }

            return null
        } catch (e: Exception) {
            Log.e("Giap", "searchUser error: ${e.message}")
            return null
        }
    }
}