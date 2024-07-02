package br.com.tomazcuber.githubapi.data.repository

import br.com.tomazcuber.githubapi.data.model.GetUserResponse
import br.com.tomazcuber.githubapi.network.GithubApiHelper
import br.com.tomazcuber.githubapi.network.NetworkResult
import javax.inject.Inject

class GetUserResponseRepositoryImpl @Inject constructor(
    private val githubApiHelper: GithubApiHelper,
) : GetUserResponseRepository {
    override suspend fun searchUser(username: String): NetworkResult<GetUserResponse> {
        return githubApiHelper.getUser(username)
    }
}