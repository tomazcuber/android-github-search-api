package br.com.githubsearch.data.sources.users

import br.com.githubsearch.data.db.AppDatabase
import br.com.githubsearch.data.model.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersLocalDataSource @Inject constructor(appDatabase: AppDatabase) {
    private val userDao = appDatabase.userDao()

    fun saveUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.upsert(user)
        }
    }

    suspend fun getUser(username: String): User? {
        return withContext(Dispatchers.IO){
            userDao.findByUsername(username)
        }
    }

    suspend fun getAllUsers(): List<User>? {
        return withContext(Dispatchers.IO){
            userDao.getAll()
        }
    }
}