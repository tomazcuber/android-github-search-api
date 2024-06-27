package br.com.githubapi.service

import br.com.githubapi.data.model.GetUserResponse
import br.com.githubapi.data.model.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): Response<GetUserResponse>

    @GET("users/{username}/repos")
    suspend fun listUsersRepositories(@Path("username") username: String): Response<List<RepositoryResponse>>

    @GET("/repos/{owner}/{repo}/tags")
    suspend fun listRepositoryTags(
        @Path("owner") username: String, @Path("repo") repositoryName: String
    ): Response<List<String>>
}