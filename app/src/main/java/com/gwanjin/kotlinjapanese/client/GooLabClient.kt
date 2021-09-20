package com.gwanjin.kotlinjapanese.client

import com.gwanjin.kotlinjapanese.service.GooLabServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GooLabClient {

    companion object {
        private const val BASE_URL = "https://labs.goo.ne.jp"

        fun getHiragana(): GooLabServiceApi {
            // 通信Log出力
            val logIntercepter = HttpLoggingInterceptor()
            logIntercepter.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient:OkHttpClient = OkHttpClient.Builder().addInterceptor(logIntercepter).build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GooLabServiceApi::class.java)
        }
    }
}