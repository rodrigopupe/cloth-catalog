package com.rmp.clothcatalog.data.repository

import com.rmp.clothcatalog.data.api.ProductsService
import com.rmp.clothcatalog.data.mapper.toUiModel
import com.rmp.clothcatalog.domain.repository.ProductsRepository
import com.rmp.clothcatalog.view.model.ProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val service: ProductsService
) : ProductsRepository {

    override suspend fun getProductsList(): List<ProductUIModel> {
        return withContext(Dispatchers.IO) {
            val productList = service.getProductsList()

            productList.map { product -> product.toUiModel() }
        }
    }
}