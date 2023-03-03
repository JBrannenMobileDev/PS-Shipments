package com.cryptobytes.ps_shipments.data.dao

import androidx.room.*
import com.cryptobytes.ps_shipments.data.model.Assignment
import kotlinx.coroutines.flow.Flow

interface AssignmentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(assignment: Assignment)

    @Update
    suspend fun update(assignment: Assignment)

    @Delete
    suspend fun delete(assignment: Assignment)

    @Query("SELECT * FROM assignment_table")
    fun get(): Flow<List<Assignment>>
}