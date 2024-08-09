package com.rmp.clothcatalog.data.repository

import com.rmp.clothcatalog.data.api.ProductsService
import com.rmp.clothcatalog.domain.repository.ProductsRepository
import com.rmp.clothcatalog.view.model.ProductUIModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ProductsRepositoryImplTest {

    private val service: ProductsService = mockk()

    private val repository: ProductsRepository = ProductsRepositoryImpl(service)

    @Test
    fun `When fetching Products successfully, Products list are received`() = runTest {
        coEvery { service.getProductsList() } returns listOf()

        val list = repository.getProductsList()

        assert(list is List<ProductUIModel>)
    }

    // TODO No futuro, adicionar mais testes se a complexidade da busca e/ou tratamento dos produtos aumentar
}