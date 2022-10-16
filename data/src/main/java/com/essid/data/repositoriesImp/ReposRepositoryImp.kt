package com.essid.data.repositoriesImp

import com.essid.data.dataSource.local.datsource.RepoDataSource
import com.essid.data.dataSource.remote.ReposApi
import com.essid.data.mappers.RepoMapper
import com.essid.domain.entities.Repo
import com.essid.domain.repositories.IReposRepository
import javax.inject.Inject

class ReposRepositoryImp @Inject constructor(
    private val api: ReposApi,
    private val dataSource: RepoDataSource,
    private val mapper: RepoMapper
) : IReposRepository {
    override suspend fun getReposListFromServer(): List<Repo> {
        return api.getReposList().map { mapper.repoDTOtoRep(it) }
    }

    override suspend fun getReposListFromDB(): List<Repo> {
        return dataSource.getAllRepos().map { mapper.repoEntityToRep(it) }
    }

    override suspend fun saveReposInDB(repos: List<Repo>) {
        for (repo in repos) {
            dataSource.insertRepo(mapper.repoToRepoEntity(repo))
        }
    }
}