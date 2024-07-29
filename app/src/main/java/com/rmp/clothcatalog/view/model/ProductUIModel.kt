package com.rmp.clothcatalog.view.model


data class ProductUIModel(
    val id: Long,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val imageUrl: String,
    val rating: Rating
) {
    data class Rating(
        val rate: Float,
        val count: Int
    )
}

