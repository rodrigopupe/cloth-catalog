package com.rmp.clothcatalog.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rmp.clothcatalog.R
import com.rmp.clothcatalog.data.repository.contracts.ProductsRepository
import com.rmp.clothcatalog.utils.BaseState
import com.rmp.clothcatalog.view.model.ProductUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogListViewModel @Inject constructor(
    private val app: Application,
    private val productsRepository: ProductsRepository
) : AndroidViewModel(app) {

    private val _productsResponse = MutableLiveData<BaseState<List<ProductUIModel>>>()
    val productsResponse: LiveData<BaseState<List<ProductUIModel>>>
        get() = _productsResponse

    fun getProductsList() {
        viewModelScope.launch {
            _productsResponse.value = BaseState.Loading

            delay(2000) // Pra que o Loading fique um tempo na tela rs

            try {
                val data = productsRepository.getProductsList()
                _productsResponse.value = BaseState.Success(data)
            } catch (e: Exception) {
                val message = app.resources.getString(R.string.product_list_response_error)
                _productsResponse.value = BaseState.Error(message)
            }
        }
    }
}