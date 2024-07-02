package br.com.githubsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.githubsearch.data.model.entity.User

@Dao
abstract class UserDao: BaseDao<User> {
    @Query("SELECT * FROM User")
    abstract fun getAll(): List<User>?

    @Query("SELECT * FROM User Where username = :username")
    abstract fun findByUsername(username: String): User?
}