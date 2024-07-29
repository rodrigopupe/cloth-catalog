package com.rmp.clothcatalog.parser

import com.rmp.clothcatalog.data.model.ProductResponseModel
import com.rmp.clothcatalog.view.model.ProductUIModel

fun ProductResponseModel.toUiModel(): ProductUIModel {
    return ProductUIModel(
        id = this.id,
        title = this.title,
        price = this.price,
        description = this.description,
        category = this.category,
        imageUrl = this.image,
        rating = this.rating.toUiModel()
    )
}

fun ProductResponseModel.Rating.toUiModel(): ProductUIModel.Rating {
    return ProductUIModel.Rating(
        rate = this.rate,
        count = this.count
    )
}