package br.com.githubsearch.data.model.entity

data class PagedEntity<T>(
    val entityList: List<T>,
    val nextPage: Int?,
    val previousPage: Int?,
    val firstPage: Int?,
    val lastPage: Int?,
    val links: Map<String, String>?
)
