package com.rmp.clothcatalog.view

import androidx.lifecycle.ViewModel
import com.rmp.clothcatalog.data.repository.contracts.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogListViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {
}