package aoc.year2024.day15

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class MoveCalculatorKtTest {
    @ParameterizedTest
    @CsvSource(
        "...., ....",
        ".???, .???",
        "#???, #???",
        "O..., .O..",
        "OO.., .OO.",
        "O.O., .OO.",
        "O..O, .O.O",
        "OOO., .OOO",
        "OO.O, .OOO",
        "O.OO, .OOO",
        "OOOO, OOOO",
        "OOOO#...., OOOO#....",
    )
    fun shouldCalculateMoveResult(input: String, expectedResult: String) {

        val res = moveTheLine(input);

        assertEquals(expectedResult, res)
    }

}