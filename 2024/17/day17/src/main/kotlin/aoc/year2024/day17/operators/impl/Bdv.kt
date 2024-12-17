package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.OperatorOutput
import aoc.year2024.day17.operators.api.StrangeMachineOperator

class Bdv : StrangeMachineOperator {

    override fun process(input: OperatorInput): OperatorOutput {
        val numerator = input.registers[0];
        val denominator = 1L shl Combo().process(input).toInt()
        val b = numerator / denominator;
        return OperatorOutput(1, b, null, null)
    }

}