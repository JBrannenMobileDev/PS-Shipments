package com.cryptobytes.ps_shipments.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cryptobytes.ps_shipments.data.db.dao.TableNames
import java.time.LocalDateTime

@Entity(tableName = TableNames.TABLE_ASSIGNMENTS)
data class Assignment(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    var driverName:String,
    var destinationAddress:String,
    var ss:Double,
    var date: LocalDateTime
)
