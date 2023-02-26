package models

import models.CellType.DEAD
import models.CellType.LIVE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `should create a live cell at 0, 0`(){
        val expectedCellLifeStatus = true
        val expectedCellLocation = Location(0L, 0L)

        val cell = Cell(Location(0L, 0L), LIVE)

        assertEquals(expectedCellLifeStatus, cell.isLive())
        assertEquals(expectedCellLocation, cell.getCellLocation())
    }

    @Test
    fun `should create a dead cell 0, 0`(){
        val expectedCellLifeStatus = false
        val expectedCellLocation = Location(0L, 0L)

        val cell = Cell(Location(0L, 0L), DEAD)

        assertEquals(expectedCellLifeStatus, cell.isLive())
        assertEquals(expectedCellLocation, cell.getCellLocation())
    }
}