package com.rodrigomadeiro.bootstrap.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MiscModule {

    @Provides
    fun provideGson(): Gson{
        val result = Gson()

        return result
    }
}