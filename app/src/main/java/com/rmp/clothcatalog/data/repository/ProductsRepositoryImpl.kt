package com.rmp.clothcatalog.data.repository

import com.rmp.clothcatalog.data.api.ProductsService
import com.rmp.clothcatalog.data.model.ProductResponseModel
import com.rmp.clothcatalog.data.repository.contracts.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    val service: ProductsService
) : ProductsRepository {

    override suspend fun getProductsList(): List<ProductResponseModel> {
        TODO("Not yet implemented")
    }
}