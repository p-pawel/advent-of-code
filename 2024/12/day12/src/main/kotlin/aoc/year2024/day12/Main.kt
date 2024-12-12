package aoc.year2024.day12


fun main() {

    val lines = generateSequence {
        readlnOrNull()?.takeIf { it.isNotEmpty() }
    }.toList()

    val gardenPlots = lines.flatMapIndexed() { y, row ->
        row.mapIndexed { x, plant ->
            GardenPlot(x, y, plant)
        }
    }

    val gardenState = gardenPlots.fold(GardenState()) { currentRepository, point ->
        currentRepository.addPlot(point)
    }

    println("Part 1: ${calcPrice1(gardenState)}")
    println("Part 2: ${calcPrice2(gardenState)}")
}

private fun calcPrice1(gardenState: GardenState): Int {
    return gardenState.clusters
        .sumOf { cluster -> cluster.getArea() * cluster.getPerimeter() }
}

private fun calcPrice2(gardenState: GardenState): Int {
    return gardenState.clusters
        .sumOf { cluster -> cluster.getArea() * cluster.getSides() }
}