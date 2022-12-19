package com.giaptt1610.skeletonproject.base.network

abstract class BaseService {
    protected fun parseError(
        responseMessage: String?,
        responseCode: Int,
        errorBody: String?
    ): NetworkException {
        return NetworkException(responseMessage, responseCode)
    }

    protected fun parseNetworkException(throwable: Throwable): NetworkException {
        return NetworkException(throwable.message)
    }
}