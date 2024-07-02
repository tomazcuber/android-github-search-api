package br.com.githubsearch.data.sources.tags

import br.com.tomazcuber.githubapi.client.GithubClient
import br.com.tomazcuber.githubapi.network.NetworkResult
import br.com.githubsearch.data.model.entity.RepositoryTag
import javax.inject.Inject

class RepositoryTagsRemoteDataSource @Inject constructor(private val githubClient: GithubClient) {
    suspend fun listRepositoryTags(username: String, repositoryName: String): List<RepositoryTag> {
        return when (val clientResponse =
            githubClient.listRepositoryTags(username, repositoryName)) {
            is NetworkResult.Success -> {
                clientResponse.data.map {
                    RepositoryTag(
                        name = it.name,
                        repositoryName = repositoryName,
                        commitSha = it.commit.sha,
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