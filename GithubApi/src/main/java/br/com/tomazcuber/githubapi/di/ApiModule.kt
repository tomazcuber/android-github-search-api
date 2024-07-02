package br.com.tomazcuber.githubapi.di

import android.util.Log
import br.com.tomazcuber.githubapi.network.GithubApiHelper
import br.com.tomazcuber.githubapi.service.GithubApiService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApiModule(private val cacheDir: File?) {
    @Provides
    fun provideBaseUrl() = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit {
        val json = Json { ignoreUnknownKeys = true }

        val cacheSize = (5 * 1024 * 1024).toLong()
        val cache = cacheDir?.let { Cache(it, cacheSize) }

        val httpClient = OkHttpClient.Builder()
        httpClient
            .addInterceptor(Interceptor { chain ->
                val request: Request =
                    chain.request().newBuilder()
                        .addHeader("accept", "application/vnd.github+json")
                        .build()
                chain.proceed(request)
            })
            .addInterceptor(HttpLoggingInterceptor { Log.d("GH_API", it) }
                .setLevel(HttpLoggingInterceptor.Level.HEADERS))

        cache?.let {
            val cacheInterceptor = Interceptor { chain ->
                val response: Response = chain.proceed(chain.request())
                val cacheControl = CacheControl.Builder()
                    .maxAge(1, TimeUnit.MINUTES)
                    .build()
                response.newBuilder()
                    .header("Cache-Control", cacheControl.toString())
                    .build()
            }
            httpClient
                .cache(it)
                .addInterceptor(cacheInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(httpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubApiService(retrofit: Retrofit): GithubApiService {
        return retrofit.create(GithubApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubApiHelper(githubApiService: GithubApiService): GithubApiHelper {
        return GithubApiHelper(githubApiService)
    }

}