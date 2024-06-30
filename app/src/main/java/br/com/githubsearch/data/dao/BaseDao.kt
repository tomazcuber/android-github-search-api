package br.com.githubsearch.data.dao

import androidx.room.Delete
import androidx.room.Upsert

interface BaseDao<T> {
    @Upsert
    fun upsert(vararg obj: T)

    @Delete
    fun delete(vararg obj: T)
}