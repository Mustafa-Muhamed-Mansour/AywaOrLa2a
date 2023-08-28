package com.aywaorla2a.network.remote

import com.aywaorla2a.response.YesOrNoResponse
import retrofit2.http.GET

interface AppService {


    @GET("api")
//    @GET("credit_cards")
    suspend fun fetchYesOrNo(): YesOrNoResponse

}