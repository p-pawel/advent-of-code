package aoc.year2024.day15


fun parseMap(strings: List<String>, scaleX: Int): Board {

    val sprites: List<Sprite> = strings
        .mapIndexed { y, line ->
            line
                .mapIndexed { x, char -> parseToSprite(x, y, char, scaleX) }
                .flatMap { it }
        }
        .flatMap { it }
        .toList()

    return Board(
        strings[0].length * scaleX,
        strings.size,
        sprites
    )
}

private fun parseToSprite(
    x: Int,
    y: Int,
    char: Char,
    scaleX: Int
): List<Sprite> {
    val id = "${char}-${x}-${y}"
    return when (char) {
        '@' -> listOf(Sprite(id, SpriteType.ROBOT, Point(x * scaleX, y)))

        '#' -> {
            if (scaleX == 1) {
                listOf(Sprite(id, SpriteType.WALL, Point(x * scaleX, y)))
            } else {
                listOf(
                    Sprite(id, SpriteType.WALL, Point(x * scaleX, y)),
                    Sprite("$id-2", SpriteType.WALL, Point(x * scaleX + 1, y))
                )
            }
        }

        'O' -> {
            val spriteType = if (scaleX == 1) SpriteType.BOX else SpriteType.BIG_BOX
            listOf(Sprite(id, spriteType, Point(x * scaleX, y)))
        }

        else -> emptyList()
    }
}


fun getMapString(board: Board): String {

    val output = mutableMapOf<Pair<Int, Int>, String>();

    board.sprites.forEach { sprite ->
        output[Pair(sprite.location.x, sprite.location.y)] = sprite.type.icon
    }
    val b = StringBuilder()
    for (y in 0 until board.height) {
        var x = 0;
        while (x < board.width) {
            val icon = output.getOrDefault(x to y, ".")
            b.append(icon)
            x += icon.length;
        }
        b.append('\n')
    }
    return b.toString();
}
