package br.com.tomazcuber.githubapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the owner of a GitHub repository.
 *
 * This class is marked as serializable, which means instances of this class can be serialized to and deserialized from JSON.
 * The SerialName annotation is used to specify the name of the corresponding property in the JSON object.
 *
 * @property avatarUrl The URL of the owner's avatar.
 * @property eventsUrl The URL of the owner's events.
 * @property followersUrl The URL of the owner's followers.
 * @property followingUrl The URL of the users the owner is following.
 * @property gistsUrl The URL of the owner's gists.
 * @property gravatarId The ID of the owner's Gravatar.
 * @property htmlUrl The HTML URL of the owner's profile.
 * @property id The ID of the owner.
 * @property nodeId The Node ID of the owner.
 * @property login The login name of the owner.
 * @property organizationsUrl The URL of the owner's organizations.
 * @property receivedEventsUrl The URL of the events received by the owner.
 * @property reposUrl The URL of the owner's repositories.
 * @property siteAdmin Whether the owner is a site admin.
 * @property starredUrl The URL of the repositories starred by the owner.
 * @property subscriptionsUrl The URL of the owner's subscriptions.
 * @property type The type of the owner (usually "User").
 * @property url The URL of the owner's GitHub API v3 endpoint.
 */
@Serializable
data class RepositoryOwner(
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("followers_url") val followersUrl: String,
    @SerialName("following_url") val followingUrl: String,
    @SerialName("gists_url") val gistsUrl: String,
    @SerialName("gravatar_id") val gravatarId: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("id") val id: Long,
    @SerialName("node_id") val nodeId: String,
    @SerialName("login") val login: String,
    @SerialName("organizations_url") val organizationsUrl: String,
    @SerialName("received_events_url") val receivedEventsUrl: String,
    @SerialName("repos_url") val reposUrl: String,
    @SerialName("site_admin") val siteAdmin: Boolean,
    @SerialName("starred_url") val starredUrl : String,
    @SerialName("subscriptions_url") val subscriptionsUrl: String,
    @SerialName("type") val type: String,
    @SerialName("url") val url: String
)