package aoc.year2024.day17.operators.api

data class OperatorInput(val operand: Long, val registers: List<Long>)

data class OperatorOutput(val register: Int?, val value: Long?, val jump: Long?, val output: Long?)