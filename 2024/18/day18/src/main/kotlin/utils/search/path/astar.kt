package aoc.year2024.day18.utils.search.path

import aoc.year2024.day18.utils.structures.Point
import java.util.*

data class Node(
    val point: Point,
    val gCost: Double = 0.0,
    val hCost: Double = 0.0,
    val parent: Node? = null,
) {
    val fCost get() = gCost + hCost
    override fun toString(): String = "(${point.x}, ${point.y})"
}

fun aStar(gridProvider: GridProvider, start: Point, goal: Point): Node? {
    val openSet = PriorityQueue<Node> { n1, n2 -> n1.fCost.compareTo(n2.fCost) }
    val closedSet = mutableSetOf<Node>()

    val startNode = Node(start, 0.0, 0.0, null)
    openSet.add(startNode)

    while (openSet.isNotEmpty()) {
        val current = openSet.poll()
        closedSet.add(current)

        if (current.point == goal) {
            return current;
        }

        for (neighboring in gridProvider.getNeighbors(current.point)) {

            if (closedSet.any { it.point == neighboring }) {
                continue
            }

            val cost = gridProvider.getCost(neighboring, current.point)
            val newGCost =  current.gCost + cost

            val neighbor = Node(neighboring, newGCost, gridProvider.getHeuristic(neighboring, goal), current)

            if (!openSet.any { it.point ==  neighboring } || newGCost < neighbor.gCost) {
                openSet.add(neighbor)
            }
        }
    }

    return null
}

fun reconstructPath(goal: Node): List<Node> {
    val path = mutableListOf<Node>()
    var current: Node? = goal

    while (current != null) {
        path.add(current)
        current = current.parent
    }

    return path.reversed()
}

interface GridProvider {
    fun getNeighbors(current: Point): List<Point>
    fun getCost(p1: Point, p2: Point): Double
    fun getHeuristic(p1: Point, p2: Point): Double
}
