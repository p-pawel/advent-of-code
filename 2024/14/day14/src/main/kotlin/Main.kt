package aoc.year2024

import java.util.*

private const val PART_1_MOVES = 100
private const val BOARD_WIDTH = 101
private const val BOARD_HEIGHT = 103

fun main() {
    val scanner = Scanner(System.`in`)
    val robots = readRobots(scanner)
    scanner.close()

    val board = Vector(BOARD_WIDTH, BOARD_HEIGHT)

    val quadrantCounts = robots
        .map { robot -> Robot((robot.p + robot.v * PART_1_MOVES) % board, robot.v) }
        .mapNotNull { robot -> calcQuadrant(robot, board) }
        .groupingBy { it }
        .eachCount()
        .map { it.value.toLong() }
        .reduce { acc, i -> acc * i }

    val searchResult = findATree(robots, board)

    printRobots(searchResult.leastDeviatedRobots, board)
    println("Part 1: $quadrantCounts")
    println("Part 2: ${searchResult.counter}")
}


private fun calcQuadrant(robot: Robot, board: Vector): Int? {
    if (robot.p.x == board.x / 2 || robot.p.y == board.y / 2) {
        return null;
    }
    return when (robot.p.x < board.x / 2) {
        true -> if (robot.p.y < board.y / 2) 0 else 2
        false -> if (robot.p.y < board.y / 2) 1 else 3
    }
}
