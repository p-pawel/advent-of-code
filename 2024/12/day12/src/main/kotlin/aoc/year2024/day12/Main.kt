package aoc.year2024.day12


fun main() {

    val lines = generateSequence {
        readlnOrNull()?.takeIf { it.isNotEmpty() }
    }.toList()

    val gardenPlots = lines.flatMapIndexed { y, row ->
        row.mapIndexed { x, plant ->
            GardenPlot(x, y, plant)
        }
    }

    val gardenState = gardenPlots.fold(GardenState()) { currentRepository, point ->
        currentRepository.addPlot(point)
    }

    val price1 = gardenState.clusters
        .sumOf { cluster -> cluster.getArea() * cluster.getPerimeter() }

    println(price1)
}