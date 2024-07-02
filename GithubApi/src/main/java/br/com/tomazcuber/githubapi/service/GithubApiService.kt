package br.com.tomazcuber.githubapi.service

import br.com.tomazcuber.githubapi.data.model.GetUserResponse
import br.com.tomazcuber.githubapi.data.model.RepositoryResponse
import br.com.tomazcuber.githubapi.data.model.RepositoryTagsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): Response<GetUserResponse>

    @GET("users/{username}/repos")
    suspend fun listUsersRepositories(
        @Path("username") username: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("sort") sort: String?,
        @Query("direction") direction: String?
    ): Response<List<RepositoryResponse>>

    @GET("/repos/{owner}/{repo}/tags")
    suspend fun listRepositoryTags(
        @Path("owner") username: String,
        @Path("repo") repositoryName: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
    ): Response<List<RepositoryTagsResponse>>

}