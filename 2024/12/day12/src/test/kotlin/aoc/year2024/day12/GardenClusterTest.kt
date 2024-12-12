package aoc.year2024.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GardenClusterTest {

    @Test
    fun mergePlots() {

        // when
        val res = mergePlots(emptyList(), FencedPlot(GardenPlot(0, 0, 'A')))

        // then
        assertThat(res).containsExactlyInAnyOrder(FencedPlot(0, 0, 'A', setOf(Side.N, Side.E, Side.W, Side.S)))

    }

    @Test
    fun mergePlots2() {

        // when
        val res = mergePlots(
            listOf(
                FencedPlot(0, 0, 'A', setOf(Side.N, Side.E, Side.W, Side.S))
            ),
            FencedPlot(1, 0, 'A', setOf(Side.N, Side.E, Side.W, Side.S))
        )

        // then
        assertThat(res).containsExactlyInAnyOrder(
            FencedPlot(0, 0, 'A', setOf(Side.N, Side.W, Side.S)),
            FencedPlot(1, 0, 'A', setOf(Side.N, Side.E, Side.S)),
        )

    }

    @Test
    fun mergePlots3() {

        // when
        val res = mergePlots(
            listOf(
                FencedPlot(0, 0, 'A', setOf(Side.N, Side.W, Side.S)),
                FencedPlot(1, 0, 'A', setOf(Side.N, Side.E, Side.S)),
            ),
            FencedPlot(0, 1, 'A', setOf(Side.N, Side.E, Side.W, Side.S))
        )

        // then
        assertThat(res).containsExactlyInAnyOrder(
            FencedPlot(0, 0, 'A', setOf(Side.N, Side.W)),
            FencedPlot(1, 0, 'A', setOf(Side.N, Side.E, Side.S)),
            FencedPlot(0, 1, 'A', setOf(Side.S, Side.E, Side.W)),
        )

    }

    @Test
    fun mergePlots4() {

        // when
        val res = mergePlots(
            listOf(
                FencedPlot(0, 0, 'A', setOf(Side.N, Side.W)),
                FencedPlot(1, 0, 'A', setOf(Side.N, Side.E, Side.S)),
                FencedPlot(0, 1, 'A', setOf(Side.S, Side.E, Side.W)),
            ),
            FencedPlot(1, 1, 'A', setOf(Side.N, Side.E, Side.W, Side.S))
        )

        // then
        assertThat(res).containsExactlyInAnyOrder(
            FencedPlot(0, 0, 'A', setOf(Side.N, Side.W)),
            FencedPlot(1, 0, 'A', setOf(Side.N, Side.E)),
            FencedPlot(0, 1, 'A', setOf(Side.S, Side.W)),
            FencedPlot(1, 1, 'A', setOf(Side.S, Side.E)),
        )

    }
}