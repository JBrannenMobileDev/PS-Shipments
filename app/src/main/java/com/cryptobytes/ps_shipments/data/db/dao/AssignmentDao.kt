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

    fun deleteAllForDate(date: LocalDate) {
        val dayStart = date.atStartOfDay()
        val dayEnd = date.plusDays(1).atStartOfDay()
        return deleteAllForDay(dayStart, dayEnd)
    }

    @Query("DELETE FROM ${TableNames.TABLE_ASSIGNMENTS}")
    fun deleteAll()

    @Query("DELETE FROM ${TableNames.TABLE_ASSIGNMENTS} WHERE date BETWEEN :dayStart AND :dayEnd")
    fun deleteAllForDay(dayStart: LocalDateTime, dayEnd: LocalDateTime)

    fun getForDate(date: LocalDate) : Flow<List<Assignment>> {
        val dayStart = date.atStartOfDay()
        val dayEnd = date.plusDays(1).atStartOfDay()
        return getForDay(dayStart, dayEnd)
    }

    @Query("SELECT * FROM ${TableNames.TABLE_ASSIGNMENTS} WHERE date BETWEEN :dayStart AND :dayEnd")
    fun getForDay(dayStart: LocalDateTime, dayEnd: LocalDateTime): Flow<List<Assignment>>

    @Query("SELECT * FROM ${TableNames.TABLE_ASSIGNMENTS} WHERE id = :id")
    fun getById(id: Int): Assignment
}