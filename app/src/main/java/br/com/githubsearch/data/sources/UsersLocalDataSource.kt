package br.com.githubsearch.data.sources

import br.com.githubsearch.data.db.AppDatabase
import br.com.githubsearch.data.model.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersLocalDataSource @Inject constructor(appDatabase: AppDatabase) {
    private val userDao = appDatabase.userDao()

    fun searchUser(username: String) {
        userDao.findByUsername(username)
    }

    fun getAllUsers() {
        userDao.getAll()
    }

    fun saveUser(userResult: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.upsert(userResult)
        }
    }
}