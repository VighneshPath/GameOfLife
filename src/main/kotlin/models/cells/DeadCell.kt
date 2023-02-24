package models.cells

class DeadCell: Cell{
    override fun updateState(noOfLiveNeighbors: Int): Boolean {
        if(noOfLiveNeighbors == 3) return true

        return false
    }

    override fun copy(): Cell {
        return DeadCell()
    }

    override fun toString(): String {
        return "-"
    }
}