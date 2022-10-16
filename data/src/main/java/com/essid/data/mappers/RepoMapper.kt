package com.essid.data.mappers

import com.essid.data.dataSource.local.entities.RepoEntity
import com.essid.data.dto.RepoDto
import com.essid.domain.entities.Repo
import javax.inject.Inject

class RepoMapper @Inject constructor(){
    fun repoDTOtoRep(repoDto: RepoDto): Repo {
        return Repo(
            id = repoDto.id,
            fullName = repoDto.fullName,
            forks = repoDto.forks,
            openIssues= repoDto.openIssues,
            watchers = repoDto.watchers,
            description = repoDto.description
        )
    }
    fun repoEntityToRep(repoEntity: RepoEntity): Repo{
        return Repo(
            id = repoEntity.id,
            fullName = repoEntity.fullName,
            forks = repoEntity.forks,
            openIssues= repoEntity.openIssues,
            watchers = repoEntity.watchers,
            description = repoEntity.description
        )
    }
    fun repoToRepoEntity(repo :Repo) : RepoEntity{
        return RepoEntity(
            id = repo.id,
            fullName = repo.fullName,
            forks = repo.forks,
            openIssues= repo.openIssues,
            watchers = repo.watchers,
            description = repo.description
        )
    }
}