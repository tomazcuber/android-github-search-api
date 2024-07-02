package br.com.tomazcuber.githubapi.di

import br.com.tomazcuber.githubapi.data.repository.GetUserResponseRepository
import br.com.tomazcuber.githubapi.data.repository.GetUserResponseRepositoryImpl
import br.com.tomazcuber.githubapi.data.repository.RepositoryTagsResponseRepository
import br.com.tomazcuber.githubapi.data.repository.RepositoryTagsResponseRepositoryImpl
import br.com.tomazcuber.githubapi.data.repository.UserReposResponseRepository
import br.com.tomazcuber.githubapi.data.repository.UserReposResponseRepositoryImpl
import br.com.tomazcuber.githubapi.network.GithubApiHelper
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

    @Provides
    @Singleton
    fun provideRepositoryTagsRepository(gitHubApiHelper: GithubApiHelper) : RepositoryTagsResponseRepository {
        return RepositoryTagsResponseRepositoryImpl(gitHubApiHelper)
    }
}