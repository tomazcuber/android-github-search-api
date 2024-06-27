package br.com.githubapi.network

import retrofit2.HttpException
import retrofit2.Response

interface ApiHandler {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(body)
            } else NetworkResult.Error(response.code(), response.message())

        } catch (e: HttpException) {
            NetworkResult.Error(e.code(), e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}