package br.com.githubsearch.data.repository

import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.sources.users.UsersLocalDataSource
import br.com.githubsearch.data.sources.users.UsersRemoteDataSource

class UsersRepository(
    private val localDataSource: UsersLocalDataSource,
    private val remoteDataSource: UsersRemoteDataSource
) {
    suspend fun getUser(username: String): User? {
//        var user = localDataSource.getUser(username)
//        if (user != null) {
//            return user
//        }
        val user = remoteDataSource.searchUser(username)
        if (user != null) {
            localDataSource.saveUser(user)
        }
        return user
    }
}