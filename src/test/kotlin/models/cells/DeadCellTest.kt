package models.cells

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class DeadCellTest{
    private lateinit var deadCell : DeadCell
    @Test
    fun `should return false if is live is called`(){
        deadCell = DeadCell()
        val expectedState = false

        assertEquals(expectedState, deadCell.isLive())
    }

    @Test
    fun `should revive if neighbors are 3`(){
        deadCell = DeadCell()

        val newCell = deadCell.updateState(3)

        assertIs<LiveCell>(newCell)
    }

    @Test
    fun `should return itself if neighbors are less than 3`(){
        deadCell = DeadCell()

        val newCell = deadCell.updateState(2)

        assertIs<DeadCell>(newCell)
    }
}