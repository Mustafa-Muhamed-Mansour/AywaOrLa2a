package com.aywaorla2a.repository

import com.aywaorla2a.network.remote.AppService
import com.aywaorla2a.response.YesOrNoResponse
import javax.inject.Inject

class YesOrNoRepository @Inject constructor(
    private val appService: AppService
) {


    suspend fun fetchYesOrNo(): YesOrNoResponse {
        return appService.fetchYesOrNo()
    }


}