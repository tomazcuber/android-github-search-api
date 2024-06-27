package br.com.githubapi.data.model

data class RepositoryResponse(
    val id: Long,
    val name: String,
    val fullName: String,
    val owner: String,
    val private: Boolean,
    val htmlURL: String,
    val description: String?,
    val fork: Boolean,
    val url: String,
    val createdAt: String,
    val updatedAt: String,
    val pushedAt: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val tags: List<RepositoryTag>
)
