package id.dayplug.coroutinessamplemvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://dog.ceo/api/"

/**
 * Build retrofit from current [BASE_URL]
 */
private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

class RetrofitClient{
    companion object Retrofit{
        val dogService: DogNetwork = retrofit.create(DogNetwork::class.java)
    }
}