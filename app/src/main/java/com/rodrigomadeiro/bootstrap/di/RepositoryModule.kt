package com.rodrigomadeiro.bootstrap.di

import com.rodrigomadeiro.bootstrap.data.repository.MtgRepository
import com.rodrigomadeiro.bootstrap.data.repository.MtgRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMtgRepository(impl: MtgRepositoryImpl): MtgRepository {
        return impl
    }
}