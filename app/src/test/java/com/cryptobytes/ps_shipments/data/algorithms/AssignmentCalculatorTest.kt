package com.cryptobytes.ps_shipments.data.algorithms

import com.cryptobytes.ps_shipments.data.dataSource.OffersDataSource
import com.cryptobytes.ps_shipments.data.model.Assignment
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

class AssignmentCalculatorTest {
    @Test
    fun `verify correct assignments are generated with provided input`() {
        val now = LocalDateTime.now()
        val offers = OffersDataSource().fetchTodaysOffers(
            "{\n" +
                    "  \"shipments\": [\n" +
                    "    \"215 Osinski Manors\",\n" +
                    "    \"9856 Marvin Stravenue\",\n" +
                    "    \"7127 Kathlyn Ferry\",\n" +
                    "    \"987 Champlin Lake\",\n" +
                    "    \"63187 Volkman Garden Suite 447\",\n" +
                    "    \"75855 Dessie Lights\",\n" +
                    "    \"1797 Adolf Island Apt. 744\",\n" +
                    "    \"2431 Lindgren Corners\",\n" +
                    "    \"8725 Aufderhar River Suite 859\",\n" +
                    "    \"79035 Shanna Light Apt. 322\"\n" +
                    "  ],\n" +
                    "  \"drivers\": [\n" +
                    "    \"Everardo Welch\",\n" +
                    "    \"Orval Mayert\",\n" +
                    "    \"Howard Emmerich\",\n" +
                    "    \"Izaiah Lowe\",\n" +
                    "    \"Monica Hermann\",\n" +
                    "    \"Ellis Wisozk\",\n" +
                    "    \"Noemie Murphy\",\n" +
                    "    \"Cleve Durgan\",\n" +
                    "    \"Murphy Mosciski\",\n" +
                    "    \"Kaiser Sose\"\n" +
                    "  ]\n" +
                    "}")
        val expected = mutableListOf<Assignment>()
        expected.add(Assignment(
            driverName = "Everardo Welch",
            destinationAddress = "215 Osinski Manors",
            ss = 12.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Orval Mayert",
            destinationAddress = "2431 Lindgren Corners",
            ss = 7.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Howard Emmerich",
            destinationAddress = "7127 Kathlyn Ferry",
            ss = 11.25,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Izaiah Lowe",
            destinationAddress = "987 Champlin Lake",
            ss = 13.5,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Monica Hermann",
            destinationAddress = "63187 Volkman Garden Suite 447",
            ss = 12.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Ellis Wisozk",
            destinationAddress = "1797 Adolf Island Apt. 744",
            ss = 10.5,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Noemie Murphy",
            destinationAddress = "9856 Marvin Stravenue",
            ss = 10.5,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Cleve Durgan",
            destinationAddress = "8725 Aufderhar River Suite 859",
            ss = 6.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Murphy Mosciski",
            destinationAddress = "79035 Shanna Light Apt. 322",
            ss = 10.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Kaiser Sose",
            destinationAddress = "75855 Dessie Lights",
            ss = 11.25,
            date = now
        ))

        if(offers != null) {
            //When
            val actual = AssignmentCalculator(offers).generateAssignments(now)

            //Then
            Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual))
        }
    }

    @Test
    fun `verify correct assignments are generated with altered input rev1`() {
        val now = LocalDateTime.now()
        val offers = OffersDataSource().fetchTodaysOffers(
            "{\n" +
                    "  \"shipments\": [\n" +
                    "    \"215 Osinski Manors\",\n" +
                    "    \"9856 Marvin Stravenue\",\n" +
                    "    \"7127 Kathlyn Ferry\"\n" +
                    "  ],\n" +
                    "  \"drivers\": [\n" +
                    "    \"Everardo Welch\",\n" +
                    "    \"Orval Mayert\",\n" +
                    "    \"Howard Emmerich\"\n" +
                    "  ]\n" +
                    "}")
        val expected = mutableListOf<Assignment>()
        expected.add(Assignment(
            driverName = "Everardo Welch",
            destinationAddress = "215 Osinski Manors",
            ss = 12.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Orval Mayert",
            destinationAddress = "9856 Marvin Stravenue",
            ss = 7.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Howard Emmerich",
            destinationAddress = "7127 Kathlyn Ferry",
            ss = 11.25,
            date = now
        ))

        if(offers != null) {
            //When
            val actual = AssignmentCalculator(offers).generateAssignments(now)

            //Then
            Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual))
        }
    }

    @Test
    fun `verify correct assignments are generated with altered input rev2`() {
        val now = LocalDateTime.now()
        val offers = OffersDataSource().fetchTodaysOffers(
            "{\n" +
                    "  \"shipments\": [\n" +
                    "    \"215 Osinski Manors\",\n" +
                    "    \"2431 Lindgren Corners\",\n" +
                    "    \"8725 Aufderhar River Suite 859\",\n" +
                    "    \"79035 Shanna Light Apt. 322\"\n" +
                    "  ],\n" +
                    "  \"drivers\": [\n" +
                    "    \"Everardo Welch\",\n" +
                    "    \"Cleve Durgan\",\n" +
                    "    \"Murphy Mosciski\",\n" +
                    "    \"Kaiser Sose\"\n" +
                    "  ]\n" +
                    "}")
        val expected = mutableListOf<Assignment>()
        expected.add(Assignment(
            driverName = "Everardo Welch",
            destinationAddress = "215 Osinski Manors",
            ss = 12.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Cleve Durgan",
            destinationAddress = "8725 Aufderhar River Suite 859",
            ss = 6.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Murphy Mosciski",
            destinationAddress = "79035 Shanna Light Apt. 322",
            ss = 10.0,
            date = now
        ))
        expected.add(Assignment(
            driverName = "Kaiser Sose",
            destinationAddress = "2431 Lindgren Corners",
            ss = 7.5,
            date = now
        ))

        if(offers != null) {
            //When
            val actual = AssignmentCalculator(offers).generateAssignments(now)

            //Then
            Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual))
        }
    }
}