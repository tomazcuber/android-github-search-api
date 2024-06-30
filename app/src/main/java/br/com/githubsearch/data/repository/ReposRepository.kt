package br.com.githubsearch.data.repository

import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.model.relation.UserWithRepositories
import br.com.githubsearch.data.sources.RepositoriesLocalDataSource
import br.com.githubsearch.data.sources.RepositoriesRemoteDataSource

class ReposRepository(
    private val repositoriesLocalDataSource: RepositoriesLocalDataSource,
    private val repositoriesRemoteDataSource: RepositoriesRemoteDataSource
) {

}