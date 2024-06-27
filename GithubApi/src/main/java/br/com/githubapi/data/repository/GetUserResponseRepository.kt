package br.com.githubapi.data.repository

import br.com.githubapi.data.model.GetUserResponse
import br.com.githubapi.data.model.RepositoryResponse
import br.com.githubapi.network.NetworkResult

interface GetUserResponseRepository {
    suspend fun searchUser(username: String): NetworkResult<GetUserResponse>
    suspend fun listUsersRepositories(username: String): NetworkResult<List<RepositoryResponse>>
}