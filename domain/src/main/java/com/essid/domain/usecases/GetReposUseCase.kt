package com.essid.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.essid.domain.dataresult.DataResult
import com.essid.domain.repositories.IReposRepository
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val repoRepository: IReposRepository){

    fun invoke(): LiveData<DataResult> = liveData {
        emit(DataResult.Loading())

        try {
            emit(DataResult.Success(repoRepository.getReposList()))
        } catch (ex: Exception) {
            emit(DataResult.Failure(ex))
        }
    }
}