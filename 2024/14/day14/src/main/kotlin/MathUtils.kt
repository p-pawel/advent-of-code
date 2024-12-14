package aoc.year2024

import kotlin.math.pow
import kotlin.math.sqrt

fun List<Double>.stdDev(): Double {
    val mean: Double = this.sum() / this.size
    return sqrt(this.sumOf { (it - mean).pow(2) } / this.size)
}
