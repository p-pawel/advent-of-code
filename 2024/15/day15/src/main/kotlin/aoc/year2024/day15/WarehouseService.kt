package aoc.year2024.day15

data class Point(val x: Int, val y: Int);

fun move(lines: List<String>, direction: Char): List<String> {
    val robot: Point = locateRobot(lines)
    val jobToDo = useRadar(lines, robot, direction)
    val jobDone = moveTheLine(jobToDo)
    return when (jobDone[0]) {
        '.' -> {
            val newRobot = moveRobot(robot, direction)
            val newLines = listOf(lines)
                .map { lines -> applyChange(lines, robot, direction, jobDone) }
                .map { lines -> changePoint(lines, robot, '.') }
                .map { lines -> changePoint(lines, newRobot, '@') }
                .first();

            newLines
        }

        else -> lines
    }
}

fun applyChange(
    map: List<String>,
    location: Point,
    direction: Char,
    payload: String
): List<String> {
    var newLocation = location;
    var newMap = map;
    for (i in 0..payload.length - 1) {
        newLocation = moveRobot(newLocation, direction);
        newMap = changePoint(newMap, newLocation, payload[i])


    }
    return newMap
}

private fun moveRobot(point: Point, direction: Char): Point {
    return when (direction) {
        '>' -> Point(point.x + 1, point.y)
        '<' -> Point(point.x - 1, point.y)
        '^' -> Point(point.x, point.y - 1)
        'v' -> Point(point.x, point.y + 1)
        else -> error("Unexpected direction")
    }
}

private fun useRadar(
    mapLines: List<String>,
    currentPoint: Point,
    direction: Char
): String {
    return when (direction) {
        '>' -> scanRight(mapLines, currentPoint)
        '<' -> scanLeft(mapLines, currentPoint)
        '^' -> scanUp(mapLines, currentPoint)
        'v' -> scanDown(mapLines, currentPoint)
        else -> error("Unexpected direction")
    }
}

private fun changePoint(
    strings: List<String>,
    point: Point,
    ch: Char
): List<String> {
    return strings.mapIndexed { y, line: String ->
        when {
            y != point.y -> line
            else -> line.substring(0, point.x) + ch + line.substring(point.x + 1)
        }
    }
}

private fun locateRobot(strings: List<String>): Point {
    strings.forEachIndexed { y, line ->
        for (x in line.indices) {
            if (line[x] == '@') {
                return Point(x, y)
            }
        }
    }
    error("no robot found")
}
