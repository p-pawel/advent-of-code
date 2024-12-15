package aoc.year2024.day15

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WarehouseMapTest {

    @Test
    fun `should process part 1 example 1`() {

        // given

        val initMap = listOf(
            "########",
            "#.@O.O.#",
            "##..O..#",
            "#...O..#",
            "#.#.O..#",
            "#...O..#",
            "#......#",
            "########",
        );

        val sequence = "<^^>>>vv<v>>v<<"

        // when
        val score = executeGame(initMap, listOf(sequence), 1)

        // then
        assertEquals(2028, score)

    }

    @Test
    fun `should process part 2 example`() {

        // given

        val initMap = listOf(
            "#######",
            "#...#.#",
            "#.....#",
            "#..OO@#",
            "#..O..#",
            "#.....#",
            "#######",
        );

        val sequence = "<vv<<^^<<^^"

        // when
        val score = executeGame(initMap, listOf(sequence), 2)

        // then
        assertEquals(105+207+306, score)

    }

}