package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.OperatorOutput
import aoc.year2024.day17.operators.api.StrangeMachineOperator

class Cdv : StrangeMachineOperator {

    override fun process(input: OperatorInput): OperatorOutput {
        val numerator: Long = input.registers[0];
        val denominator: Long = 1L shl Combo().process(input).toInt()
        val c: Long = numerator / denominator;
        return OperatorOutput(2, c, null, null)
    }

}