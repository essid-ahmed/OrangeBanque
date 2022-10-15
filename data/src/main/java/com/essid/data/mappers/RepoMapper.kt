package com.essid.data.mappers

import com.essid.data.dto.RepoDto
import com.essid.domain.entities.Repo
import javax.inject.Inject

class RepoMapper @Inject constructor(){
    fun repoDTOtoRep(repoDto: RepoDto): Repo {
        return Repo(
            fullName = repoDto.fullName,
            forks = repoDto.forks,
            openIssues= repoDto.openIssues,
            watchers = repoDto.watchers,
            description = repoDto.description
        )
    }
}