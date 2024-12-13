package aoc.year2024.day13
import org.apache.commons.math3.linear.*
import kotlin.math.abs
import kotlin.math.roundToLong


fun resolve2(jumpA: Vector, jumpB: Vector, goal: Vector): Result? {

    val coefficients: RealMatrix =
        Array2DRowRealMatrix(
            arrayOf(
                doubleArrayOf(jumpA.x.toDouble(), jumpB.x.toDouble()),
                doubleArrayOf(jumpA.y.toDouble(), jumpB.y.toDouble()),
            ),
            false
        )
    val solver = LUDecomposition(coefficients).solver

    val constants: RealVector = ArrayRealVector(
        doubleArrayOf(goal.x.toDouble(), goal.y.toDouble()),
        false
    )
    val solution = solver.solve(constants)

    return if (isNearlyInteger(solution.getEntry(0)) && isNearlyInteger(solution.getEntry(1))) {
        Result(solution.getEntry(0).roundToLong(), solution.getEntry(1).roundToLong())
    } else {
        null;
    }
}


fun isNearlyInteger(value: Double): Boolean {
    val epsilon = 1e-4 // Define a small threshold
    return abs(value - value.roundToLong()) < epsilon
}