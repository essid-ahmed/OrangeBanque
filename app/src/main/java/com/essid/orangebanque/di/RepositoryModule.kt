package com.essid.orangebanque.di

import com.essid.data.repositoriesImp.ReposRepositoryImp
import com.essid.domain.repositories.IReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindReposRepository(reposRepositoryImp: ReposRepositoryImp): IReposRepository
}
