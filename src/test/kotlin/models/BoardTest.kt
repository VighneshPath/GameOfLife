package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest{
    @Test
    fun `should create a board with live cells at given locations`(){
        val givenLiveLocations = listOf(Location(0, 0), Location(1, 1))
        val board = Board(givenLiveLocations)

        val actualLiveLocations = board.startGame(0)

        assertEquals(actualLiveLocations, givenLiveLocations)
    }
}