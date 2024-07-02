package br.com.tomazcuber.githubapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a response from the GitHub repository API.
 *
 * This class is marked as serializable, which means instances of this class can be serialized to and deserialized from JSON.
 * The SerialName annotation is used to specify the name of the corresponding property in the JSON object.
 *
 * @property archiveUrl The URL to fetch an archive from the repository.
 * @property assigneesUrl The URL to fetch the assignees from the repository.
 * @property blobsUrl The URL to fetch the blobs from the repository.
 * @property branchesUrl The URL to fetch the branches from the repository.
 * @property collaboratorsUrl The URL to fetch the collaborators from the repository.
 * @property commentsUrl The URL to fetch the comments from the repository.
 * @property commitsUrl The URL to fetch the commits from the repository.
 * @property compareUrl The URL to fetch the compare view for the repository.
 * @property contentsUrl The URL to fetch the contents from the repository.
 * @property contributorsUrl The URL to fetch the contributors from the repository.
 * @property deploymentsUrl The URL to fetch the deployments from the repository.
 * @property description The description of the repository.
 * @property downloadsUrl The URL to fetch the downloads from the repository.
 * @property eventsUrl The URL to fetch the events from the repository.
 * @property fork Whether the repository is a fork of another repository.
 * @property forksUrl The URL to fetch the forks from the repository.
 * @property forksCount The number of forks of the repository.
 * @property fullName The full name of the repository, including the owner's name.
 * @property owner The owner of the repository.
 * @property gitCommitsUrl The URL to fetch the Git commits from the repository.
 * @property gitRefsUrl The URL to fetch the Git references from the repository.
 * @property gitTagsUrl The URL to fetch the Git tags from the repository.
 * @property hooksUrl The URL to fetch the hooks from the repository.
 * @property htmlUrl The HTML URL of the repository.
 * @property id The ID of the repository.
 * @property nodeId The Node ID of the repository.
 * @property issueCommentUrl The URL to fetch the issue comments from the repository.
 * @property issueEventsUrl The URL to fetch the issue events from the repository.
 * @property issuesUrl The URL to fetch the issues from the repository.
 * @property keysUrl The URL to fetch the keys from the repository.
 * @property languagesUrl The URL to fetch the languages used in the repository.
 * @property mergesUrl The URL to fetch the merges from the repository.
 * @property milestonesUrl The URL to fetch the milestones from the repository.
 * @property name The name of the repository.
 * @property notificationsUrl The URL to fetch the notifications for the repository.
 * @property private Whether the repository is private.
 * @property pullsUrl The URL to fetch the pull requests from the repository.
 * @property releasesUrl The URL to fetch the releases from the repository.
 * @property stargazersUrl The URL to fetch the stargazers from the repository.
 * @property stargazersCount The number of stargazers for the repository.
 * @property statusesUrl The URL to fetch the statuses from the repository.
 * @property subscribersUrl The URL to fetch the subscribers from the repository.
 * @property subscriptionUrl The URL to fetch the subscription information from the repository.
 * @property tagsUrl The URL to fetch the tags from the repository.
 * @property teamsUrl The URL to fetch the teams from the repository.
 * @property treesUrl The URL to fetch the trees from the repository.
 * @property url The URL of the repository.
 */
//TODO: Add missing fields that are not 'required' in the API response
@Serializable
data class RepositoryResponse(
    @SerialName("archive_url") val archiveUrl: String,
    @SerialName("assignees_url") val assigneesUrl: String,
    @SerialName("blobs_url") val blobsUrl: String,
    @SerialName("branches_url") val branchesUrl: String,
    @SerialName("collaborators_url") val collaboratorsUrl: String,
    @SerialName("comments_url") val commentsUrl: String,
    @SerialName("commits_url") val commitsUrl: String,
    @SerialName("compare_url") val compareUrl: String,
    @SerialName("contents_url") val contentsUrl: String,
    @SerialName("contributors_url") val contributorsUrl: String,
    @SerialName("deployments_url") val deploymentsUrl: String,
    @SerialName("description") val description: String?,
    @SerialName("downloads_url") val downloadsUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("fork") val fork: Boolean,
    @SerialName("forks_url") val forksUrl: String,
    @SerialName("forks_count") val forksCount: Int,
    @SerialName("full_name") val fullName: String,
    @SerialName("owner") val owner: RepositoryOwner,
    @SerialName("git_commits_url") val gitCommitsUrl: String,
    @SerialName("git_refs_url") val gitRefsUrl: String,
    @SerialName("git_tags_url") val gitTagsUrl: String,
    @SerialName("hooks_url") val hooksUrl: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("id") val id: Long,
    @SerialName("node_id") val nodeId: String,
    @SerialName("issue_comment_url") val issueCommentUrl: String,
    @SerialName("issue_events_url") val issueEventsUrl: String,
    @SerialName("issues_url") val issuesUrl: String,
    @SerialName("keys_url") val keysUrl: String,
    @SerialName("languages_url") val languagesUrl: String,
    @SerialName("merges_url") val mergesUrl: String,
    @SerialName("milestones_url") val milestonesUrl: String,
    @SerialName("name") val name: String,
    @SerialName("notifications_url") val notificationsUrl: String,
    @SerialName("private") val private: Boolean,
    @SerialName("pulls_url") val pullsUrl: String,
    @SerialName("releases_url") val releasesUrl: String,
    @SerialName("stargazers_url") val stargazersUrl: String,
    @SerialName("stargazers_count") val stargazersCount: Int,
    @SerialName("statuses_url") val statusesUrl: String,
    @SerialName("subscribers_url") val subscribersUrl: String,
    @SerialName("subscription_url") val subscriptionUrl: String,
    @SerialName("tags_url") val tagsUrl: String,
    @SerialName("teams_url") val teamsUrl: String,
    @SerialName("trees_url") val treesUrl: String,
    @SerialName("url") val url: String,
)

