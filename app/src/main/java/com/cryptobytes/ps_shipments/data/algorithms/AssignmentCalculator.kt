package com.cryptobytes.ps_shipments.data.algorithms
import com.cryptobytes.ps_shipments.data.model.Assignment
import com.cryptobytes.ps_shipments.data.model.Offers
import com.cryptobytes.ps_shipments.data.suitablility_score.strategy.SuitabilityScoreStrategy
import java.time.LocalDateTime

class AssignmentCalculator(
    private val offers: Offers,
) {
    private lateinit var matrix: Array<DoubleArray>
    private lateinit var reversedMatrix: Array<DoubleArray>

    init {
        buildMatrix(offers)
    }

    private fun buildMatrix(offers: Offers) {
        matrix = Array(offers.drivers.size) { DoubleArray(offers.shipments.size) }
        reversedMatrix = Array(offers.drivers.size) { DoubleArray(offers.shipments.size) }
        var maxSS = 0.0

        offers.drivers.forEachIndexed {x, driver ->
            offers.shipments.forEachIndexed {y, shipment ->
                val ss = SuitabilityScoreStrategy().calculate(driver, shipment, 0.0)
                if(ss > maxSS) maxSS = ss
                matrix[x][y] = ss
            }
        }

        //invert scores for algorithm
        offers.drivers.forEachIndexed {x, _ ->
            offers.shipments.forEachIndexed {y, _ ->
                reversedMatrix[x][y] = maxSS - matrix[x][y]
            }
        }
    }

    fun generateAssignments(dateTime: LocalDateTime = LocalDateTime.now()) : List<Assignment> {
        val ha = HungarianAlgorithm(reversedMatrix)
        val assignment = ha.findOptimalAssignment()
        val assignments = mutableListOf<Assignment>()

        if (assignment.isNotEmpty()) {
            for (i in assignment.indices) {
                val newAssignment = Assignment(
                    driverName = offers.drivers.elementAt(assignment[i]!![0]),
                    destinationAddress = offers.shipments.elementAt(assignment[i]!![1]),
                    ss = matrix[assignment[i]!![0]][assignment[i]!![1]],
                    date = dateTime
                )
                assignments.add(newAssignment)
                print(newAssignment)
                println()
            }
        }
        return assignments
    }
}