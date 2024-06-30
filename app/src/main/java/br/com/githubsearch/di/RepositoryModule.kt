package br.com.githubsearch.di

import br.com.githubapi.client.GithubClient
import br.com.githubsearch.data.db.AppDatabase
import br.com.githubsearch.data.repository.ReposRepository
import br.com.githubsearch.data.repository.UsersRepository
import br.com.githubsearch.data.sources.RepositoriesLocalDataSource
import br.com.githubsearch.data.sources.RepositoriesRemoteDataSource
import br.com.githubsearch.data.sources.UsersLocalDataSource
import br.com.githubsearch.data.sources.UsersRemoteDataSource
import br.com.githubsearch.di.DatabaseModule_ProvideAppDatabaseFactory.provideAppDatabase
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
}