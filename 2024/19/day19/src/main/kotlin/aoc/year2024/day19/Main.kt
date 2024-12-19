package aoc.year2024.day19

fun main() {

    val patterns = readln().split(", ").sorted()
    readln()

    val designs = generateSequence(::readlnOrNull)
        .takeWhile { it.isEmpty().not() }
        .toList()

    designs.count { isPossible(it, patterns) }
        .also { println("Part 1: $it") }

    designs.sumOf { countPossible(it, patterns) }
        .also { println("Part 2: $it") }

}

