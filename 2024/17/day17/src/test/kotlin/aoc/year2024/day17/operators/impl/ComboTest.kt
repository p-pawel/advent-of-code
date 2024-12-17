package aoc.year2024.day17.operators.impl

import aoc.year2024.aoc.year2024.day17.OperatorInput
import aoc.year2024.aoc.year2024.day17.OperatorOutput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ComboTest {

//    companion object {
//        @JvmStatic
//        fun provideStringsForIsBlank() = listOf(
//            Arguments.of(null, true),
//            Arguments.of("", true),
//            Arguments.of("  ", true),
//            Arguments.of("not blank", false)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("provideStringsForIsBlank")
    @Test
    fun shouldProcess() {

        val input = OperatorInput(1, listOf(729, 0, 0))

        val output = Adv().process(input)

        assertEquals(OperatorOutput(0, 364, null, null), output)
    }

}