package com.nhanhuynh.currency_converter.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyRatesLocal (
    @PrimaryKey
    val code: String,
    val name: String,
    val rate: Double
)