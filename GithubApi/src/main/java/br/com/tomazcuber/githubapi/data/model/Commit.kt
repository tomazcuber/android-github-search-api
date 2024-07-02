package br.com.tomazcuber.githubapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a commit in a GitHub repository.
 *
 * This class is marked as serializable, which means instances of this class can be serialized to and deserialized from JSON.
 * The SerialName annotation is used to specify the name of the corresponding property in the JSON object.
 *
 * @property sha The SHA of the commit.
 * @property url The URL of the commit.
 */
@Serializable
data class Commit(
    @SerialName("sha") val sha: String,
    @SerialName("url") val url: String
)