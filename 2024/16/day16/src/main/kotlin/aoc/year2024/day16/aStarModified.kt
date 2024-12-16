data class Point(val x: Int, val y: Int)

data class Node(
    val point: Point,
    val gCost: Double = 0.0,
    val hCost: Double = 0.0,
    val parent: Node? = null,
) {
    override fun toString(): String = "(${point.x}, ${point.y})"
}

fun aStarModified(gridProvider: GridProvider, start: Point, goal: Point): List<Node> {
    val openSet = mutableListOf<Node>()
    val closedSet = mutableSetOf<Node>()

    val startNode = Node(start)
    openSet.add(startNode)

    val reachedGoals = mutableListOf<Node>()
    var bestAtGoal: Double? = null
    val bestAtPoint = mutableMapOf<Point, Double>()

    while (openSet.isNotEmpty()) {
        val current = openSet.first()
        openSet.remove(current)
        closedSet.add(current)

        if (bestAtPoint[current.point] == null || current.gCost < bestAtPoint[current.point]!!) {
            bestAtPoint[current.point] = current.gCost
        }

        if (current.point == goal) {

            if (bestAtGoal == null || current.gCost == bestAtGoal) {
                 reachedGoals.add(current)
            }
            if (bestAtGoal == null || current.gCost < bestAtGoal) {
                bestAtGoal = current.gCost
                reachedGoals.removeIf { it.gCost > current.gCost }
            }
            continue
        }

        if (bestAtGoal != null && current.gCost > bestAtGoal) {
            continue
        }

        for (neighboring in gridProvider.getNeighbors(current.point)) {

            if (wasHere(current.parent, neighboring)) {
                continue
            }

            val newGCost =  current.gCost + gridProvider.getCost(neighboring, current.point, current.parent?.point)

            val neighbor = Node(neighboring, newGCost, gridProvider.getHeuristic(neighboring, goal), current)

            val gScoreAtNew = bestAtPoint[neighboring]
            if (gScoreAtNew == null || newGCost <= gScoreAtNew) {
                openSet.add(neighbor)
            }
        }
    }

    return reachedGoals
}

fun wasHere(node: Node?, point: Point): Boolean {
    if (node == null) return false;
    if (node.point.x == point.x && node.point.y == point.y) return true;
    return wasHere(node.parent, point);
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
    fun getCost(p1: Point, p2: Point, previous: Point?): Double
    fun getHeuristic(p1: Point, p2: Point): Double
}
