package aoc.year2024.day20

import dev.skirmishhaversack.utils.execution.wrapWithMetrics
import dev.skirmishhaversack.utils.io.readAllLines

fun main() {
    val inputLines = readAllLines()
    wrapWithMetrics("Part 1", inputLines, ::executePart1)
}

fun executePart1(lines: List<String>): String {
    return executeCommon(lines, 2)
}
