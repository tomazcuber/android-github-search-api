package br.com.githubsearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.githubsearch.data.dao.RepositoryDao
import br.com.githubsearch.data.dao.UserDao
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.model.entity.RepositoryTag
import br.com.githubsearch.data.model.entity.User

@Database(
    entities = [User::class,
        Repository::class,
        RepositoryTag::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun repositoryDao(): RepositoryDao
}