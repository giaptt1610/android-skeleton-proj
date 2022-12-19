package com.giaptt1610.skeletonproject.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.giaptt1610.skeletonproject.data.database.AppDatabase
import com.giaptt1610.skeletonproject.data.database.dao.PhotoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        )
            .build()
    }

    @Provides
    fun providePhotoDao(appDatabase: AppDatabase): PhotoDao {
        return appDatabase.getPhotoDao()
    }
}