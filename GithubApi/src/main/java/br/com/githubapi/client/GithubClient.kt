package br.com.githubapi.client

import br.com.githubapi.data.model.GetUserResponse
import br.com.githubapi.data.model.RepositoryResponse
import br.com.githubapi.data.repository.GetUserResponseRepository
import br.com.githubapi.network.NetworkResult
import javax.inject.Inject

class GithubClient @Inject constructor(private val getUserResponseRepository: GetUserResponseRepository) {
    suspend fun searchUser(username: String): NetworkResult<GetUserResponse> {
        return getUserResponseRepository.searchUser(username)
    }
    suspend fun searchUserRepositories(username: String): NetworkResult<List<RepositoryResponse>> {
        return getUserResponseRepository.listUsersRepositories(username)
    }
}