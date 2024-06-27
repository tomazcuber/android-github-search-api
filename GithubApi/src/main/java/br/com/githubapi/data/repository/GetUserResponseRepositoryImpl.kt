package br.com.githubapi.data.repository

import br.com.githubapi.data.model.GetUserResponse
import br.com.githubapi.data.model.RepositoryResponse
import br.com.githubapi.network.GithubApiHelper
import br.com.githubapi.service.CacheService
import br.com.githubapi.network.NetworkResult
import javax.inject.Inject

class GetUserResponseRepositoryImpl @Inject constructor(
    private val githubApiHelper: GithubApiHelper,
) : GetUserResponseRepository {
    override suspend fun searchUser(username: String): NetworkResult<GetUserResponse> {
        return githubApiHelper.getUser(username)
    }

    override suspend fun listUsersRepositories(username: String): NetworkResult<List<RepositoryResponse>> {
        return githubApiHelper.getRepos(username)
    }
}