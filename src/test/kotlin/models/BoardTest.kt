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
    @BeforeEach
    fun setUp(){
        val boardSize = 3
        val liveCellLocations = listOf(Pair(0, 1), Pair(0, 2))

        val boardDetails = MutableList(boardSize){ MutableList<Cell>(boardSize){DeadCell()} }

        println(boardDetails.size)
        for(location in liveCellLocations){
            boardDetails[location.first][location.second] = LiveCell()
        }

        board = Board(boardDetails)
    }

    @Test
    fun `should die after one iteration`(){
        val returnedBoard = board.startGame(1)

        assertIs<DeadCell>(returnedBoard[0][1])
        assertIs<DeadCell>(returnedBoard[0][2])
    }
}