package com.nhanhuynh.currency_converter.utils

sealed class Status<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T? = null) : Status<T>(data)
    class Error<T>(message: String, data: T? = null) : Status<T>(data, message)
}