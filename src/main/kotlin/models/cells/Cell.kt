package models.cells

interface Cell {
    fun updateState(noOfLiveNeighbors: Int): Cell

    fun copy(): Cell

    fun isLive(): Boolean
}
