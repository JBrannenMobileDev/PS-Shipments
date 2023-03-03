package com.cryptobytes.ps_shipments.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "assignment_table")
data class Assignment(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var driverName:String,
    var destinationAddress:String,
    var date: Date
)
