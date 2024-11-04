package com.nhanhuynh.currency_converter.repository

import com.nhanhuynh.currency_converter.remote.CurrencyRate
import com.nhanhuynh.currency_converter.utils.Status
import kotlinx.coroutines.flow.Flow

interface ICurrencyRepository {
    fun getCurrencyRatesList(): Flow<Status<List<CurrencyRate>>>
}