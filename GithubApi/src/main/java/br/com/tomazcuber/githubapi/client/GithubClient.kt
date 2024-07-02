package br.com.tomazcuber.githubapi.client

import br.com.tomazcuber.githubapi.data.model.GetUserResponse
import br.com.tomazcuber.githubapi.data.model.RepositoryResponse
import br.com.tomazcuber.githubapi.data.model.RepositoryTagsResponse
import br.com.tomazcuber.githubapi.data.repository.GetUserResponseRepository
import br.com.tomazcuber.githubapi.data.repository.RepositoryTagsResponseRepository
import br.com.tomazcuber.githubapi.data.repository.UserReposResponseRepository
import br.com.tomazcuber.githubapi.network.NetworkResult
import br.com.tomazcuber.githubapi.util.Sort
import javax.inject.Inject

class GithubClient @Inject constructor(
    private val getUserResponseRepository: GetUserResponseRepository,
    private val listUserReposResponseRepository: UserReposResponseRepository,
    private val repositoryTagsResponseRepository: RepositoryTagsResponseRepository
) {
    /**
     * Searches for a user on GitHub.
     *
     * This function uses the getUserResponseRepository to search for a user on GitHub.
     * It takes a username as a parameter and returns a NetworkResult object that contains
     * the GetUserResponse data for the searched user.
     *
     * @param username The username of the user to search for on GitHub.
     * @return A NetworkResult object containing the GetUserResponse data for the searched user.
     */
    suspend fun searchUser(username: String): NetworkResult<GetUserResponse> {
        return getUserResponseRepository.searchUser(username)
    }

    /**
     * Searches for a user's repositories on GitHub.
     *
     * This function uses the listUserReposResponseRepository to search for a user's repositories on GitHub.
     * It takes a username, page number, number of items per page, and sorting order as parameters and returns a NetworkResult object that contains
     * a list of RepositoryResponse data for the searched user's repositories.
     *
     * @param username The username of the user whose repositories to search for on GitHub.
     * @param page The page number for the search results. If no value is provided, the default is null.
     * @param perPage The number of items per page for the search results. If no value is provided, the default is null.
     * @param sort The sorting order for the search results. If no value is provided, the default is null.
     * @return A NetworkResult object containing a list of RepositoryResponse data for the searched user's repositories.
     */
    suspend fun searchUserRepositories(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        sort: Sort? = null,
    ): NetworkResult<List<RepositoryResponse>> {
        return listUserReposResponseRepository.listUsersRepositories(
            username,
            page,
            perPage,
            sort?.property,
            sort?.direction
        )
    }

    /**
     * Lists the tags of a repository on GitHub.
     *
     * This function uses the repositoryTagsResponseRepository to list the tags of a repository on GitHub.
     * It takes a username, repository name, page number, and number of items per page as parameters and returns a NetworkResult object that contains
     * a list of RepositoryTagsResponse data for the listed repository tags.
     *
     * @param username The username of the user who owns the repository on GitHub.
     * @param repository The name of the repository whose tags to list.
     * @param page The page number for the list results. If no value is provided, the default is null.
     * @param perPage The number of items per page for the list results. If no value is provided, the default is null.
     * @return A NetworkResult object containing a list of RepositoryTagsResponse data for the listed repository tags.
     */
    suspend fun listRepositoryTags(
        username: String,
        repository: String,
        page: Int? = null,
        perPage: Int? = null
    ): NetworkResult<List<RepositoryTagsResponse>> {
        return repositoryTagsResponseRepository.listRepositoryTags(
            username,
            repository,
            page,
            perPage
        )
    }
}