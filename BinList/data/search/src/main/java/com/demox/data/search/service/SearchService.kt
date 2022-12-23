package com.demox.data.search.service

import com.demox.data.search.model.ServerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchService {
    @GET("/{bin}")
    suspend fun getBinList(@Path("bin") bin: String): Response<ServerResponse>
}
