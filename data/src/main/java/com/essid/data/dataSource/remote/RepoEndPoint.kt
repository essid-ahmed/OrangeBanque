package com.essid.data.dataSource.remote

import com.essid.data.dto.RepoDto
import retrofit2.http.GET

interface RepoEndPoint {
    @GET("/orgs/jetbrains/repos?page=1")
    suspend fun getReposList(): List<RepoDto>
}