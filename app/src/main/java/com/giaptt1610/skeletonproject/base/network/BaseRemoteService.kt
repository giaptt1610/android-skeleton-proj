package com.giaptt1610.skeletonproject.base.network

import retrofit2.Response

open class BaseRemoteService : BaseService() {
    protected suspend fun <T : Any> callApi(call: suspend () -> Response<T>): NetworkResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()

        } catch (t: Throwable) {
            return NetworkResult.Error(parseNetworkException(t))
        }

        return if (response.isSuccessful) {
            if (response.body() == null) {
                NetworkResult.Error(
                    NetworkException(
                        message = "Response without body",
                        errorCode = response.code()
                    )
                )
            } else {
                NetworkResult.Success(response.body()!!)
            }
        } else {
            val errorBody = response.errorBody()?.toString() ?: ""
            NetworkResult.Error(parseError(response.message(), response.code(), errorBody))
        }
    }
}