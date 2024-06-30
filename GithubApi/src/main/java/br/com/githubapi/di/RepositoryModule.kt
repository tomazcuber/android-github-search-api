package br.com.githubapi.di

import br.com.githubapi.data.repository.GetUserResponseRepository
import br.com.githubapi.data.repository.GetUserResponseRepositoryImpl
import br.com.githubapi.data.repository.UserReposResponseRepository
import br.com.githubapi.data.repository.UserReposResponseRepositoryImpl
import br.com.githubapi.network.GithubApiHelper
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
    @Provides
    @Singleton
    fun provideUserReposRepository(gitHubApiHelper: GithubApiHelper): UserReposResponseRepository {
        return UserReposResponseRepositoryImpl(gitHubApiHelper)
    }
}