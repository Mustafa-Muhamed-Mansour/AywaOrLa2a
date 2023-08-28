package com.aywaorla2a.response

import com.google.gson.annotations.SerializedName

data class YesOrNoResponse (
    @SerializedName("answer")
//    @SerializedName("credit_card_number")
    val answer: String,
//    val creditCardNumber: String,
    @SerializedName("image")
//    @SerializedName("credit_card_expiry_date")
    val image: String
//    val creditCardExpiryDate: String
)