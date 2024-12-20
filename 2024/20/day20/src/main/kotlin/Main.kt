package aoc.year2024.day20

import dev.skirmishhaversack.utils.execution.wrapWithMetrics
import dev.skirmishhaversack.utils.io.readAllLines

fun main() {
    val lines = readAllLines()
    wrapWithMetrics("Part 1", lines, ::executePart1)
    wrapWithMetrics("Part 2", lines, ::executePart2)
}