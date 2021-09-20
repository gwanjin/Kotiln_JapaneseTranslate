package com.gwanjin.kotlinjapanese.model

import com.google.gson.annotations.SerializedName

data class HiraganaRepo(
    @SerializedName("request_id") val requestId: String,
    @SerializedName("output_type") val outputType: String,
    @SerializedName("converted") val converted: String
)
