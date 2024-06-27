package br.com.githubsearch.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class UserWithRepositories(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userOwnerId"
    )
    val repositories: List<Repository>
)
