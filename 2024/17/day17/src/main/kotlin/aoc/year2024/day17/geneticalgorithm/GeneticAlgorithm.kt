package aoc.year2024.day17.geneticalgorithm

class GeneticAlgorithm<FEATURE> {

    fun geneticAlgorithm(
        template: FeatureVectorProcessingStrategy<FEATURE>,
        populationSize: Int = 10000,
        generations: Int = 100,
        mutationRate: Double = 0.01
    ): FEATURE {

        val initialPopulation = List(populationSize) { template.initializeRandomFeatureVector() }

        val finalPopulation = (1..generations).fold(initialPopulation) { population, _ ->

            val elites = population
                .map { it to template.calculateFitness(it) }
                .sortedBy { it.second }
                .take(populationSize / 10).map { it.first }

            (1..populationSize)
                .map { Pair(elites.random(), elites.random()) }
                .map { template.crossover(it.first, it.second) }
                .map { template.mutate(it, mutationRate) }
                .toList()
        }

        return finalPopulation.minBy { template.calculateFitness(it) }
    }

}