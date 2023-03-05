package com.cryptobytes.ps_shipments.di.modules

import android.content.Context
import androidx.room.Room
import com.cryptobytes.ps_shipments.data.db.AppDatabase
import com.cryptobytes.ps_shipments.data.db.dao.AssignmentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideAssignmentDao(database: AppDatabase): AssignmentDao {
        return database.assignmentDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "main.db"
        ).build()
    }
}