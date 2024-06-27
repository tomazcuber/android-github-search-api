package br.com.githubapi.di

import br.com.githubapi.data.repository.GetUserResponseRepository
import br.com.githubapi.data.repository.GetUserResponseRepositoryImpl
import br.com.githubapi.network.GithubApiHelper
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(gitHubApiHelper: GithubApiHelper): GetUserResponseRepository {
        return GetUserResponseRepositoryImpl(gitHubApiHelper)
    }
}