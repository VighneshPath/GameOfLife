package models

import models.CellType.DEAD
import models.CellType.LIVE

class Cell(private val location: Location, private var cellType: CellType){
    fun getCellLocation(): Location{
        return location
    }

    fun isLive(): Boolean {
        return when(cellType){
            LIVE ->{
                true
            }

            DEAD ->{
                false
            }
        }
    }

    override fun toString(): String {
        return when(cellType){
            LIVE ->{
                "O"
            }

            DEAD ->{
                "-"
            }
        }
    }
}
