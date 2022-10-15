package com.essid.orangebanque.di

import com.essid.data.dataSource.remote.RepoEndPoint
import com.essid.data.dataSource.remote.ReposApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ReposApiModule {

    @Provides
    fun provideReposApi(repoEndPoint: RepoEndPoint): ReposApi {
        return ReposApi(repoEndPoint)
    }
}

