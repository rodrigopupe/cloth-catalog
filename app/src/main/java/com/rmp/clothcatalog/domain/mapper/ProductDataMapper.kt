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
            rating = ProductRatingMapper().fromRemote(data.rating)
        )
    }
}

class ProductRatingMapper() {
    fun fromRemote(data: ProductResponseModel.Rating): ProductUIModel.Rating {
        return ProductUIModel.Rating(
            rate = data.rate,
            count = data.count
        )
    }
}
