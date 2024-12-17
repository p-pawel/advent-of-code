package aoc.year2024.day17.operators.impl

import aoc.year2024.day17.operators.api.OperatorInput

class Combo  {

    fun process(input: OperatorInput): Long {
        return when (input.operand) {
            0L,1L,2L,3L -> input.operand.toLong()
            4L -> input.registers[0]
            5L -> input.registers[1]
            6L -> input.registers[2]
            else -> throw IllegalArgumentException("Invalid input")
        }
    }

}