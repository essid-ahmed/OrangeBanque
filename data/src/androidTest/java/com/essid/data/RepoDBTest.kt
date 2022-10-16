package com.essid.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.essid.data.dataSource.local.RepoDB
import com.essid.data.dataSource.local.dao.RepoDao
import com.essid.data.dataSource.local.entities.RepoEntity
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepoDBTest {

    private lateinit var repoDao: RepoDao
    private lateinit var db: RepoDB

    @Before
    fun createDB() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, RepoDB::class.java
        ).build()
        repoDao = db.RepoDao()
    }

    @After
    fun closeDB() {
        RepoDB.close()
    }

    @Test
    fun writeOneRepoAndReadIt() {
        val repoEntity = RepoEntity(1, "name", 0, 1, 2, "description")
        repoDao.insert(repoEntity)

        val savedRepos = repoDao.getAll()

        assertThat(savedRepos[0].id, CoreMatchers.equalTo(1))
        assertThat(savedRepos[0].fullName, CoreMatchers.equalTo("name"))
        assertThat(savedRepos[0].forks, CoreMatchers.equalTo(0))
        assertThat(savedRepos[0].watchers, CoreMatchers.equalTo(1))
        assertThat(savedRepos[0].openIssues, CoreMatchers.equalTo(2))
        assertThat(savedRepos[0].description, CoreMatchers.equalTo("description"))

    }

    @Test
    fun if_db_is_empty_then_return_zero_element() {
        val repoList = repoDao.getAll()
        assertThat(repoList.size, CoreMatchers.equalTo(0))
    }
}