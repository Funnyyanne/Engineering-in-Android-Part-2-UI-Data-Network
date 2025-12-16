package com.epam.test.minimalistnotes.network

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Quote(
    @SerializedName("quote") val content: String,
    val author: String
)

interface QuoteApi {
    @GET("quotes/random")
    suspend fun getRandomQuote(): Quote
}

object NetworkModule {
    private const val BASE_URL = "https://dummyjson.com/"

    val api: QuoteApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }
}