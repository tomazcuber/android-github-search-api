package br.com.githubapi.network

import br.com.githubapi.service.GithubApiService
import javax.inject.Inject

class GithubApiHelper @Inject constructor(private val apiService: GithubApiService): ApiHandler {
    suspend fun getUser(userName: String) = handleApi { apiService.getUser(userName)  }
    suspend fun getRepos(userName: String) = handleApi { apiService.listUsersRepositories(userName) }
    suspend fun getTags(owner: String, repo: String) = handleApi { apiService.listRepositoryTags(owner, repo) }
}