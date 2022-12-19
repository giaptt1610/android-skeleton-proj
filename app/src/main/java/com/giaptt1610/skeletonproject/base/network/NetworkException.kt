package com.giaptt1610.skeletonproject.base.network

class NetworkException(
    message: String? = null,
    val errorCode: Int = -1,
) : Exception(message) {
}