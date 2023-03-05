package com.cryptobytes.ps_shipments.data.repository

import com.cryptobytes.ps_shipments.data.db.dao.AssignmentDao
import com.cryptobytes.ps_shipments.data.dataSource.OffersDataSource
import com.cryptobytes.ps_shipments.data.model.Assignment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AssignmentRepository @Inject constructor(
    val assignmentDao: AssignmentDao,
    val offersDataSource: OffersDataSource
) {
    fun getAssignments(): Flow<List<Assignment>> {
        return flow {  }
    }

    fun syncRemoteToLocal() {

    }
}