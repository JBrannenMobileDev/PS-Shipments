package com.cryptobytes.ps_shipments.data.repository

import com.cryptobytes.ps_shipments.data.algorithms.AssignmentCalculator
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
) : Repository<Assignment> {
    fun getAllForToday(): Flow<List<Assignment>> {
        return assignmentDao.getForDate(LocalDate.now())
    }

    suspend fun syncRemoteToLocal() = withContext(Dispatchers.IO + NonCancellable) {
        val offers = offersDataSource.fetchTodaysOffers()
        val matrix = offers?.let { AssignmentCalculator(it) }
        assignmentDao.deleteAllForDate(LocalDate.now())
        matrix?.generateAssignments()?.forEach { assignment -> assignmentDao.insert(assignment) }
    }

    override suspend fun save(item: Assignment) {
        assignmentDao.insert(item)
    }

    override suspend fun get(id: Int): Assignment {
        return assignmentDao.getById(id)
    }

    override suspend fun delete(item: Assignment) {
        assignmentDao.delete(item)
    }

    override suspend fun deleteAll() {
        assignmentDao.deleteAll()
    }
}