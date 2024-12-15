package aoc.year2024.day15

data class Point(val x: Int, val y: Int) {
    fun move(direction: Char): Point {
        return when (direction) {
            '>' -> Point(this.x + 1, this.y)
            '<' -> Point(this.x - 1, this.y)
            '^' -> Point(this.x, this.y - 1)
            'v' -> Point(this.x, this.y + 1)
            else -> error("Unexpected direction")
        }    }
}


enum class Sprite { ROBOT, BOX, WALL, EMPTY }

data class Board(
    val width: Int,
    val height: Int,
    val robot: Point,
    val walls: List<Point>,
    val boxes: List<Point>
) {
    fun isWallAt(point: Point): Boolean {
        return this.walls.contains(point)
    }

    fun isBoxAt(point: Point): Boolean {
        return this.boxes.contains(point)
    }

    fun withRobotAt(newRobot: Point): Board {
        return Board(width, height, newRobot, walls, boxes)
    }

    fun withMovedBox(location: Point, direction: Char): Board {
        val boxes =  this.boxes.map {
            when (it) {
                location -> location.move(direction)
                else -> it

            }
        }
        return Board(width, height, robot, walls, boxes)
    }

    fun getSpriteAt(point: Point): Sprite {

        if (point == this.robot) {
            return Sprite.ROBOT;
        }

        if (this.isWallAt(point)) {
            return Sprite.WALL;
        }

        if (this.isBoxAt(point)) {
            return Sprite.BOX;
        }

        return Sprite.EMPTY;
    }

    fun getMapString(): String {
        val b = StringBuilder()
        for (y in 0 until height) {
            for (x in 0 until width) {
                b.append(
                    when (getSpriteAt(Point(x, y))) {
                        Sprite.ROBOT -> '@'
                        Sprite.WALL -> '#'
                        Sprite.BOX -> 'O'
                        Sprite.EMPTY -> '.'
                    }
                )
            }
            b.append('\n')
        }
        return b.toString();
    }

    fun countScore(): Int {
        return this.boxes
            .sumOf { point -> point.y * 100 + point.x }
    }

}
