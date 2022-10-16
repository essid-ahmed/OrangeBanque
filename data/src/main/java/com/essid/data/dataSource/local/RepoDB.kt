package com.essid.data.dataSource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.essid.data.dataSource.local.dao.RepoDao
import com.essid.data.dataSource.local.entities.RepoEntity

@Database(entities = [RepoEntity::class], version = 1)
abstract class RepoDB : RoomDatabase() {
    abstract fun RepoDao(): RepoDao

    companion object {
        @Volatile
        private var instance: RepoDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            RepoDB::class.java, "repos.db"
        )
            .build()

         fun close(){
            instance?.close()
        }
    }


}