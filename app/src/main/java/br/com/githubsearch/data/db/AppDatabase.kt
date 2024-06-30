package br.com.githubsearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.githubsearch.data.dao.UserDao
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.model.entity.User

@Database(entities = [User::class,
                     Repository::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}