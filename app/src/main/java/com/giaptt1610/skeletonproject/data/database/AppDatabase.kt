package com.giaptt1610.skeletonproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.giaptt1610.skeletonproject.data.database.dao.PhotoDao
import com.giaptt1610.skeletonproject.data.database.entities.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPhotoDao(): PhotoDao
}