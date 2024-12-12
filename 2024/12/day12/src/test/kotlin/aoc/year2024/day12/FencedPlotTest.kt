package aoc.year2024.day12

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FencedPlotTest {

    @Test
    fun shouldBeEqual() {
        val plot1 = FencedPlot(0, 0, 'A', emptySet())
        val plot2 = FencedPlot(0, 0, 'A', emptySet())

        assertEquals(plot1, plot2)
    }

    @Test
    fun shouldBeEqualNoMatterSidesOrder() {
        val plot1 = FencedPlot(0, 0, 'A', setOf(Side.N, Side.E, Side.W, Side.S))
        val plot2 = FencedPlot(0, 0, 'A', setOf(Side.E, Side.N, Side.S, Side.W))

        assertEquals(plot1, plot2)
    }
}