package br.com.githubsearch.data.sources

import br.com.githubapi.client.GithubClient
import br.com.githubapi.network.NetworkResult
import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.model.relation.UserWithRepositories
import br.com.githubsearch.data.model.entity.Repository
import javax.inject.Inject

class RepositoriesRemoteDataSource @Inject constructor(private val githubClient: GithubClient) {


}