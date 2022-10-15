package com.essid.orangebanque.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.essid.domain.dataresult.DataResult
import com.essid.domain.usecases.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(reposUseCase: GetReposUseCase) :ViewModel(){
    private var repos: LiveData<DataResult> = reposUseCase.invoke()

    fun getRepos(): LiveData<DataResult> {
        return repos
    }
}