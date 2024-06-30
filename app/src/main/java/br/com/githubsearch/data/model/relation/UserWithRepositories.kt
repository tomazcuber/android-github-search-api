package br.com.githubsearch.data.model.relation

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.model.entity.User

@Entity
data class UserWithRepositories(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userOwnerId"
    )
    val repositories: List<Repository>
)
