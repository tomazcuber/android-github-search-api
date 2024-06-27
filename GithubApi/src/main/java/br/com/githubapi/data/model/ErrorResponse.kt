package br.com.githubapi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @Serializable
    val status: Int,
    @Serializable
    val message: String,
    @Serializable
    val documentationUrl: String
)
