package models.cells

class DeadCell: Cell{
    override fun updateState(noOfLiveNeighbors: Int): Cell {
        if(noOfLiveNeighbors == 3) return LiveCell()

        return this
    }

    override fun copy(): Cell {
        return DeadCell()
    }

    override fun isLive(): Boolean {
        return false
    }

    override fun toString(): String {
        return "-"
    }
}