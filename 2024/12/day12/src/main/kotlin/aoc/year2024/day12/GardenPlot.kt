package aoc.year2024.day12

data class GardenPlot(val x: Int, val y: Int, val plant: Char)

enum class Side { N, E, S, W }

data class FencedPlot(val x: Int, val y: Int, val plant: Char, val sides: Set<Side>) {
    constructor(gardenPlot: GardenPlot) : this(
        gardenPlot.x,
        gardenPlot.y,
        gardenPlot.plant,
        setOf(Side.N, Side.E, Side.W, Side.S)
    )
}