package com.essid.data.mapper

import com.essid.data.mappers.RepoMapper
import com.essid.data.mockObjects.MockObjects
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RepoMapperUnitTest {
    private lateinit var mapper: RepoMapper

    @Before
    fun setup() {
        mapper = RepoMapper()
    }

    @Test
    fun `RepoDToToRepo mapper should return the right values`() {
        val repoDto = MockObjects.fakeRepoDtoObject()
        val repo = mapper.repoDTOtoRep(repoDto)
        Assert.assertEquals(repoDto.id, repo.id)
    }

    @Test
    fun `RepoToRepoDTO mapper should return the right values`() {
        val repo = MockObjects.fakeRepoObject()
        val repoDto = mapper.repoToRepoEntity(repo)
        Assert.assertEquals(repoDto.id, repo.id)
    }


}