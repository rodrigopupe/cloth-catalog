package com.rmp.clothcatalog.data.mapper

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
        rating = this.rating.rate
    )
}
