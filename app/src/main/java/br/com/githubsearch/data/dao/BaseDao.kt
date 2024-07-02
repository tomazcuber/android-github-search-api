package br.com.githubsearch.data.dao

import androidx.room.Delete
import androidx.room.Upsert

interface BaseDao<T> {
    @Upsert()
    suspend fun upsert(vararg obj: T)

    @Upsert
    suspend fun upsert(obj: List<T>)

    @Delete
    suspend fun delete(vararg obj: T)
}