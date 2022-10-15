package com.essid.data.dataSource.remote

import com.essid.data.dto.RepoDto
import javax.inject.Inject

class ReposApi @Inject constructor(private val endPoint: RepoEndPoint) {

    suspend fun getReposList(): List<RepoDto> {
        return endPoint.getReposList()
    }
}