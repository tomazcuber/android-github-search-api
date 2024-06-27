package br.com.githubsearch.data.sources

import br.com.githubapi.GitHubApiInitializer
import br.com.githubapi.client.GithubClient
import br.com.githubapi.data.model.GetUserResponse
import br.com.githubapi.network.NetworkResult
import br.com.githubsearch.data.model.User

class UsersRemoteDataSource {
    private var githubClient: GithubClient

    init {
        GitHubApiInitializer.initialize()
        githubClient = GitHubApiInitializer.githubClient
    }

    suspend fun searchUser(username: String) : User? {
        return when(val clientResponse = githubClient.searchUser(username)) {
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