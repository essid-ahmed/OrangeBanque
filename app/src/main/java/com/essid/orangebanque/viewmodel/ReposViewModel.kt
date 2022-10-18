package com.essid.orangebanque.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essid.domain.dataresult.DataResult
import com.essid.domain.usecases.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(private val useCase: GetReposUseCase) : ViewModel() {


    private val repos = MutableLiveData<DataResult>()

    fun getRepos(): MutableLiveData<DataResult> {
        return repos
    }

    /**
     * Start getting data
     */
    fun fetchRepos() {
        repos.value=DataResult.Loading
        viewModelScope.launch {
            repos.value=useCase.invoke()
        }
    }

}