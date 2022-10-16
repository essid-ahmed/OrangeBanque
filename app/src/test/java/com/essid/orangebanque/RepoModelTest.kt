package com.essid.orangebanque

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.essid.domain.dataresult.DataResult
import com.essid.domain.entities.Repo
import com.essid.domain.usecases.GetReposUseCase
import com.essid.orangebanque.viewmodel.ReposViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.HttpException
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RepoModelTest :  CoroutineDispatcher(){
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @Mock
    lateinit var useCase:GetReposUseCase
    private lateinit var reposViewModel:ReposViewModel
    @Mock
    private lateinit var reposObserver: Observer<in DataResult>

    @Before
    fun setUp(){
        reposViewModel = ReposViewModel(useCase)
    }
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when fetching results ok then return a list successfully`(){
        val emptyList = arrayListOf<Repo>()
          reposViewModel.getRepos().observeForever(reposObserver)
            runBlocking {
            Mockito.`when`(useCase.invoke()).thenAnswer {
                DataResult.Success(emptyList)
            }
            reposViewModel.fetchRepos()
            assertNotNull(reposViewModel.getRepos().value)

            assertEquals(0, (reposViewModel.getRepos().value as DataResult.Success).repos.size)
        }
    }

    @Test
    fun `when calling for results then return loading`() {
            runBlocking {
            reposViewModel.getRepos().observeForever(reposObserver)
            reposViewModel.fetchRepos()
            Mockito.verify(reposObserver).onChanged(DataResult.Loading)
        }
    }

    @Test
    fun `when fetching results fails then return an error`() {
        val exception = Mockito.mock(HttpException::class.java)
            runBlocking {
            reposViewModel.getRepos().observeForever(reposObserver)
            Mockito.`when`(
                useCase.invoke()
            ).thenAnswer {
               DataResult.Failure(UnknownHostException())
            }
            reposViewModel.fetchRepos()
            assertNotNull(reposViewModel.getRepos().value)
        }
    }

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        block.run()
    }
}