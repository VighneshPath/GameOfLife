package models.cells

class LiveCell : Cell{
    override fun updateState(noOfLiveNeighbors: Int): Cell {
        if(noOfLiveNeighbors < 2 || noOfLiveNeighbors > 3) return DeadCell()

        return this
    }

    override fun copy(): Cell {
        return LiveCell()
    }

    override fun isLive(): Boolean {
        return true
    }

    override fun toString(): String {
        return "O"
    }
}