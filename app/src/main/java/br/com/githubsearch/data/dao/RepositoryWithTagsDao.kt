package br.com.githubsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.com.githubsearch.data.model.relation.RepositoryWithTags

@Dao
interface RepositoryWithTagsDao {
    @Query("SELECT * FROM Repository WHERE name = :name")
    @Transaction
    abstract fun getRepositoryWithTagsByName(name: String): RepositoryWithTags?
}