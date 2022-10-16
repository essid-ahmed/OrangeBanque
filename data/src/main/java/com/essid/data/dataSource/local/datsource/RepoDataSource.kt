package com.essid.data.dataSource.local.datsource

import com.essid.data.dataSource.local.RepoDB
import com.essid.data.dataSource.local.entities.RepoEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RepoDataSource @Inject constructor(@ApplicationContext val context: android.content.Context) {
    private val dataBase = RepoDB.invoke(context)

    fun insertRepo(repoEntity: RepoEntity) {
        return dataBase.RepoDao().insert(repoEntity)
    }

    fun getAllRepos(): List<RepoEntity> {
        return dataBase.RepoDao().getAll()
    }
}