package aoc.year2024.day16

import GridProvider
import Point
import aStarModified
import reconstructPath
import kotlin.math.abs

private const val ROTATE_COST = 1000.0

fun main() {

    val mapLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val start = locateItem(mapLines, 'S')
    val goal = locateItem(mapLines, 'E')

    val goals = aStarModified(OlympicsGridProvider(mapLines), start, goal)
    val paths = goals.map { goal -> reconstructPath(goal) }

    val cost = paths
        .first()
        .let { path -> if (path[1].point.y != path[0].point.y) path.last().gCost + ROTATE_COST else path.last().gCost } // add initial rotate if needed

    val seats = paths
        .flatMap { it }
        .map { Point(it.point.x, it.point.y) }
        .distinct()

    println("Part 1: ${cost.toLong()}")
    println("Part 2: ${seats.size}")

}

fun locateItem(strings: List<String>, item: Char): Point {
    strings.forEachIndexed { y, line ->
        for (x in line.indices) {
            if (line[x] == item) {
                // assuming there's only one such
                return Point(x, y)
            }
        }
    }
    error("no item found")
}

class OlympicsGridProvider(val map: List<String>) : GridProvider {

    val height = map.size
    val width = map[0].length


    private fun getPoint(x: Int, y: Int): Char {
        return this.map[y].toCharArray()[x];
    }

    override fun getNeighbors(current: Point): List<Point> {
        return listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
            .map { (x, y) -> (current.x + x) to (current.y + y) }
            .filter { (neighborX, neighborY) -> (neighborX >= 0 && neighborX < width && neighborY >= 0 && neighborY < height) }
            .filter { (neighborX, neighborY) -> getPoint(neighborX, neighborY) != '#' }
            .map { (neighborX, neighborY) -> Point(neighborX, neighborY) }
    }

    override fun getCost(p1: Point, p2: Point, previous: Point?): Double {

        val additionalTurnCost = if (previous != null && !areNodesStraight(
                Point(previous.x, previous.y),
                p1
            )
        ) 1000.0 else 0.0

        return manhattanDistance(p1, p2) + additionalTurnCost

    }

    override fun getHeuristic(p1: Point, p2: Point): Double {
        return manhattanDistance(p1, p2)
    }

}

fun manhattanDistance(start: Point, goal: Point): Double {
    return abs(start.x - goal.x).toDouble() + abs(start.y - goal.y).toDouble()
}

fun areNodesStraight(node1: Point, node2: Point): Boolean {
    return node1.x == node2.x || node1.y == node2.y
}