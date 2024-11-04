package com.nhanhuynh.currency_converter.model.local

import com.nhanhuynh.currency_converter.remote.CurrencyRate

fun CurrencyRatesLocal.toCurrencyRate(): CurrencyRate {
    return CurrencyRate(
        code = code,
        name = name,
        rate = rate
    )
}

fun CurrencyRate.toCurrencyRateEntity(): CurrencyRatesLocal {
    return CurrencyRatesLocal(
        code = code,
        name = name,
        rate = rate
    )
}