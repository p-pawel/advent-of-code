package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.OperatorOutput
import aoc.year2024.day17.operators.api.StrangeMachineOperator

class Bxl : StrangeMachineOperator {

    override fun process(input: OperatorInput): OperatorOutput {
        val r = input.registers[1];
        val literal = input.operand
        val b = r xor literal
        return OperatorOutput(1, b, null, null)
    }

}