package com.essid.domain.dataresult

import com.essid.domain.entities.Repo

sealed class DataResult {
    class Success(val repos: List<Repo>) : DataResult()
    object Loading : DataResult()
    class Failure(val exception: Exception) : DataResult()
}
