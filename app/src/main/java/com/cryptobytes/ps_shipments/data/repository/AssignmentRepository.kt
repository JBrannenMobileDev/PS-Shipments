package com.cryptobytes.ps_shipments.data.repository

import com.cryptobytes.ps_shipments.data.algorithms.AssignmentMatrix
import com.cryptobytes.ps_shipments.data.db.dao.AssignmentDao
import com.cryptobytes.ps_shipments.data.dataSource.OffersDataSource
import com.cryptobytes.ps_shipments.data.model.Assignment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

class AssignmentRepository @Inject constructor(
    private val assignmentDao: AssignmentDao,
    private val offersDataSource: OffersDataSource
) {
    fun getAssignments(): Flow<List<Assignment>> {
        return assignmentDao.getForDate(LocalDate.now())
    }

    fun clearAllForToday() {
        assignmentDao.deleteAllForDate(LocalDate.now())
    }

    suspend fun syncRemoteToLocal() = withContext(Dispatchers.IO + NonCancellable) {
        val offers = offersDataSource.fetchTodaysOffers()
        val matrix = offers?.let { AssignmentMatrix(it) }
        clearAllForToday()
        matrix?.generateAssignments()?.forEach { assignment -> assignmentDao.insert(assignment) }
    }
}