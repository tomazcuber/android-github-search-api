package br.com.githubsearch.data.repository

import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.sources.repositories.RepositoriesLocalDataSource
import br.com.githubsearch.data.sources.repositories.RepositoriesRemoteDataSource

class ReposRepository(
    private val repositoriesLocalDataSource: RepositoriesLocalDataSource,
    private val repositoriesRemoteDataSource: RepositoriesRemoteDataSource
) {
    suspend fun getRepositoriesByUserName(username: String): List<Repository>? {
        val localRepositories = repositoriesLocalDataSource.getRepositoriesByUserName(username)
        if (!localRepositories.isNullOrEmpty()) {
            return localRepositories
        }
        val remoteRepositories = repositoriesRemoteDataSource.listUserRepositories(username)
        repositoriesLocalDataSource.saveRepositories(remoteRepositories)
        return remoteRepositories
    }

    companion object {
        private const val REPOS_PAGE_SIZE = 10
    }
}