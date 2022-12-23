package com.demox.search.repository

interface SearchRepository {
    suspend fun getBinList(bin: String): String
}
