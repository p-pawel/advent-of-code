package aoc.year2024.day14

data class Robot(val p: Vector, val v: Vector)

data class Vector(val x: Int, val y: Int) {

    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }

    operator fun times(mul: Int): Vector {
        return Vector(x * mul, y * mul)
    }

    operator fun rem(vector: Vector): Vector {
        return Vector(
            (x % vector.x + vector.x) % vector.x,
            (y % vector.y + vector.y) % vector.y
        )
    }
}

data class VectorDouble(val x: Double, val y: Double) {

    operator fun plus(other: VectorDouble): VectorDouble {
        return VectorDouble(x + other.x, y + other.y)
    }

    operator fun times(mul: Int): VectorDouble {
        return VectorDouble(x * mul, y * mul)
    }

    operator fun div(d: Double): VectorDouble {
        return VectorDouble(x / d, y / d)
    }

    operator fun rem(vector: VectorDouble): VectorDouble {
        return VectorDouble(
            (x % vector.x + vector.x) % vector.x,
            (y % vector.y + vector.y) % vector.y
        )
    }
}
