package aoc.year2024.day17

import aoc.year2024.day17.operators.api.OperatorInput
import aoc.year2024.day17.operators.api.StrangeMachineOperator
import aoc.year2024.day17.operators.impl.Adv
import aoc.year2024.day17.operators.impl.Bdv
import aoc.year2024.day17.operators.impl.Bst
import aoc.year2024.day17.operators.impl.Bxc
import aoc.year2024.day17.operators.impl.Bxl
import aoc.year2024.day17.operators.impl.Cdv
import aoc.year2024.day17.operators.impl.Jnz
import aoc.year2024.day17.operators.impl.Out

val operators: List<StrangeMachineOperator> = listOf(
    Adv(),
    Bxl(),
    Bst(),
    Jnz(),
    Bxc(),
    Out(),
    Bdv(),
    Cdv()
)

fun runWithA(a: Long, program: List<Long>): List<Long> {
    return executeProgram(program, mutableListOf<Long>(a, 0, 0))
}

fun executeProgram(
    program: List<Long>,
    inputRegisters: List<Long>
): List<Long> {
    var pointer: Int = 0
    var registers = inputRegisters.toMutableList()
    var programOutput = mutableListOf<Long>()

    while (pointer < program.size) {
        val opcode = program[pointer]
        val operand = program[pointer + 1]
        val operator = operators[opcode.toInt()]
        val input = OperatorInput(operand, registers)

        val result = operator.process(input)

        if (result.register != null) {
            val register: Int = result.register!!
            registers[register] = result.value!!
        }

        if (result.output != null) {
            programOutput.add(result.output!!)
        }

        if (result.jump != null) {
            pointer = result.jump!!.toInt()
        } else {
            pointer += 2;
        }

    }
    return programOutput.toList()
}
