package com.essid.domain.usecases

import com.essid.domain.dataresult.DataResult
import com.essid.domain.entities.Repo
import com.essid.domain.repositories.IReposRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val repoRepository: IReposRepository) {

    suspend fun invoke(): DataResult {
        return try {
            val repoList = repoRepository.getReposListFromServer()
            if (isNotEmpty(repoList)) {
                insertReposInDB(repoList)
            }
            DataResult.Success(repoList)
        } catch (ex: Exception) {
            val localRepos = getReposListFromDB()

            if (isNotEmpty(localRepos))
                DataResult.Success(localRepos)
            else
                DataResult.Failure(ex)
        }
    }

    /**
     * get all repos from local DB
     */
    private suspend fun getReposListFromDB(): List<Repo> {
      return repoRepository.getReposListFromDB()
    }

    /**
     * Insert into local DB a list of repos
     * @param:repoLis : repos list that will be saved
     **/
    private suspend fun insertReposInDB(reposList: List<Repo>) {
        GlobalScope.launch(Dispatchers.IO) {
            repoRepository.saveReposInDB(reposList)
        }
    }

    /*
     * check if a list is not null or empty
     * @param: list to check
     */
    private fun isNotEmpty(list: List<*>?): Boolean {
        return list != null && list.isNotEmpty()
    }
}