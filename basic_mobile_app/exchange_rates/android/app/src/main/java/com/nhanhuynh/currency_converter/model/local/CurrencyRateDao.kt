package com.nhanhuynh.currency_converter.model.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CurrencyRateDao {

    @Upsert
    suspend fun upsertAll(currencyRates: List<CurrencyRatesLocal>)

    @Query("SELECT * FROM currencyRatesLocal")
    suspend fun getAllCurrencyRates(): List<CurrencyRatesLocal>
}