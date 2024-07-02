package br.com.githubsearch.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Repository(
    @PrimaryKey val id: Long,
    val ownerUsername: String,
    val name: String,
    val description: String?,
    val stars: Int,
    val forks: Int
)
