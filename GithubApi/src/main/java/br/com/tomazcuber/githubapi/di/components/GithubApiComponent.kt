package br.com.tomazcuber.githubapi.di.components

import br.com.tomazcuber.githubapi.client.GithubClient
import br.com.tomazcuber.githubapi.data.repository.GetUserResponseRepository
import br.com.tomazcuber.githubapi.di.ApiModule
import br.com.tomazcuber.githubapi.di.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RepositoryModule::class])
interface GithubApiComponent {
    fun getGithubClient(): GithubClient
}