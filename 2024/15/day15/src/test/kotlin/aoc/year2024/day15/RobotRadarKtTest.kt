package aoc.year2024.day15

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RobotRadarKtTest {

    val map = listOf(
        "########",
        "#..O.O.#",
        "#.@.O..#",
        "#...O..#",
        "#.#.O..#",
        "#...O..#",
        "#......#",
        "########"
    )

    @Test
    fun shouldScanRight() {
        var result = scanRight(map, Point(2, 2));
        assertEquals(".O..#", result);
    }

    @Test
    fun shouldScanLeft() {
        var result = scanLeft(map, Point(2, 2));
        assertEquals(".#", result);
    }

    @Test
    fun shouldScanDown() {
        var result = scanDown(map, Point(2, 2));
        assertEquals(".#..#", result);
    }

    @Test
    fun shouldScanUp() {
        var result = scanUp(map, Point(3, 3));
        assertEquals(".O#", result);
    }

}