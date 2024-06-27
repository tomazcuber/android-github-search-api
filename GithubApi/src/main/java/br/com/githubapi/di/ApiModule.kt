package br.com.githubapi.di

import br.com.githubapi.network.GithubApiHelper
import br.com.githubapi.service.GithubApiService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.kotlinx.serialization.asConverterFactory


@Module
class ApiModule {
    @Provides
    fun provideBaseUrl() = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubApiService(retrofit: Retrofit): GithubApiService {
        return retrofit.create(GithubApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubApiHelper(githubApiService: GithubApiService): GithubApiHelper{
        return GithubApiHelper(githubApiService)
    }

}