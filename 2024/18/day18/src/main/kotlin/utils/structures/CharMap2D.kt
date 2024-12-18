package aoc.year2024.day18.utils.structures


class CharMap2D(val mapLines: List<String>) {

    val width = mapLines[0].length
    val height = mapLines.size

    constructor(width: Int, height: Int, ch: Char) : this(
        (0 until height).map {
            (0 until width).map { ch }.joinToString("")
        }
    )

    fun changePoint(point: Point, ch: Char): CharMap2D {

        val newMapLines = mapLines.mapIndexed { y, line: String ->
            when {
                y != point.y -> line
                else -> line.substring(0, point.x) + ch + line.substring(point.x + 1)
            }
        }
        return CharMap2D(newMapLines)
    }

    fun changePoints(points: List<Point>, ch: Char): CharMap2D {
        return points.fold(this) { map, input -> map.changePoint(input, '#') }
    }

    override fun toString(): String {
        return mapLines.joinToString("\n")
    }

    fun charAt(p: Point): Char {
        return this.mapLines[p.y].toCharArray()[p.x];
    }

    fun isWithin(p: Point): Boolean {
        return (p.x >= 0 && p.x < width && p.y >= 0 && p.y < height)
    }


}