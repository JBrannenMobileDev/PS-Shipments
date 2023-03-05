package com.cryptobytes.ps_shipments.di.modules

import com.cryptobytes.ps_shipments.data.dataSource.OffersDataSource
import com.cryptobytes.ps_shipments.data.db.dao.AssignmentDao
import com.cryptobytes.ps_shipments.data.repository.AssignmentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun provideAssignmentRepository(assignmentDao: AssignmentDao, offersDataSource: OffersDataSource): AssignmentRepository {
        return AssignmentRepository(assignmentDao, offersDataSource)
    }
}