package com.rodrigomadeiro.bootstrap.di

import com.rodrigomadeiro.bootstrap.BuildConfig
import com.rodrigomadeiro.bootstrap.data.retrofit.MockyIoMtgRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MockyIoNetworkModule {

    companion object{
        const val DI_IDENTIFIER = "com.rodrigomadeiro.bootstrap.di.MockyIoNetworkModule.DI_IDENTIFIER"
    }

    @Provides
    @Singleton
    @Named(DI_IDENTIFIER)
    fun provideRetrofit(@Named(NetworkModule.DI_IDENTIFIER) builder: Retrofit.Builder): Retrofit{
        val result = builder.apply {
            baseUrl(BuildConfig.mockyIoUrl)
        }.build()

        return result
    }

    @Provides
    @Singleton
    fun provideMockyIoMtgRetrofitService(@Named(DI_IDENTIFIER)retrofit: Retrofit): MockyIoMtgRetrofitService {
        return retrofit.create(MockyIoMtgRetrofitService::class.java)
    }
}