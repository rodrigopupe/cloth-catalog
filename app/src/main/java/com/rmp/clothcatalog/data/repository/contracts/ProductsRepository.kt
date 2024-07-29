package com.rmp.clothcatalog.data.repository.contracts

import com.rmp.clothcatalog.view.model.ProductUIModel

interface ProductsRepository {
    suspend fun getProductsList() : List<ProductUIModel>
}