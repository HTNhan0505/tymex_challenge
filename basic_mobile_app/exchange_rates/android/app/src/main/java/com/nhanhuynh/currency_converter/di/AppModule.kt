package com.nhanhuynh.currency_converter.di

import android.app.Application
import androidx.room.Room
import com.nhanhuynh.currency_converter.model.local.CurrencyRateDatabase
import com.nhanhuynh.currency_converter.network.CurrencyApi
import com.nhanhuynh.currency_converter.repository.CurrencyRepository
import com.nhanhuynh.currency_converter.repository.ICurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCurrencyApi(): CurrencyApi {

        val retrofit = Retrofit
            .Builder()
            .baseUrl(CurrencyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(CurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): CurrencyRateDatabase {
        return Room
            .databaseBuilder(
                application,
                CurrencyRateDatabase::class.java,
                "currency_db"
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: CurrencyApi,
        db: CurrencyRateDatabase
    ): ICurrencyRepository {
        return CurrencyRepository(
            api = api,
            dao = db.currencyRateDao
        )
    }

}