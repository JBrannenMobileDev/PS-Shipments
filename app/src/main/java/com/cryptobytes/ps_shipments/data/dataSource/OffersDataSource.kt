package com.cryptobytes.ps_shipments.data.dataSource

import com.cryptobytes.ps_shipments.data.model.Offers
import com.google.gson.Gson
import java.io.FileReader

class OffersDataSource {
    fun fetchTodaysOffers(): Offers? {
        return Gson().fromJson(FileReader("data.json"), Offers::class.java)
    }
}