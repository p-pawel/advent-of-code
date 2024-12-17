package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.OperatorOutput
import aoc.year2024.day17.operators.api.StrangeMachineOperator

class Bxc : StrangeMachineOperator {

    override fun process(input: OperatorInput): OperatorOutput {
        val inB = input.registers[1]
        val inC = input.registers[2]
        val b = inB xor inC
        return OperatorOutput(1, b, null, null)
    }

}