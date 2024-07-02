package br.com.tomazcuber.githubapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a tag in a GitHub repository.
 *
 * This class is marked as serializable, which means instances of this class can be serialized to and deserialized from JSON.
 * The SerialName annotation is used to specify the name of the corresponding property in the JSON object.
 *
 * @property name The name of the tag.
 * @property commit The commit associated with the tag.
 * @property zipballUrl The URL to download the repository source code as a zip archive at this tag.
 * @property tarballUrl The URL to download the repository source code as a tar archive at this tag.
 * @property nodeId The Node ID of the tag.
 */
@Serializable
data class RepositoryTagsResponse(
    @SerialName("name") val name: String,
    @SerialName("commit") val commit: Commit,
    @SerialName("zipball_url") val zipballUrl: String,
    @SerialName("tarball_url") val tarballUrl: String,
    @SerialName("node_id") val nodeId: String
)

