package aoc.year2024.day17.operators.impl

import aoc.year2024.aoc.year2024.day17.OperatorInput
import aoc.year2024.aoc.year2024.day17.OperatorOutput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AdvTest {

    @Test
    fun shouldProcess() {

        val input = OperatorInput(1, listOf(729, 0, 0))

        val output = Adv().process(input)

        assertEquals(OperatorOutput(0, 364, null, null), output)
    }

}