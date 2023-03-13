package com.cryptobytes.ps_shipments.data.repository

interface Repository<T> {
    suspend fun save(item: T)
    suspend fun get(id: Int) : T
    suspend fun delete(item: T)
    suspend fun deleteAll()
}