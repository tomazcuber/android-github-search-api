package br.com.githubsearch.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Repository(
    @PrimaryKey val id: Long,
    val userOwnerId: Long,
    val name: String,
    val description: String?,
    val language: String?,
    val stars: Int
)
