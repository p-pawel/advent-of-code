package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.OperatorOutput
import aoc.year2024.day17.operators.api.StrangeMachineOperator

class Jnz : StrangeMachineOperator {

    override fun process(input: OperatorInput): OperatorOutput {
        val inA = input.registers[0]
        return OperatorOutput(null, null, if (inA == 0.toLong()) null else input.operand, null)
    }

}