package br.com.githubsearch.data.model.relation

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.model.entity.RepositoryTag


@Entity
data class RepositoryWithTags(
    @Embedded val repository: Repository,
    @Relation(
        parentColumn = "id",
        entityColumn = "repositoryName"
    )
    val repositoryTags: List<RepositoryTag>
)
