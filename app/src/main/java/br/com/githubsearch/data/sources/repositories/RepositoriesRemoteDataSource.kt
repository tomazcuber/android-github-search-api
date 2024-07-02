package br.com.githubsearch.data.sources.repositories

import br.com.tomazcuber.githubapi.client.GithubClient
import br.com.tomazcuber.githubapi.network.NetworkResult
import br.com.githubsearch.data.model.entity.Repository
import javax.inject.Inject

class RepositoriesRemoteDataSource @Inject constructor(private val githubClient: GithubClient) {
    suspend fun listUserRepositories(
        username: String,
    ): List<Repository> {
        return when (val clientResponse =
            githubClient.searchUserRepositories(username)) {
            is NetworkResult.Success -> {
                    clientResponse.data.map {
                        Repository(
                            id = it.id,
                            name = it.name,
                            description = it.description,
                            stars = it.stargazersCount,
                            forks = it.forksCount,
                            ownerUsername = username
                        )
                    }
            }

            is NetworkResult.Error -> {
                emptyList()
            }

            is NetworkResult.Exception -> {
                throw Exception(clientResponse.exception)
            }
        }
    }
}