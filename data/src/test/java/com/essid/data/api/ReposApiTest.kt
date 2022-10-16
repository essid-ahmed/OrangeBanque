package com.essid.data.api


import com.essid.data.dataSource.remote.RepoEndPoint
import com.essid.data.dataSource.remote.ReposApi
import com.essid.data.mockObjects.MockObjects
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ReposApiTest {

    lateinit var reposApi: ReposApi
    lateinit var repoEndPoint: RepoEndPoint

    @Before
    fun setUp()
        {
            repoEndPoint = Mockito.mock(RepoEndPoint::class.java)
        }

    @Test
    fun `Assert the repos returned by the api is the same list returned by Api object`(){
        runBlocking {
            Mockito.`when`(repoEndPoint.getReposList()).thenReturn(MockObjects.fakeReposDtoList())
            reposApi = ReposApi(repoEndPoint)
                val repoResp = reposApi.getReposList()
                assertEquals(repoResp.size, MockObjects.fakeReposDtoList().size)
                assertEquals(repoResp[0].id, MockObjects.fakeReposDtoList()[0].id)
                assertEquals(repoResp[0].fullName, MockObjects.fakeReposDtoList()[0].fullName)
            }
        }
    }

