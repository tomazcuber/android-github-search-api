package br.com.githubsearch.data.repository

import br.com.githubsearch.data.model.User
import br.com.githubsearch.data.sources.UsersLocalDataSource
import br.com.githubsearch.data.sources.UsersRemoteDataSource

class UsersRepository(
    private val localDataSource: UsersLocalDataSource,
    private val remoteDataSource: UsersRemoteDataSource
) {
    fun getAllSavedUsers() = localDataSource.getAllUsers()

    suspend fun searchUser(username: String) = remoteDataSource.searchUser(username)
}