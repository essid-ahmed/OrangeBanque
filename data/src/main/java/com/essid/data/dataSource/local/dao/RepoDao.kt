package com.essid.data.dataSource.local.dao

import androidx.room.*
import com.essid.data.dataSource.local.entities.RepoEntity

@Dao
interface RepoDao {
    @Query("SELECT * FROM repoEntity")
    fun getAll(): List<RepoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg repo: RepoEntity)
}