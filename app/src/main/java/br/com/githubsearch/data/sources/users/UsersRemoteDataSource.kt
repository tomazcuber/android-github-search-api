package br.com.githubsearch.data.sources.users

import br.com.tomazcuber.githubapi.client.GithubClient
import br.com.tomazcuber.githubapi.data.model.GetUserResponse
import br.com.tomazcuber.githubapi.network.NetworkResult
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