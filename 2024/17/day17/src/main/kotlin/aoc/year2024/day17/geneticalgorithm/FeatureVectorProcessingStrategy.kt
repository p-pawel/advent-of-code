package aoc.year2024.day17.geneticalgorithm

// TODO refactor to strategies wrapper with functions?
interface FeatureVectorProcessingStrategy<FEATURE> {
    fun initializeRandomFeatureVector(): FEATURE
    fun calculateFitness(unit: FEATURE): Double
    fun crossover(parent1: FEATURE, parent2: FEATURE): FEATURE
    fun mutate(unit: FEATURE, d: Double): FEATURE
}