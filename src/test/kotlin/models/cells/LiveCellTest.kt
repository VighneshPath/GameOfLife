package models.cells

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class LiveCellTest{
    private lateinit var liveCell : LiveCell
    @Test
    fun `should return true if is live is called`(){
        liveCell = LiveCell()
        val expectedState = true

        assertEquals(expectedState, liveCell.isLive())
    }

    @Test
    fun `should return itself if neighbors are 3`(){
        liveCell = LiveCell()

        val newCell = liveCell.updateState(3)

        assertIs<LiveCell>(newCell)
    }

    @Test
    fun `should die if number if neighbors is less than 2`(){
        liveCell = LiveCell()

        val newCell = liveCell.updateState(1)

        assertIs<DeadCell>(newCell)
    }
}