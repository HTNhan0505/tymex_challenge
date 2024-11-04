package com.nhanhuynh.currency_converter.network

import com.nhanhuynh.currency_converter.model.remote.CurrencyData
import retrofit2.http.GET
import retrofit2.http.Query

// Define and config api network
interface CurrencyApi {

    @GET("latest")
    suspend fun getLatestRates(
        @Query("access_key") access_key: String = API_KEY
    ): CurrencyData

    companion object {
        const val API_KEY = "8fb28efa84496d1851d1ae5586176d2c"
        const val BASE_URL = "https://api.exchangeratesapi.io/"


    }

}