package br.com.tomazcuber.githubapi.data.repository

import br.com.tomazcuber.githubapi.data.model.RepositoryResponse
import br.com.tomazcuber.githubapi.network.NetworkResult

interface UserReposResponseRepository {
    suspend fun listUsersRepositories(
        username: String,
        page: Int?,
        perPage: Int?,
        sort: String?,
        direction: String?
    ): NetworkResult<List<RepositoryResponse>>
}