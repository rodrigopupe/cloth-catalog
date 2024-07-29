package com.rmp.clothcatalog.data.repository.contracts

import com.rmp.clothcatalog.data.model.ProductResponseModel

interface ProductsRepository {
    suspend fun getProductsList() : List<ProductResponseModel>
}