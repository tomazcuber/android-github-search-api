package br.com.githubsearch.di

import br.com.githubsearch.data.db.AppDatabase
import br.com.githubsearch.data.repository.UsersRepository
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
    fun provideUsersRepository(appDatabase: AppDatabase) : UsersRepository{
        return UsersRepository(UsersLocalDataSource(appDatabase), UsersRemoteDataSource())
    }
}