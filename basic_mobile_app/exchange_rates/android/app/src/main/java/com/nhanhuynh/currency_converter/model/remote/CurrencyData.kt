package com.nhanhuynh.currency_converter.model.remote

data class CurrencyData(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)