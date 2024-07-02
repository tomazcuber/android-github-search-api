package br.com.tomazcuber.githubapi.data.repository

import br.com.tomazcuber.githubapi.data.model.GetUserResponse
import br.com.tomazcuber.githubapi.network.NetworkResult

interface GetUserResponseRepository {
    suspend fun searchUser(username: String): NetworkResult<GetUserResponse>
}