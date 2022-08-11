package com.rodrigomadeiro.bootstrap.di

import com.google.gson.Gson
import com.rodrigomadeiro.bootstrap.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object{
        const val DI_IDENTIFIER = "com.rodrigomadeiro.bootstrap.di.NetworkModule.DI_IDENTIFIER"
        const val INTERCEPTOR_FULL_LOGGING = "com.rodrigomadeiro.bootstrap.di.NetworkModule.INTERCEPTOR_FULL_LOGGING"
    }

    //region Builders
    @Provides
    @Named(DI_IDENTIFIER)
    @Singleton
    fun provideOkHttpClientBuilder(@Named(INTERCEPTOR_FULL_LOGGING) fullLoggingInterceptor: Interceptor): OkHttpClient.Builder{
        val result = OkHttpClient.Builder()

        result.followRedirects(true)
        result.followSslRedirects(true)
        result.addInterceptor(fullLoggingInterceptor)

        return result
    }

    @Provides
    @Named(DI_IDENTIFIER)
    @Singleton
    fun provideRetrofitBuilder(gson: Gson, @Named(DI_IDENTIFIER) okHttpClientBuilder: OkHttpClient.Builder): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClientBuilder.build())
    //endregion

    //region Misc Interceptors
    @Provides
    @Singleton
    @Named(INTERCEPTOR_FULL_LOGGING)
    fun provideFullLogInterceptor(): Interceptor {

        val result = HttpLoggingInterceptor()

        if(BuildConfig.DEBUG) {
            result.level = HttpLoggingInterceptor.Level.BODY
        }
        else{
            result.level = HttpLoggingInterceptor.Level.NONE
        }

        return result
    }
    //endregion
}