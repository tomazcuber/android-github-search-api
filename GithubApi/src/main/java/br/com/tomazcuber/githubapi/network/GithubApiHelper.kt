package br.com.tomazcuber.githubapi.network

import br.com.tomazcuber.githubapi.service.GithubApiService
import javax.inject.Inject

class GithubApiHelper @Inject constructor(private val apiService: GithubApiService) : ApiHandler {
    suspend fun getUser(userName: String) = handleApi { apiService.getUser(userName) }
    suspend fun getRepos(
        userName: String,
        page: Int?,
        perPage: Int?,
        sort: String?,
        direction: String?
    ) = handleApi { apiService.listUsersRepositories(userName, page, perPage, sort, direction) }

    suspend fun getTags(owner: String, repo: String, page: Int?, perPage: Int?) =
        handleApi { apiService.listRepositoryTags(owner, repo, page, perPage) }
}