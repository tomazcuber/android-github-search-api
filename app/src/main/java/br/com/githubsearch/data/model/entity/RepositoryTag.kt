package br.com.githubsearch.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepositoryTag(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val commitSha: String,
    val repositoryName: String
)