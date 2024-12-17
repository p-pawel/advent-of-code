package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.OperatorOutput
import aoc.year2024.day17.operators.api.StrangeMachineOperator

class Bst : StrangeMachineOperator {

    override fun process(input: OperatorInput): OperatorOutput {
        val b = Combo().process(input) % 8
        return OperatorOutput(1, b, null, null)
    }

}