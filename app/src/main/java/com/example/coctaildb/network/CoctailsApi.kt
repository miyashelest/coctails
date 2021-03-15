package com.example.coctaildb.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.math.log

private const val BASE_URL =
    "https://www.thecocktaildb.com"

private val gson = GsonConverterFactory.create(GsonBuilder().create())
val logging = HttpLoggingInterceptor()
val okhttpClient = OkHttpClient.Builder()
    .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okhttpClient)
    .addConverterFactory(gson)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()


interface CocktailsApiService {
    @GET("./api/json/v1/1/filter.php?c=Ordinary_Drink")
    fun getCocktailsAsync():
            Deferred<CocktailsList>
}

object CocktailsApi {
    val RETROFIT_SERVICE: CocktailsApiService by lazy {
        retrofit.create(CocktailsApiService::class.java)
    }
}