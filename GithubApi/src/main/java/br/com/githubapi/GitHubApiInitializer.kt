package br.com.githubapi

import br.com.githubapi.client.GithubClient
import br.com.githubapi.di.RepositoryModule
import br.com.githubapi.di.ApiModule
import br.com.githubapi.di.components.DaggerGithubApiComponent
import br.com.githubapi.di.components.GithubApiComponent


//TODO: Add OAuth authentication to the Github API
object GitHubApiInitializer {
    private lateinit var component: GithubApiComponent

    fun initialize() {
        component = DaggerGithubApiComponent.builder()
            .apiModule(ApiModule())
            .repositoryModule(RepositoryModule())
            .build()
    }

    val githubClient: GithubClient
        get() = component.getGithubClient()
}