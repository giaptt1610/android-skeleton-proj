package com.giaptt1610.skeletonproject.di

import com.giaptt1610.skeletonproject.BuildConfig
import com.giaptt1610.skeletonproject.data.apis.GitHubApi
import com.giaptt1610.skeletonproject.data.apis.PhotoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @Named("PhotoApi")
    fun provideRetrofitPhoto(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.PHOTO_API_BASE_URL)
            .build()
    }

    @Provides
    fun providePhotoApi(@Named("PhotoApi") retrofit: Retrofit): PhotoApi {
        return retrofit.create(PhotoApi::class.java)
    }

    @Provides
    @Singleton
    @Named("GitHubApi")
    fun provideRetrofitGithub(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.GITHUB_API_BASE_URL)
            .build()
    }

    @Provides
    fun provideGithubApi(@Named("GitHubApi") retrofit: Retrofit): GitHubApi {
        return retrofit.create(GitHubApi::class.java)
    }
}