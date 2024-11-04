package com.nhanhuynh.currency_converter.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CurrencyRatesLocal::class],
    version = 1
)
abstract class CurrencyRateDatabase : RoomDatabase() {

    abstract val currencyRateDao: CurrencyRateDao
}