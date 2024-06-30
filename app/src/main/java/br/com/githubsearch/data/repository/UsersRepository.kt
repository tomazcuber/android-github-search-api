package br.com.githubsearch.data.repository

import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.model.relation.UserWithRepositories
import br.com.githubsearch.data.sources.UsersLocalDataSource
import br.com.githubsearch.data.sources.UsersRemoteDataSource

class UsersRepository(
    private val localDataSource: UsersLocalDataSource,
    private val remoteDataSource: UsersRemoteDataSource
) {
    fun getAllSavedUsers() = localDataSource.getAllUsers()

    suspend fun searchUser(username: String) : User? {
        val userResult = remoteDataSource.searchUser(username)
        if(userResult != null) {
            localDataSource.saveUser(userResult)
        }
        return userResult
    }

    suspend fun listUserRepositories(username: String): UserWithRepositories {
        val user = searchUser(username) ?: throw Exception("User not found")
        return UserWithRepositories(
            user = user,
            repositories = remoteDataSource.listUserRepositories(user)
        )
    }

//    suspend fun get
}