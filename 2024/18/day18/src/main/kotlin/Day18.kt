package aoc.year2024.day18

import aoc.year2024.day18.utils.structures.CharMap2D
import aoc.year2024.day18.utils.search.path.CharMapNodeProvider
import aoc.year2024.day18.utils.search.path.aStar
import aoc.year2024.day18.utils.search.path.reconstructPath
import aoc.year2024.day18.utils.search.array.binarySearch
import aoc.year2024.day18.utils.structures.Point

fun main() {

    val lines = generateSequence {
        readlnOrNull()
    }.toList()

    val input = lines.map { it.split(",") }.map { Point(it[0].toInt(), it[1].toInt()) }.toList()

    // note: there are a different rules for sample and test datasets (we can tell the variant by the map size)
    val (size, taken) = if (input.any { it.x > 6 || it.y > 6 }) Pair(71, 1024) else Pair(7,12)

    var charMap = CharMap2D(size, size, '.')
    input.take(taken).forEach { p ->
        charMap = charMap.changePoint(p, '#')
    }

    val steps = part1(charMap)
    println("Part 1: $steps")

    val part2point = part2(charMap, input.drop(taken))
    println("Part 2: ${part2point.x},${part2point.y}")
}

private fun part1(charMap: CharMap2D): Int {
    val start = Point(0, 0)
    val end = Point(charMap.width - 1, charMap.height - 1)
    val goal = aStar(CharMapNodeProvider(charMap, '#'), start, end)!!
    val steps = reconstructPath(goal).size - 1
    return steps
}

private fun part2(
    initialMap: CharMap2D,
    nextInputs: List<Point>
): Point {

    val start = Point(0, 0)
    val end = Point(initialMap.width - 1, initialMap.height - 1)

    val i: Int? = binarySearch(0 until nextInputs.size) { i ->
        val modifiedMap = initialMap.changePoints(nextInputs.take(i + 1), '#')
        val goal = aStar(CharMapNodeProvider(modifiedMap, '#'), start, end)
        goal == null
    }
    return nextInputs[i!!]
}

