package br.com.tomazcuber.githubapi.data.repository

import br.com.tomazcuber.githubapi.data.model.RepositoryResponse
import br.com.tomazcuber.githubapi.network.GithubApiHelper
import br.com.tomazcuber.githubapi.network.NetworkResult
import javax.inject.Inject

class UserReposResponseRepositoryImpl @Inject constructor(private val githubApiHelper: GithubApiHelper) :
    UserReposResponseRepository {
    override suspend fun listUsersRepositories(
        username: String,
        page: Int?,
        perPage: Int?,
        sort: String?,
        direction: String?
    ): NetworkResult<List<RepositoryResponse>> {
        return githubApiHelper.getRepos(username, page, perPage, sort, direction)
    }
}
