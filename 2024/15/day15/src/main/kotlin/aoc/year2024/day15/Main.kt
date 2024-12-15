package aoc.year2024.day15


fun main() {

    val mapLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val sequenceLines = generateSequence(::readLine)
        .takeWhile { it.isNotEmpty() }
        .toList()

    val score1 = executeGame(mapLines, sequenceLines, 1)
    val score2 = executeGame(mapLines, sequenceLines, 2)

    println("Part 1: $score1")
    println("Part 2: $score2")
}

fun executeGame(
    mapLines: List<String>,
    sequenceLines: List<String>,
    scale: Int
): Int {
    val map = parseMap(mapLines, scale)

    val finalBoard = sequenceLines
        .filter { it.isNotEmpty() }
        .flatMap { it.toList() }
        .fold(map) { board, direction ->
            try {
                board.applyMove(direction)
            } catch (_: Board.CantMoveTheBox) {
                board
            }
        }

//    println(getMapString(finalBoard))

    return finalBoard.countScore()

}
