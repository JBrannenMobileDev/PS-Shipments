package com.cryptobytes.ps_shipments.di.modules

import com.cryptobytes.ps_shipments.data.dataSource.OffersDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {
    @Provides
    fun provideOfferDataSource() : OffersDataSource {
        return OffersDataSource()
    }
}