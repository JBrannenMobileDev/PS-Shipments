package com.cryptobytes.ps_shipments.data.db.dao

import androidx.room.*
import com.cryptobytes.ps_shipments.data.model.Assignment
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.LocalDateTime

@Dao
interface AssignmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(assignment: Assignment)

    @Update
    suspend fun update(assignment: Assignment)

    @Delete
    suspend fun delete(assignment: Assignment)

    fun getForDate(date: LocalDate) : Flow<List<Assignment>> {
        val dayStart = date.atStartOfDay()
        val dayEnd = date.plusDays(1).atStartOfDay()
        return getForDay(dayStart, dayEnd)
    }

    @Query("SELECT * FROM assignment_table WHERE date BETWEEN :dayStart AND :dayEnd")
    fun getForDay(dayStart: LocalDateTime, dayEnd: LocalDateTime): Flow<List<Assignment>>
}