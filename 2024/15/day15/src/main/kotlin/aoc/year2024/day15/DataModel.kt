package aoc.year2024.day15


data class Point(val x: Int, val y: Int) {
    fun move(direction: Char): Point {
        return when (direction) {
            '>' -> Point(this.x + 1, this.y)
            '<' -> Point(this.x - 1, this.y)
            '^' -> Point(this.x, this.y - 1)
            'v' -> Point(this.x, this.y + 1)
            else -> error("Unexpected direction")
        }
    }
}

enum class SpriteType(val icon: String, val moveable: Boolean, val width: Int, val height: Int) {
    ROBOT("@", false, 1, 1),
    BOX("O", true, 1, 1),
    BIG_BOX("[]", true, 2, 1),
    WALL("#", false, 1, 1)
}


data class Sprite(
    val id: String,
    val type: SpriteType,
    val location: Point,
) {
    fun move(direction: Char): Sprite {
        return Sprite(id, type, location.move(direction))
    }

    fun doesCollideWith(sprite: Sprite): Boolean {
        return sprite.getBounds().collidesWith(this.getBounds())
    }

    private fun getBounds(): Rect {
        return Rect(Point(location.x, location.y), Point(location.x + type.width-1, location.y + type.height-1))
    }
}

data class Rect(val p1: Point, val p2: Point) {
    fun collidesWith(rect: Rect): Boolean {
        val res = !(p2.x < rect.p1.x ||
                rect.p2.x < p1.x ||
                p2.y < rect.p1.y ||
                rect.p2.y < p1.y)
        return res
    }
}

data class Board(
    val width: Int,
    val height: Int,
    val sprites: List<Sprite>,
) {

    fun withMovedSprite(sprite: Sprite, direction: Char): Board {
        val sprites = this.sprites.map {
            when (it.id) {
                sprite.id -> it.move(direction)
                else -> it
            }
        }
        return Board(width, height, sprites)
    }


    fun countScore(): Int {
        return this.sprites
            .filter { it.type == SpriteType.BOX ||  it.type == SpriteType.BIG_BOX }
            .map { it.location }
            .sumOf { point -> point.y * 100 + point.x }
    }

    fun applyMove(direction: Char): Board {

        val board = this
        val robot = board.getRobot()
        val colliding = this.findAllCollisionsWith(robot.move(direction))

        if (colliding.any { it.type == SpriteType.WALL }) {
            return board;
        }

        if (colliding.isEmpty()) {
            return board.withMovedSprite(robot, direction)
        }

        // TODO can we assume it's a box?
        var collidingBox = colliding.first()
        return board
            .tryToPushTheBox(collidingBox, direction)
            .withMovedSprite(robot, direction)

    }

    fun tryToPushTheBox(sprite: Sprite, direction: Char): Board {

        val board = this;
        val movedSprite = sprite.move(direction)
        val colliding = this.findAllCollisionsWith(movedSprite)

        if (colliding.any { it.type == SpriteType.WALL }) {
            throw CantMoveTheBox("Wall")
        }

        if (colliding.isEmpty())  {
            return board.withMovedSprite(sprite, direction)
        }

        return colliding
            .fold(board) { updatedBoard, collidingBox -> updatedBoard.tryToPushTheBox(collidingBox, direction)}
            .withMovedSprite(sprite, direction)
    }

    private fun getRobot(): Sprite {
        return this.sprites
            .first { it.type == SpriteType.ROBOT }
    }

    private fun findAllCollisionsWith(sprite: Sprite): List<Sprite> {
        return this.sprites
            .filter { it.id != sprite.id }
            .filter { it.doesCollideWith(sprite) }
    }

    class CantMoveTheBox(message: String) : Exception(message)

}
