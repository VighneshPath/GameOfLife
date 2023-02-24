package models

import models.cells.Cell

class Board(private var boardState : MutableList<MutableList<Cell>>){

    fun startGame(iterations: Int): List<List<Cell>>{
        val previousBoardState = boardState.map {it->it.map{ele-> ele.copy()}}

        for(iteration in 0 until iterations){
            for(row in 0 until boardState.size){
                for(column in 0 until boardState.size){
                    val neighbors = getNearestLiveNeighbours(row, column, previousBoardState)

                    boardState[row][column] = boardState[row][column].updateState(neighbors)
                }
            }
        }

        return boardState
    }

    private fun getNearestLiveNeighbours(row: Int, column: Int, boardState: List<List<Cell>>): Int {
        val offsets = listOf(Pair(-1, -1),
            Pair(-1, 0),
            Pair(-1, 1),
            Pair(0, -1),
            Pair(0, 1),
            Pair(1, -1),
            Pair(1, 0),
            Pair(1, 1))

        println("$row $column")
        var count = 0

        for(offset in offsets){
            val k = row + offset.first
            val l = column + offset.second

            if(0<=k && k<boardState.size &&
                0<=l && l<boardState.size &&
                boardState[k][l].isLive()){
                count+=1
            }
        }
        println(count)
        return count
    }

}