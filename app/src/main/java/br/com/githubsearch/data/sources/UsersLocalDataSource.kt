package br.com.githubsearch.data.sources

import br.com.githubsearch.data.db.AppDatabase
import javax.inject.Inject

class UsersLocalDataSource @Inject constructor(appDatabase: AppDatabase) {
    private val userDao = appDatabase.userDao()

    fun searchUser(username: String) {
        userDao.findByUsername(username)
    }

    fun getAllUsers() {
        userDao.getAll()
    }
}