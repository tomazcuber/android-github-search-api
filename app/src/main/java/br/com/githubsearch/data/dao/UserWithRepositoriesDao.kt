package br.com.githubsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.com.githubsearch.data.model.relation.UserWithRepositories

@Dao
interface UserWithRepositoriesDao {
    @Query("SELECT * FROM User Where username = :username LIMIT :limit")
    @Transaction
    abstract fun getRepositoriesByUsernameLimitedBy(username: String, limit: Int): UserWithRepositories?
}