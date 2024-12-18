package aoc.year2024.day18.utils.structures

data class Point(val x: Int, val y: Int) {
    fun moveBy(dx: Int, dy: Int): Point {
        return Point(this.x + dx, this.y + dy)
    }
}
