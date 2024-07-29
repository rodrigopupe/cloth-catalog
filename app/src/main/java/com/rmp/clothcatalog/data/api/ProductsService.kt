package com.rmp.clothcatalog.data.api

import com.rmp.clothcatalog.data.model.ProductResponseModel
import retrofit2.http.GET

interface ProductsService {
    @GET("/products")
    suspend fun getProductsList() : List<ProductResponseModel>
}