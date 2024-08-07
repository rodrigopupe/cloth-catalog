package com.rmp.clothcatalog.domain.repository

import com.rmp.clothcatalog.view.model.ProductUIModel

interface ProductsRepository {
    suspend fun getProductsList() : List<ProductUIModel>
}