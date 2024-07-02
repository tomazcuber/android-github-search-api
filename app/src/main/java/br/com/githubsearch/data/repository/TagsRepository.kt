package br.com.githubsearch.data.repository

import br.com.githubsearch.data.model.entity.RepositoryTag
import br.com.githubsearch.data.sources.tags.RepositoryTagsLocalDataSource
import br.com.githubsearch.data.sources.tags.RepositoryTagsRemoteDataSource

class TagsRepository(private val tagsLocalDataSource: RepositoryTagsLocalDataSource, private val tagsRemoteDataSource: RepositoryTagsRemoteDataSource){
    suspend fun getRepositoryTags(username: String, repositoryName: String) : List<RepositoryTag>{
        return tagsRemoteDataSource.listRepositoryTags(username, repositoryName)
    }
}