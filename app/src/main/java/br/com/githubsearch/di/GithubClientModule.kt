package br.com.githubsearch.di

import br.com.githubapi.GitHubApiInitializer
import br.com.githubapi.client.GithubClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GithubClientModule {
    @Provides
    @Singleton
    fun provideGithubClient() : GithubClient {
        GitHubApiInitializer.initialize()
        return GitHubApiInitializer.githubClient
    }
}