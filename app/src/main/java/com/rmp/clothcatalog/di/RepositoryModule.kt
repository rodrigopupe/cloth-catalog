package com.rmp.clothcatalog.di

import com.rmp.clothcatalog.data.api.ProductsService
import com.rmp.clothcatalog.data.repository.ProductsRepositoryImpl
import com.rmp.clothcatalog.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductsRepository(service: ProductsService) : ProductsRepository {
        return ProductsRepositoryImpl(service)
    }
}