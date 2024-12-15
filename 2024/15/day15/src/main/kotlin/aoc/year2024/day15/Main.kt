package aoc.year2024.day15


fun main() {

    val mapLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val sequenceLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val map = parseMap(mapLines)

    val finalBoard = sequenceLines
        .filter { it.isNotEmpty() }
        .flatMap { it.toList() }
        .fold(map) { board, direction -> move(board, direction) }

    println(finalBoard.getMapString())

    val score = finalBoard.countScore()

    println(score)
}

fun parseMap(strings: List<String>): Board {

    var robot: Point? = null
    var walls: MutableList<Point> = mutableListOf<Point>()
    var boxes: MutableList<Point> = mutableListOf<Point>()

    strings.forEachIndexed { y, line ->
        for (x in line.indices) {
            when (line[x]) {
                '@' -> robot = Point(x, y)
                '#' -> walls.add(Point(x, y))
                'O' -> boxes.add(Point(x, y))
            }
        }
    }

    return Board(
        strings[0].length,
        strings.size,
        robot!!,
        walls,
        boxes
    )
}

