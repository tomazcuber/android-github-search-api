package br.com.tomazcuber.githubapi.data.repository

import br.com.tomazcuber.githubapi.data.model.RepositoryTagsResponse
import br.com.tomazcuber.githubapi.network.GithubApiHelper
import br.com.tomazcuber.githubapi.network.NetworkResult
import javax.inject.Inject

class RepositoryTagsResponseRepositoryImpl @Inject constructor(private val githubApiHelper: GithubApiHelper) :
    RepositoryTagsResponseRepository {
    override suspend fun listRepositoryTags(
        ownerLogin: String,
        repositoryName: String,
        page: Int?,
        perPage: Int?,
    ): NetworkResult<List<RepositoryTagsResponse>> {
        return githubApiHelper.getTags(ownerLogin, repositoryName, page, perPage)
    }
}