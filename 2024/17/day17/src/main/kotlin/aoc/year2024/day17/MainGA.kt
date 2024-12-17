package aoc.year2024.day17

import aoc.year2024.day17.geneticalgorithm.GeneticAlgorithm
import aoc.year2024.day17.geneticalgorithm.FeatureVectorProcessingStrategy
import kotlin.math.abs
import kotlin.math.max
import kotlin.random.Random


fun main() {

    val strangeDeviceBreakerStrategy = StrangeDeviceBreakerStrategy()

    val result = (1..10)
        .map { _ ->
            val bestFeatureVector = GeneticAlgorithm<Long>().geneticAlgorithm(
                strangeDeviceBreakerStrategy,
                populationSize = 10000,
                generations = 100,
                mutationRate = 0.1
            )
            println("Round feature vector: $bestFeatureVector")
            println("Round fitness score: ${strangeDeviceBreakerStrategy.calculateFitness(bestFeatureVector)}")
            bestFeatureVector
        }
        .filter { bestFeatureVector -> strangeDeviceBreakerStrategy.calculateFitness(bestFeatureVector) == 0.0 }
        .map { bestFeatureVector ->
            bestFeatureVector
        }.
        minBy { it }

    println()
    println("Final feature vector: $result")
    println("Final fitness score: ${strangeDeviceBreakerStrategy.calculateFitness(result)}")
}

class StrangeDeviceBreakerStrategy : FeatureVectorProcessingStrategy<Long> {

    val gaProgram = listOf<Long>(2, 4, 1, 1, 7, 5, 1, 5, 4, 2, 5, 5, 0, 3, 3, 0)
    val expected = gaProgram.toLongArray()

    override fun initializeRandomFeatureVector(): Long {
        return Random.nextLong(1L shl 48)
    }

    override fun calculateFitness(featureVector: Long): Double {
        val actual = blackBoxFunction(featureVector)
        return calculateDistance(actual, expected).toDouble()
    }

    override fun crossover(parent1: Long, parent2: Long): Long {
        val crossoverPoint = Random.nextInt(64)
        val mask = (1L shl crossoverPoint) - 1
        return (parent1 and mask) or (parent2 and mask.inv())
    }

    override fun mutate(featureVector: Long, mutationRate: Double): Long {
        if (Random.nextDouble() < mutationRate) {
            val mutationPoint = Random.nextInt(64)
            return featureVector xor (1L shl mutationPoint)
        }
        return featureVector
    }

    fun calculateDistance(actual: LongArray, expected: LongArray): Double {
        return (0 until max(actual.size, expected.size))
            .map { i -> if (i < actual.size && i < expected.size) actual[i] - expected[i] else 10 }
            .sumOf { abs(it) }
            .toDouble()
    }

    fun blackBoxFunction(featureVector: Long): LongArray {
        return runWithA(featureVector, gaProgram).toLongArray()
    }
}