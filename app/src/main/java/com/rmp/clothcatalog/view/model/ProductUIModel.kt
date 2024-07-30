package com.rmp.clothcatalog.view.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductUIModel(
    val id: Long,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val imageUrl: String,
    val rating: Float
) : Parcelable