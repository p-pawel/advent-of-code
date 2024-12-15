package aoc.year2024.day15

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WarehouseMapTest {
    @Test
    fun shouldApplyChange() {


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

        val location = Point(2, 1)

        val payload = ".OO.#"

        val direction = '>'

        // when

        // TODO not needed object!
        val result = applyChange(initMap, location, direction, payload )

        // then
        val expectedMap = listOf(
         "########",
         "#.@.OO.#",
         "##..O..#",
         "#...O..#",
         "#.#.O..#",
         "#...O..#",
         "#......#",
         "########",
        );

        assertEquals(expectedMap, result)

    }

}