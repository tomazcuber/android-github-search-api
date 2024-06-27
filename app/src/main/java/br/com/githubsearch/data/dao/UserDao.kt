package br.com.githubsearch.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.githubsearch.data.model.User
import br.com.githubsearch.data.model.UserWithRepositories

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User Where username = :username")
    fun findByUsername(username: String): User

    @Query("SELECT * FROM User Where username = :username")
    @Transaction
    fun getUserWithRepositories(username: String): UserWithRepositories

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}