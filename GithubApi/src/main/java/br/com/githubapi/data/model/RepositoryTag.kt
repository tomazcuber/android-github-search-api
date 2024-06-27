package br.com.githubapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryTag(
    @SerialName("name") val name: String,
    @SerialName("commit") val commit: Commit,
    @SerialName("zipball_url") val zipballUrl: String,
    @SerialName("tarball_url") val tarballUrl: String,
    @SerialName("node_id") val nodeId: String
)

@Serializable
data class Commit(
    @SerialName("sha") val sha: String,
    @SerialName("url") val url: String
)
