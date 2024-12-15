package aoc.year2024.day15


fun main() {

    val mapLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val sequenceLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val finalMap = sequenceLines
        .filter { it.isNotEmpty() }
        .flatMap { it.toList() }
        .fold(mapLines) { board, direction -> move(board, direction) }

    println(finalMap.joinToString("\n"))

    val score = countScore(finalMap)

    println(score)

}

fun countScore(map: List<String>): Int {
    return map.flatMapIndexed { y, line ->
        line.mapIndexed { x, c -> if (c == 'O') y * 100 + x else 0 }
    }.sum()
}
