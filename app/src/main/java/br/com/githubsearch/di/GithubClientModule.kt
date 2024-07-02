package br.com.githubsearch.di

import android.content.Context
import br.com.tomazcuber.githubapi.GitHubApiInitializer
import br.com.tomazcuber.githubapi.client.GithubClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GithubClientModule {
    @Provides
    @Singleton
    fun provideGithubClient(@ApplicationContext context: Context) : GithubClient {
        GitHubApiInitializer.initialize(context.cacheDir)
        return GitHubApiInitializer.githubClient
    }
}