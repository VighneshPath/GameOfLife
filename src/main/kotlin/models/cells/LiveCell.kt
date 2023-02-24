package models.cells

class LiveCell : Cell{
    override fun updateState(noOfLiveNeighbors: Int): Boolean {
        if(noOfLiveNeighbors < 2 || noOfLiveNeighbors > 3) return true

        return false
    }

    override fun copy(): Cell {
        return LiveCell()
    }

    override fun toString(): String {
        return "O"
    }
}