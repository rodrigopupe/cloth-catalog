package com.rmp.clothcatalog.utils

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

fun Float.toCurrencyFormatted(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale.getDefault()).apply {
        maximumFractionDigits = 2
        currency = Currency.getInstance(Locale.getDefault())
    }
    return formatter.format(this)
}

fun Float.toFormattedRating(): String {
    val formatter = NumberFormat.getIntegerInstance(Locale.getDefault()).apply {
        maximumFractionDigits = 1
    }
    return formatter.format(this)
}