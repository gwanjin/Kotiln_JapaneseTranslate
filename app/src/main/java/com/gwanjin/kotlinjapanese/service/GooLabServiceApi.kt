package com.gwanjin.kotlinjapanese.service

import com.gwanjin.kotlinjapanese.model.HiraganaRepo
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

private const val APP_ID = ""

interface GooLabServiceApi {
    @FormUrlEncoded
    @POST("/api/hiragana")
    @Headers("accept: application/json",
        "content-type: application/x-www-form-urlencoded"
    )
    fun getConvertedSentence(
        @Field("app_id")appId:String = APP_ID,
        @Field("sentence")sentence:String,
        @Field("output_type")outputType:String = "hiragana") : Single<HiraganaRepo>
}