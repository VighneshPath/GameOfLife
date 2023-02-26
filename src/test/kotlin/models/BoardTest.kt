package models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoardTest {
    @Test
    fun `should create a board with live cells at given locations`() {
        val givenLiveLocations = listOf(Location(0, 0), Location(1, 1))
        val board = Board(givenLiveLocations)

        val actualLiveLocations = board.startGame(0)

        assertThat(givenLiveLocations).containsExactlyInAnyOrderElementsOf(actualLiveLocations)
    }

    @Test
    fun `should create a board and update cells after an iteration`() {
        val givenLiveLocations = listOf(Location(0, 1), Location(1, 1), Location(2, 1))
        val board = Board(givenLiveLocations)
        val expectedLiveLocations = listOf(Location(1, 0), Location(1, 1), Location(1, 2))

        val actualLiveLocations = board.startGame(1)

        assertThat(expectedLiveLocations).containsExactlyInAnyOrderElementsOf(actualLiveLocations)
    }

    @Test
    fun `should create a board where the cell dies of underpopulation`() {
        val givenLiveLocations = listOf(Location(1, 1))
        val board = Board(givenLiveLocations)
        val expectedLiveLocations = listOf<Location>()

        val actualLiveLocations = board.startGame(1)

        assertEquals(expectedLiveLocations, actualLiveLocations)
    }

    @Test
    fun `should create a board where a cell dies of overpopulation`() {
        val givenLiveLocations = listOf(
            Location(0, 0), Location(0, 1), Location(0, 2), Location(1, 0), Location(1, 1)
        )
        val board = Board(givenLiveLocations)
        val expectedLiveLocations = listOf(
            Location(0, 0), Location(0, 2), Location(1, 0), Location(1, 2)
        )

        val actualLiveLocations = board.startGame(1)

        assertThat(expectedLiveLocations).containsExactlyInAnyOrderElementsOf(actualLiveLocations)
    }

    @Test
    fun `should create a board where a dead cell revives`() {
        val givenLiveLocations = listOf(
            Location(0, 0), Location(0, 1), Location(0, 2)
        )
        val board = Board(givenLiveLocations)
        val expectedLiveLocations = listOf(Location(1, 1), Location(0, 1))

        val actualLiveLocations = board.startGame(1)

        assertThat(expectedLiveLocations).containsExactlyInAnyOrderElementsOf(actualLiveLocations)
    }

    @Test
    fun `should create a board which runs for two iterations`() {
        val givenLiveLocations = listOf(Location(0, 1), Location(1, 1), Location(2, 1))
        val board = Board(givenLiveLocations)
        val expectedLiveLocations = listOf(Location(0, 1), Location(1, 1), Location(2, 1))

        val actualLiveLocations = board.startGame(2)

        assertThat(expectedLiveLocations).containsExactlyInAnyOrderElementsOf(actualLiveLocations)
    }
}