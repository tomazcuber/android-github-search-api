package br.com.githubapi.data.repository

import br.com.githubapi.data.model.RepositoryResponse
import br.com.githubapi.network.GithubApiHelper
import br.com.githubapi.network.NetworkResult
import javax.inject.Inject

class UserReposResponseRepositoryImpl @Inject constructor(private val githubApiHelper: GithubApiHelper) :
    UserReposResponseRepository {
    override suspend fun listUsersRepositories(username: String): NetworkResult<List<RepositoryResponse>> {
        return githubApiHelper.getRepos(username)
    }
}
