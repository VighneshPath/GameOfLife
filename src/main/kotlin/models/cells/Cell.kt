package models.cells

interface Cell {
    fun updateState(noOfLiveNeighbors: Int): Boolean

    fun copy(): Cell
}
