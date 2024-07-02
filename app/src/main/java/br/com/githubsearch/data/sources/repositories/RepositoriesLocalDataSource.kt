package br.com.githubsearch.data.sources.repositories

import br.com.githubsearch.data.db.AppDatabase
import br.com.githubsearch.data.model.entity.Repository
import javax.inject.Inject

class RepositoriesLocalDataSource @Inject constructor(private val appDatabase: AppDatabase) {
    private val repositoriesDao = appDatabase.repositoryDao()

    suspend fun getRepositoriesByUserName(username: String): List<Repository>? {
        return repositoriesDao.getAllByUsername(username)
    }

    suspend fun saveRepositories(repositories: List<Repository>) {
        repositoriesDao.upsert(repositories)
    }

}