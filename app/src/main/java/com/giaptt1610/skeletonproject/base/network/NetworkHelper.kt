package com.giaptt1610.skeletonproject.base.network

import com.giaptt1610.skeletonproject.BuildConfig

object NetworkHelper {
    fun getDefaultHeader(): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        headers["Content-Type"] = "application/json"
        headers["Authorization"] = "Bearer ${BuildConfig.ACCESS_TOKEN}"
        return headers.toMap()
    }
}