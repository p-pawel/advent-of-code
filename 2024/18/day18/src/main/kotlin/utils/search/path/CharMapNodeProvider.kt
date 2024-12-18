package aoc.year2024.day18.utils.search.path

import aoc.year2024.day18.utils.structures.CharMap2D
import aoc.year2024.day18.utils.structures.Point
import kotlin.math.abs

class CharMapNodeProvider(val map: CharMap2D, val obstacle: Char) : GridProvider {

    override fun getNeighbors(current: Point): List<Point> {
        return listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
            .map { (x, y) -> current.moveBy(x, y) }
            .filter { map.isWithin(it) }
            .filter { map.charAt(it) != obstacle }
    }

    override fun getCost(
        p1: Point,
        p2: Point
    ): Double {
        return manhattanDistance(p1, p2)
    }

    override fun getHeuristic(
        p1: Point,
        p2: Point
    ): Double {
        return manhattanDistance(p1, p2)
    }

}

private fun manhattanDistance(start: Point, goal: Point): Double {
    return abs(start.x - goal.x).toDouble() + abs(start.y - goal.y).toDouble()
}