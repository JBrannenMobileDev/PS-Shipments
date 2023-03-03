package com.cryptobytes.ps_shipments.data.model

data class Offers(
    var shipments : ArrayList<String> = arrayListOf(),
    var drivers   : ArrayList<String> = arrayListOf()
)
