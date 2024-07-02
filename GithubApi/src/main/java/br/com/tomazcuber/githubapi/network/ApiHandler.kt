package br.com.tomazcuber.githubapi.network

import retrofit2.HttpException
import retrofit2.Response

interface ApiHandler {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!, response.headers()["links"])
            } else NetworkResult.Error(response.code(), response.message())

        } catch (e: HttpException) {
            NetworkResult.Error(e.code(), e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}