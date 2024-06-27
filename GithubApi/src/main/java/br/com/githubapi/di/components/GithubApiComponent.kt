package br.com.githubapi.di.components

import br.com.githubapi.client.GithubClient
import br.com.githubapi.data.repository.GetUserResponseRepository
import br.com.githubapi.di.ApiModule
import br.com.githubapi.di.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RepositoryModule::class])
interface GithubApiComponent {
    fun getGithubClient(): GithubClient
}