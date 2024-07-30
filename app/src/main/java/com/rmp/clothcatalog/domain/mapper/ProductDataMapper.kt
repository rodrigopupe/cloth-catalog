package com.rmp.clothcatalog.domain.mapper

import com.rmp.clothcatalog.data.model.ProductResponseModel
import com.rmp.clothcatalog.view.model.ProductUIModel

class ProductDataMapper() {
    fun fromRemote(data: ProductResponseModel): ProductUIModel {
        return ProductUIModel(
            id = data.id,
            title = data.title,
            price = data.price,
            description = data.description,
            category = data.category,
            imageUrl = data.image,
            rating = data.rating.rate
        )
    }
}
