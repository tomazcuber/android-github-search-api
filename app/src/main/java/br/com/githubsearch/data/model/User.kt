package br.com.githubsearch.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Long,
    val username: String,
    val avatarURL: String,
    val name: String?,
    val email: String?,
    val location: String?,
    val bio: String?,
    val totalPublicRepos: Int,
)
