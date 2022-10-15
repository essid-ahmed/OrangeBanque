package com.essid.domain.repositories

import com.essid.domain.entities.Repo

interface IReposRepository {
    suspend fun getReposList(): List<Repo>
}