package com.rmp.clothcatalog.utils

sealed class BaseState<out T> {
    data object Loading : BaseState<Nothing>()
    data class Success<out T>(val data: T) : BaseState<T>()
    data class Error(val errorMessage: String) : BaseState<Nothing>()
}