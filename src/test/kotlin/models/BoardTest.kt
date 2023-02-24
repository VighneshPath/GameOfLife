package models

import models.cells.Cell
import models.cells.DeadCell
import models.cells.LiveCell
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class BoardTest{
    private lateinit var board: Board
    @Test
    fun `should die after two iterations`(){
        val boardSize = 3
        val liveCellLocations = listOf(Location(1, 0), Location(1, 1), Location(1, 2))
        board = Board(liveCellLocations, boardSize)
        val expectedLiveLocations = listOf(Location(0, 1),
            Location(1, 1),
            Location(2, 1))

        board.startGame(1)
        val returnedList = board.getListOfLiveLocations()

        assertTrue((expectedLiveLocations.size == returnedList.size) &&
                expectedLiveLocations.containsAll(returnedList) &&
                returnedList.containsAll(expectedLiveLocations))
    }

    @Test
    fun `should have one cell after one iteration`(){
        val boardSize = 3
        val liveCellLocations = listOf(Location(1, 0), Location(1, 1), Location(1, 2))
        board = Board(liveCellLocations, boardSize)
        val expectedLiveLocations = listOf(Location(1, 0),
            Location(1, 2),
            Location(1, 1))

        board.startGame(2)
        val returnedList = board.getListOfLiveLocations()

        assertTrue((expectedLiveLocations.size == returnedList.size) &&
                expectedLiveLocations.containsAll(returnedList) &&
                returnedList.containsAll(expectedLiveLocations))
    }

}