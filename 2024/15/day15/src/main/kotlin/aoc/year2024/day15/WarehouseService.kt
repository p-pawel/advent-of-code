package aoc.year2024.day15

;


class CantMoveTheBox(message: String) : Exception(message)

fun move(board: Board, direction: Char): Board {
    val nextRobotLocation = board.robot.move(direction)

    return when (board.getSpriteAt(nextRobotLocation)) {
        Sprite.WALL -> board
        Sprite.EMPTY -> board.withRobotAt(nextRobotLocation)
        Sprite.ROBOT -> error("there can't be a robot")
        Sprite.BOX -> {
            try {
                val updatedBoxes = tryToPushTheBox(board, nextRobotLocation, direction)
                return updatedBoxes.withRobotAt(nextRobotLocation)
            } catch (e: CantMoveTheBox) {
                board
            }
        }
    }
}

fun tryToPushTheBox(board: Board, location: Point, direction: Char): Board {
    val nextLocation = location.move(direction)

    return when (board.getSpriteAt(nextLocation)) {
        Sprite.WALL -> throw CantMoveTheBox("Wall")
        Sprite.EMPTY -> board.withMovedBox(location, direction)
        Sprite.ROBOT -> error("there can't be a robot")
        Sprite.BOX -> {
            val nextBoard = tryToPushTheBox(board, nextLocation, direction)
            nextBoard.withMovedBox(location, direction)
        }
    }

}

