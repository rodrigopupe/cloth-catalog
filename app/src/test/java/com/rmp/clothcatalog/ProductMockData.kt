package com.rmp.clothcatalog

import com.rmp.clothcatalog.view.model.ProductUIModel

class ProductMockData {

    companion object {
        fun getFakeProductList(): List<ProductUIModel> {
            return listOf(
                ProductUIModel(
                    id = 1,
                    title = "Camiseta",
                    price = 139.47F,
                    description = "Esta é uma camiseta",
                    category = "Roupa masculina",
                    imageUrl = "https://www.image.com/photo.png",
                    rating = 4.5F
                )
            )
        }
    }
}