package aoc.year2024.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class GardenClusterKtTest {

    @Test
    fun calcAdjacentSideE() {

        // given
        val oldPlot = FencedPlot(1, 1, 'A', emptySet()) // set irrelevant
        val newPlot = FencedPlot(2, 1, 'A', emptySet()) // set irrelevant

        // when
        val calcAdjacentSide = calcAdjacentSide(oldPlot, newPlot)

        // then
        assertThat(calcAdjacentSide).isEqualTo(Side.E);
    }

    @Test
    fun calcAdjacentSideW() {

        // given
        val oldPlot = FencedPlot(1, 1, 'A', emptySet()) // set irrelevant
        val newPlot = FencedPlot(0, 1, 'A', emptySet()) // set irrelevant

        // when
        val calcAdjacentSide = calcAdjacentSide(oldPlot, newPlot)

        // then
        assertThat(calcAdjacentSide).isEqualTo(Side.W);
    }

    @Test
    fun calcAdjacentSideN() {

        // given
        val oldPlot = FencedPlot(1, 1, 'A', emptySet()) // set irrelevant
        val newPlot = FencedPlot(1, 0, 'A', emptySet()) // set irrelevant

        // when
        val calcAdjacentSide = calcAdjacentSide(oldPlot, newPlot)

        // then
        assertThat(calcAdjacentSide).isEqualTo(Side.S);
    }
    @Test
    fun calcAdjacentSideS() {

        // given
        val oldPlot = FencedPlot(1, 1, 'A', emptySet()) // set irrelevant
        val newPlot = FencedPlot(1, 2, 'A', emptySet()) // set irrelevant

        // when
        val calcAdjacentSide = calcAdjacentSide(oldPlot, newPlot)

        // then
        assertThat(calcAdjacentSide).isEqualTo(Side.N);
    }
}