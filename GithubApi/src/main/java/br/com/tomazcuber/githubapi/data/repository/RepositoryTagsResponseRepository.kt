package br.com.tomazcuber.githubapi.data.repository

import br.com.tomazcuber.githubapi.data.model.RepositoryTagsResponse
import br.com.tomazcuber.githubapi.network.NetworkResult

interface RepositoryTagsResponseRepository {
    suspend fun listRepositoryTags(
        ownerLogin: String,
        repositoryName: String,
        page: Int?,
        perPage: Int?,
    ): NetworkResult<List<RepositoryTagsResponse>>
}