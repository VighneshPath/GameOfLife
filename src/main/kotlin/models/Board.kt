package models

import models.cells.Cell
import models.cells.DeadCell
import models.cells.LiveCell

class Board(private val size: Int, private val liveCellLocations: List<Location>){
    private lateinit var boardState : MutableList<MutableList<Cell>>
    init{
        for(row in 0 until size){
            boardState.add(mutableListOf())
            for(column in 0 until size){
                boardState[row].add(DeadCell())
            }
        }
        liveCellLocations.forEach {
            boardState[it.row][it.column] = LiveCell()
        }
    }

    fun startGame(){
        val previousBoardState = boardState.map { it -> it.map{it.copy()})}
    }

}