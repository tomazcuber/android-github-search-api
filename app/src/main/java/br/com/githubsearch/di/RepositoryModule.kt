package br.com.githubsearch.di

import br.com.tomazcuber.githubapi.client.GithubClient
import br.com.githubsearch.data.db.AppDatabase
import br.com.githubsearch.data.repository.ReposRepository
import br.com.githubsearch.data.repository.TagsRepository
import br.com.githubsearch.data.repository.UsersRepository
import br.com.githubsearch.data.sources.repositories.RepositoriesLocalDataSource
import br.com.githubsearch.data.sources.repositories.RepositoriesRemoteDataSource
import br.com.githubsearch.data.sources.tags.RepositoryTagsLocalDataSource
import br.com.githubsearch.data.sources.tags.RepositoryTagsRemoteDataSource
import br.com.githubsearch.data.sources.users.UsersLocalDataSource
import br.com.githubsearch.data.sources.users.UsersRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUsersRepository(appDatabase: AppDatabase, githubClient: GithubClient) : UsersRepository{
        return UsersRepository(UsersLocalDataSource(appDatabase), UsersRemoteDataSource(githubClient))
    }
    @Provides
    @Singleton
    fun provideReposRepository(appDatabase: AppDatabase, githubClient: GithubClient) : ReposRepository {
        return ReposRepository(RepositoriesLocalDataSource(appDatabase), RepositoriesRemoteDataSource(githubClient))
    }
    @Provides
    @Singleton
    fun provideTagsRepository(appDatabase: AppDatabase, githubClient: GithubClient) : TagsRepository {
        return TagsRepository(RepositoryTagsLocalDataSource(appDatabase), RepositoryTagsRemoteDataSource(githubClient))
    }
}