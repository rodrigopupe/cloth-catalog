package com.rmp.clothcatalog.data.repository

import com.rmp.clothcatalog.data.api.ProductsService
import com.rmp.clothcatalog.data.repository.contracts.ProductsRepository
import com.rmp.clothcatalog.parser.toUiModel
import com.rmp.clothcatalog.view.model.ProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val service: ProductsService
) : ProductsRepository {

    override suspend fun getProductsList(): List<ProductUIModel> {
        val result = withContext(Dispatchers.IO) {
            service.getProductsList()
        }

        return result.map { it.toUiModel() }
    }
}