package br.com.githubsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.model.relation.UserWithRepositories

@Dao
abstract class UserDao: BaseDao<User> {
    @Query("SELECT * FROM User")
    abstract fun getAll(): List<User>

    @Query("SELECT * FROM User Where username = :username")
    abstract fun findByUsername(username: String): User

    @Query("SELECT * FROM User Where username = :username")
    @Transaction
    abstract fun getUserWithRepositories(username: String): UserWithRepositories

    @Upsert
    abstract fun addRepository(repository: Repository)
}