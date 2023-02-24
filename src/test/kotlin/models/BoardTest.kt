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
        val liveCellLocations = listOf(Pair(1, 0), Pair(1, 1), Pair(1, 2))
        val boardDetails = MutableList(boardSize){ MutableList<Cell>(boardSize){DeadCell()} }
        for(location in liveCellLocations){
            boardDetails[location.first][location.second] = LiveCell()
        }
        board = Board(boardDetails)

        val returnedBoard = board.startGame(1)


        assertIs<DeadCell>(returnedBoard[0][0])
        assertIs<LiveCell>(returnedBoard[0][1])
        assertIs<DeadCell>(returnedBoard[0][2])
        assertIs<DeadCell>(returnedBoard[1][0])
        assertIs<DeadCell>(returnedBoard[1][2])
        assertIs<LiveCell>(returnedBoard[1][1])
        assertIs<LiveCell>(returnedBoard[2][1])
    }

    @Test
    fun `should have one cell after one iteration`(){
        val boardSize = 3
        val liveCellLocations = listOf(Pair(1, 0), Pair(1, 1), Pair(1, 2))
        val boardDetails = MutableList(boardSize){ MutableList<Cell>(boardSize){DeadCell()} }
        for(location in liveCellLocations){
            boardDetails[location.first][location.second] = LiveCell()
        }
        board = Board(boardDetails)

        val returnedBoard = board.startGame(2)

        assertIs<LiveCell>(returnedBoard[1][0])
        assertIs<LiveCell>(returnedBoard[1][2])
        assertIs<LiveCell>(returnedBoard[1][1])
    }

}