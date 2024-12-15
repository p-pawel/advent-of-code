package aoc.year2024.day15


fun scanRight(
    map: List<String>,
    location: Point
): String {
    return map[location.y].substring(location.x + 1)
}

fun scanLeft(
    map: List<String>,
    location: Point
): String {
    return map[location.y].substring(0, location.x).reversed()
}

fun scanDown(
    map: List<String>,
    location: Point
): String {
    return map
        .filterIndexed { y, line -> y > location.y }
        .map { line -> line[location.x] }
        .joinToString(separator = "")
}

fun scanUp(
    map: List<String>,
    location: Point
): String {
    return map
        .filterIndexed { y, line -> y < location.y }
        .map { line -> line[location.x] }
        .joinToString(separator = "")
        .reversed()
}
