package com.aywaorla2a.response

import com.google.gson.annotations.SerializedName

data class YesOrNoResponse (
    @SerializedName("answer")
    val answer: String,
    @SerializedName("image")
    val image: String
)
