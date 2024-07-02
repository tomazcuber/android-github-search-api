package br.com.tomazcuber.githubapi

import br.com.tomazcuber.githubapi.client.GithubClient
import br.com.tomazcuber.githubapi.di.RepositoryModule
import br.com.tomazcuber.githubapi.di.ApiModule
import br.com.tomazcuber.githubapi.di.components.DaggerGithubApiComponent
import br.com.tomazcuber.githubapi.di.components.GithubApiComponent
import java.io.File


//TODO: Add OAuth authentication to the Github API
object GitHubApiInitializer {
    private lateinit var component: GithubApiComponent

    /**
     * Initializes the GitHub API component.
     *
     * This function is responsible for setting up the Dagger component that provides
     * the dependencies for the GitHub API. It uses the builder pattern to create a
     * new instance of the DaggerGithubApiComponent, and assigns it to the component
     * property of the GitHubApiInitializer object.
     *
     * @param cacheDir Optional parameter that represents the directory for caching data.
     * If no value is provided, the cache directory will be null.
     */
    fun initialize(cacheDir: File? = null) {
        component = DaggerGithubApiComponent.builder()
            .apiModule(ApiModule(cacheDir))
            .repositoryModule(RepositoryModule())
            .build()
    }

    /**
     * A read-only property that provides an instance of GithubClient.
     *
     * This property is the main entry-point of the library. It uses the Dagger component
     * to retrieve an instance of GithubClient. The instance is retrieved by calling the
     * getGithubClient() method on the component. The retrieved instance is then returned
     * as the value of this property.
     *
     * @return An instance of GithubClient.
     */
    val githubClient: GithubClient
        get() = component.getGithubClient()
}