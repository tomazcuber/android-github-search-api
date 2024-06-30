package br.com.githubsearch.data.sources

import br.com.githubapi.client.GithubClient
import br.com.githubapi.data.model.GetUserResponse
import br.com.githubapi.network.NetworkResult
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.model.entity.User
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(private val githubClient: GithubClient) {
    suspend fun searchUser(username: String): User? {
        return when (val clientResponse = githubClient.searchUser(username)) {
            is NetworkResult.Success -> {
                convertToUser(clientResponse.data)
            }

            is NetworkResult.Error -> {
                null
            }

            is NetworkResult.Exception -> {
                throw Exception(clientResponse.exception)
            }
        }
    }

    suspend fun listUserRepositories(user: User): List<Repository> {
        return when (val clientResponse = githubClient.searchUserRepositories(user.username)) {
            is NetworkResult.Success -> {
                clientResponse.data.map {
                    Repository(
                        id = it.id,
                        name = it.name,
                        description = it.description,
                        stars = it.stargazersCount,
                        forks = it.forksCount,
                        userOwnerId = user.id
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



    private fun convertToUser(userResponse: GetUserResponse): User {
        return User(
            id = userResponse.id,
            username = userResponse.login,
            avatarURL = userResponse.avatarUrl,
            name = userResponse.name,
            email = userResponse.email,
            location = userResponse.location,
            bio = userResponse.bio,
            totalPublicRepos = userResponse.publicRepos,
        )
    }

}