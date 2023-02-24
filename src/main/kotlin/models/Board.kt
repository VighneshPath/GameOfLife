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
        // check right neighbor
        var count: Int = 0
        println(row)
        println(column)
        println(boardState.size)
        print(boardState[row][column])
        if(column < boardState.size-1){
            if(boardState[row][column+1].isLive()){
                count+=1
            }
        }
        // check left neighbor
        if(column>0){
            if(boardState[row][column-1].isLive()){
                count+=1
            }
        }

        // check top neighbor
        if(row < boardState.size-1){
            if(boardState[row+1][column].isLive()){
                count+=1
            }
        }

        // check bottom neighbor
        if(row > 0){
            if(boardState[row-1][column].isLive()){
                count+=1
            }
        }

        return count
    }

}