package com.essid.data.repositoriesImp

import com.essid.data.dataSource.remote.ReposApi
import com.essid.data.mappers.RepoMapper
import com.essid.domain.entities.Repo
import com.essid.domain.repositories.IReposRepository
import javax.inject.Inject

class ReposRepositoryImp @Inject constructor(
    private val api: ReposApi,
    private val mapper: RepoMapper
) : IReposRepository {
    override suspend fun getReposList(): List<Repo> {
        return api.getReposList().map { mapper.repoDTOtoRep(it) }
    }
}