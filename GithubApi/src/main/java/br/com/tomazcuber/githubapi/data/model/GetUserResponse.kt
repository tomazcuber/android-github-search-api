package br.com.tomazcuber.githubapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the response from the GitHub API when fetching a user's details.
 *
 * This class is marked as serializable to allow kotlinx.serialization to automatically
 * convert JSON data into an instance of this class.
 *
 * @property login The username of the user.
 * @property id The unique ID of the user.
 * @property nodeId The node ID of the user.
 * @property avatarUrl The URL of the user's avatar image.
 * @property gravatarId The ID of the user's Gravatar, or null if the user does not have a Gravatar.
 * @property url The URL of the user's GitHub profile.
 * @property htmlUrl The URL of the user's GitHub profile (HTML version).
 * @property followersUrl The URL to fetch the user's followers.
 * @property followingUrl The URL to fetch the users that the user is following.
 * @property gistsUrl The URL to fetch the user's gists.
 * @property starredUrl The URL to fetch the repositories that the user has starred.
 * @property subscriptionsUrl The URL to fetch the repositories that the user is watching.
 * @property organizationsUrl The URL to fetch the organizations that the user is a member of.
 * @property reposUrl The URL to fetch the user's repositories.
 * @property eventsUrl The URL to fetch the events for the user.
 * @property receivedEventsUrl The URL to fetch the events received by the user.
 * @property type The type of the user (usually "User").
 * @property siteAdmin Whether the user is a site administrator.
 * @property name The full name of the user, or null if the user has not provided their full name.
 * @property company The user's company, or null if the user has not provided their company.
 * @property blog The user's blog URL, or null if the user has not provided their blog URL.
 * @property location The user's location, or null if the user has not provided their location.
 * @property email The user's email, or null if the user has not provided their email.
 * @property hireable Whether the user is hireable, or null if the user has not specified their hireable status.
 * @property bio The user's bio, or null if the user has not provided their bio.
 * @property twitterUsername The user's Twitter username, or null if the user has not provided their Twitter username.
 * @property publicRepos The number of public repositories owned by the user.
 * @property publicGists The number of public gists owned by the user.
 * @property followers The number of followers the user has.
 * @property following The number of users the user is following.
 * @property createdAt The date and time when the user's account was created.
 * @property updatedAt The date and time when the user's profile was last updated.
 * @property plan The user's GitHub plan, or null if the user is on the free plan.
 * @property suspendedAt The date and time when the user's account was suspended, or null if the user's account is not suspended.
 * @property privateGists The number of private gists owned by the user, or null if the user does not have any private gists.
 * @property totalPrivateRepos The total number of private repositories owned by the user, or null if the user does not have any private repositories.
 * @property ownedPrivateRepos The number of private repositories owned by the user, or null if the user does not have any private repositories.
 * @property diskUsage The amount of disk space used by the user, in kilobytes, or null if the disk usage is not available.
 * @property collaborators The number of collaborators across the user's private repositories, or null if the user does not have any private repositories.
 */
@Serializable
data class GetUserResponse(
    @SerialName("login") val login: String,
    @SerialName("id") val id: Long,
    @SerialName("node_id") val nodeId: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("gravatar_id") val gravatarId: String? = null,
    @SerialName("url") val url: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("followers_url") val followersUrl: String,
    @SerialName("following_url") val followingUrl: String,
    @SerialName("gists_url") val gistsUrl: String,
    @SerialName("starred_url") val starredUrl: String,
    @SerialName("subscriptions_url") val subscriptionsUrl: String,
    @SerialName("organizations_url") val organizationsUrl: String,
    @SerialName("repos_url") val reposUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("received_events_url") val receivedEventsUrl: String,
    @SerialName("type") val type: String,
    @SerialName("site_admin") val siteAdmin: Boolean,
    @SerialName("name") val name: String? = null,
    @SerialName("company") val company: String? = null,
    @SerialName("blog") val blog: String? = null,
    @SerialName("location") val location: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("hireable") val hireable: Boolean? = null,
    @SerialName("bio") val bio: String? = null,
    @SerialName("twitter_username") val twitterUsername: String? = null,
    @SerialName("public_repos") val publicRepos: Int,
    @SerialName("public_gists") val publicGists: Int,
    @SerialName("followers") val followers: Int,
    @SerialName("following") val following: Int,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("plan") val plan: UserPlan? = null,
    @SerialName("suspended_at") val suspendedAt: String? = null,
    @SerialName("private_gists") val privateGists: Int? = null,
    @SerialName("total_private_repos") val totalPrivateRepos: Int? = null,
    @SerialName("owned_private_repos") val ownedPrivateRepos: Int? = null,
    @SerialName("disk_usage") val diskUsage: Int? = null,
    @SerialName("collaborators") val collaborators: Int? = null
)

