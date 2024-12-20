package aoc.year2024.day20

import dev.skirmishhaversack.utils.execution.wrapWithMetrics
import dev.skirmishhaversack.utils.io.readAllLines

fun main() {
    val inputLines = readAllLines()
    wrapWithMetrics("Part 2", inputLines, ::executePart2)
}

fun executePart2(lines: List<String>): String {
    return executeCommon(lines, 20)
}
