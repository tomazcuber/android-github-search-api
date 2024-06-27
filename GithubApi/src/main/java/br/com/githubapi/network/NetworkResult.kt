package br.com.githubapi.network

sealed class NetworkResult<out T> private constructor() {
    data class Success<T: Any>(val data: T) : NetworkResult<T>()
    data class Error<T: Any>(val code: Int, val message: String?) : NetworkResult<T>()
    data class Exception<T: Any>(val exception: Throwable) : NetworkResult<T>()
}
