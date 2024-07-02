package br.com.githubsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.githubsearch.data.model.entity.Repository

@Dao
abstract class RepositoryDao : BaseDao<Repository>{
    @Query("SELECT * FROM Repository WHERE name = :name")
    abstract suspend fun findByName(name: String) : Repository?

    @Query("SELECT * FROM Repository WHERE ownerUsername = :username")
    abstract suspend fun getAllByUsername(username: String) : List<Repository>?
}