package az.zero.bitcoin.data.network.di

import az.zero.bitcoin.core.BASE_URL
import az.zero.bitcoin.data.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    @Volatile
    private var INSTANCE: ApiService? = null
    private val lock = Any()

    private val httpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    private val okHttpClient by lazy {
        OkHttpClient().newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @JvmStatic
    fun newInstance() = INSTANCE ?: synchronized(lock) {
        INSTANCE ?: Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

}