package com.giaptt1610.skeletonproject.data.models


import com.google.gson.annotations.SerializedName

data class GitHubSearchResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,
    @SerializedName("total_count")
    val totalCount: Int? = null,
    @SerializedName("items")
    val items: List<GithubUser> = listOf()
)