package aoc.year2024.day13

fun main() {

    val inputString = generateSequence(::readLine).joinToString("\n")

    val games1 = parseInput(inputString, 0);
    val games2 = parseInput(inputString, 10000000000000);

    val result1 = games1
        .mapNotNull { resolve2(it.a, it.b, it.target) }
        .sumOf { it.cost() }
    println("Part 1: $result1")

    val result2 = games2
        .mapNotNull { resolve2(it.a, it.b, it.target) }
        .sumOf { it.cost() }
    println("Part 2: $result2")


}

data class Vector(val x: Long, val y: Long) {
    operator fun plus(that: Vector): Vector {
        return Vector(x + that.x, y + that.y)
    }

    operator fun times(m: Int): Vector {
        return Vector(x * m, y * m)
    }

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }


}


data class Game(val a: Vector, val b: Vector, val target: Vector)

data class Result(val a: Long, val b: Long) {

    private val costA: Int = 3;
    private val costB: Int = 1;

    fun cost(): Long {
        return a * costA + b * costB;
    }
}
