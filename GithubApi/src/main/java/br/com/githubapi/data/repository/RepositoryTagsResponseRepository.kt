package br.com.githubapi.data.repository

interface RepositoryTagsResponseRepository {
    suspend fun listRepositoryTags(ownerLogin: String, repositoryName: String){

    }
}