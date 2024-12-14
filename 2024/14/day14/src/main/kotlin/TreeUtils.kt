package aoc.year2024


data class TreeSearchAccumulator(
    val lastRobots: List<Robot>,
    val leastDeviatedRobots: List<Robot>,
    val minStdDev: Double?,
    val counter: Int
)

fun findATree(robots: List<Robot>, board: Vector): TreeSearchAccumulator {

    val leastDeviated = (0..(board.x * board.y))
        .fold(TreeSearchAccumulator(robots, emptyList(), null, 0)) { it, i ->

            var points: List<Vector> = it.lastRobots.map { it.p }
            var stdDevX = points.map { it.x.toDouble() }.stdDev()
            var stdDevY = points.map { it.y.toDouble() }.stdDev()

            val newMinStdFound = it.minStdDev == null || (stdDevX + stdDevY) < it.minStdDev


            TreeSearchAccumulator(
                it.lastRobots.map { robot -> Robot((robot.p + robot.v) % board, robot.v) },
                if (newMinStdFound) it.lastRobots else it.leastDeviatedRobots,
                if (newMinStdFound) stdDevX + stdDevY else it.minStdDev,
                if (newMinStdFound) i else it.counter
            )

        }

    return leastDeviated;
}

fun printRobots(robots: List<Robot>, board: Vector) {

    val grid = mutableMapOf<Vector, Char>()

    (0 until board.x).forEach { y ->
        (0 until board.y).forEach { x ->
            grid[Vector(x, y)] = '.'
        }
    }

    robots.forEach { robot ->
        grid[robot.p] = '*'
    }

    (0 until board.x).forEach { y ->
        (0 until board.y).forEach { x ->
            print(grid[Vector(x, y)])
        }
        println()
    }
}
