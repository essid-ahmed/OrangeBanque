package com.essid.orangebanque.di


import com.essid.data.dataSource.remote.RepoEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object EndPointModule {

    @Provides
    fun provideRepoEndPoint(retrofit: Retrofit): RepoEndPoint{
        return retrofit.create(RepoEndPoint::class.java)
    }
}