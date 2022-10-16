package com.essid.domain.repositories

import com.essid.domain.entities.Repo

interface IReposRepository {

    suspend fun getReposListFromServer(): List<Repo>

    suspend fun getReposListFromDB(): List<Repo>

    suspend fun saveReposInDB(albums: List<Repo>)
}