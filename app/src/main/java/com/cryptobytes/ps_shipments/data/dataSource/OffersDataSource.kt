package com.cryptobytes.ps_shipments.data.dataSource

import com.cryptobytes.ps_shipments.data.dataSource.OffersDataSource.DataConstant.JSON_DATA
import com.cryptobytes.ps_shipments.data.model.Offers
import com.google.gson.Gson
import java.io.FileReader

class OffersDataSource {
    object DataConstant{
        const val JSON_DATA = "{\n" +
                "  \"shipments\": [\n" +
                "    \"215 Osinski Manors\",\n" +
                "    \"9856 Marvin Stravenue\",\n" +
                "    \"7127 Kathlyn Ferry\",\n" +
                "    \"987 Champlin Lake\",\n" +
                "    \"63187 Volkman Garden Suite 447\",\n" +
                "    \"75855 Dessie Lights\",\n" +
                "    \"1797 Adolf Island Apt. 744\",\n" +
                "    \"2431 Lindgren Corners\",\n" +
                "    \"8725 Aufderhar River Suite 859\",\n" +
                "    \"79035 Shanna Light Apt. 322\"\n" +
                "  ],\n" +
                "  \"drivers\": [\n" +
                "    \"Everardo Welch\",\n" +
                "    \"Orval Mayert\",\n" +
                "    \"Howard Emmerich\",\n" +
                "    \"Izaiah Lowe\",\n" +
                "    \"Monica Hermann\",\n" +
                "    \"Ellis Wisozk\",\n" +
                "    \"Noemie Murphy\",\n" +
                "    \"Cleve Durgan\",\n" +
                "    \"Murphy Mosciski\",\n" +
                "    \"Kaiser Sose\"\n" +
                "  ]\n" +
                "}"
    }
    fun fetchTodaysOffers(): Offers? {
        return Gson().fromJson(JSON_DATA, Offers::class.java)
    }
}