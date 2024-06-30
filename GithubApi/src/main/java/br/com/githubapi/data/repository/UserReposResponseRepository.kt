package br.com.githubapi.data.repository

import br.com.githubapi.data.model.RepositoryResponse
import br.com.githubapi.network.NetworkResult

interface UserReposResponseRepository {
    suspend fun listUsersRepositories(username: String): NetworkResult<List<RepositoryResponse>>
}