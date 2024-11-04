package com.nhanhuynh.currency_converter.repository

import com.nhanhuynh.currency_converter.model.local.CurrencyRateDao
import com.nhanhuynh.currency_converter.model.local.toCurrencyRate
import com.nhanhuynh.currency_converter.model.local.toCurrencyRateEntity
import com.nhanhuynh.currency_converter.network.CurrencyApi
import com.nhanhuynh.currency_converter.remote.CurrencyRate
import com.nhanhuynh.currency_converter.remote.toCurrencyRates
import com.nhanhuynh.currency_converter.utils.Status
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class CurrencyRepository(
    private val api: CurrencyApi,
    private val dao: CurrencyRateDao
):ICurrencyRepository {

    override fun getCurrencyRatesList(): Flow<Status<List<CurrencyRate>>> = flow {
        val localCurrencyRates = getLocalCurrencyRates()

        emit(Status.Success(localCurrencyRates))

        try {
            val newRates = getRemoteCurrencyRates()

            updateLocalCurrencyRates(newRates)
            emit(Status.Success(newRates))

        } catch (e: IOException) {
            emit(
                Status.Error(
                    message = "Couldn't reach server, check your internet connection",
                    data = localCurrencyRates
                )
            )
        } catch (e: Exception) {
            println("------------ ${e.message}")
            emit(
                Status.Error(
                    message = "Oops, something went wrong! ${e.message}",
                    data = localCurrencyRates
                )
            )
        }
    }



//    Get local currency rate
    private suspend fun getLocalCurrencyRates(): List<CurrencyRate> {
        return dao.getAllCurrencyRates().map { it.toCurrencyRate() }
    }

//    Get remote currency rate

    private suspend fun getRemoteCurrencyRates(): List<CurrencyRate> {
        val response = api.getLatestRates()

        return response.toCurrencyRates()
    }

//    Update to database
    private suspend fun updateLocalCurrencyRates(currencyRates: List<CurrencyRate>) {
        dao.upsertAll(currencyRates.map { it.toCurrencyRateEntity() })
    }
}