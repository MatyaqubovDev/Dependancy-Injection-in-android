package com.example.androiddi.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitHttp {

    val IS_TESTER = true
    val SERVER_DEVELOPMENT = "https://jsonplaceholder.typicode.com/"
    val SERVER_PRODUCTION = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(server())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun server(): String {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    @Provides
    @Singleton
    fun posterService(): PosterService = retrofitClient().create(PosterService::class.java)
}