package com.example.ecom.data.di

import com.example.ecom.data.repository.ProductRepositoryImpl
import com.example.ecom.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository (
        impl: ProductRepositoryImpl
    ): ProductRepository

}