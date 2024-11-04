package com.nhanhuynh.currency_converter.view

import com.nhanhuynh.currency_converter.remote.CurrencyRate

// config initial value on input
data class MainScreenState(
    val fromCurrencyCode: String = "VND",
    val toCurrencyCode: String = "USD",
    val fromCurrencyValue: String = "0.00",
    val toCurrencyValue: String = "0.00",
    val selection: SelectionState = SelectionState.FROM,
    val currencyRates: Map<String, CurrencyRate> = emptyMap(),
    val error: String? = null
)

enum class SelectionState {
    FROM,
    TO
}