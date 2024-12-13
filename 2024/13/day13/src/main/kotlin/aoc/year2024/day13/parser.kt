package aoc.year2024.day13

fun parseInput(input: String, prizeOffset: Long): List<Game> {
    val regex = Regex("""Button A:\s*X\+(\d+),\s*Y\+(\d+)\nButton B:\s*X\+(\d+),\s*Y\+(\d+)\nPrize:\s*X=(\d+),\s*Y=(\d+)""")
    val matches = regex.findAll(input)

    return matches.map { match ->
        val buttonAX = match.groups[1]!!.value.toLong()
        val buttonAY = match.groups[2]!!.value.toLong()
        val buttonBX = match.groups[3]!!.value.toLong()
        val buttonBY = match.groups[4]!!.value.toLong()
        val prizeX = match.groups[5]!!.value.toLong() + prizeOffset
        val prizeY = match.groups[6]!!.value.toLong()+ prizeOffset

        Game(Vector(buttonAX, buttonAY), Vector(buttonBX, buttonBY), Vector(prizeX, prizeY))
    }.toList()
}