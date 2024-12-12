package aoc.year2024.day12

import kotlin.math.abs

class GardenCluster(
    private val id: Int,
    private val plant: Char,
    private val plots: List<GardenPlot> = listOf()
) {

    fun canMerge(newPlot: GardenPlot): Boolean {
        if (this.plant != newPlot.plant) {
            return false
        }
        return getNeighbors(newPlot).isNotEmpty()
    }

    operator fun plus(gardenPlot: GardenPlot): GardenCluster {
        check(plots.isEmpty() || canMerge(gardenPlot))
        return GardenCluster(this.id, this.plant, this.plots + gardenPlot);
    }

    operator fun plus(otherCluster: GardenCluster): GardenCluster {
        check (this.plant == otherCluster.plant) {
            "Difference between clusters: $plant vs ${otherCluster.plant}"
        }
        return GardenCluster(id, plant, plots + otherCluster.plots)
    }

    fun getArea(): Int {
        return plots.size
    }

    fun getPerimeter(): Int {
        val perimeter = plots
            .sumOf { p1 -> run {
                val neighbors = plots
                    .filter { p2 -> (p1 != p2) && isNeighboring(p1, p2) }
                return@run 4 - neighbors.size
            } }

        return perimeter
    }

    override fun toString(): String {
        return "GardenCluster(id=$id, plant=$plant, plots=$plots)"
    }

    private fun getNeighbors(newPlot: GardenPlot): List<GardenPlot> {
        return plots
            .filter { existingPlot -> existingPlot.plant == newPlot.plant }
            .filter { existingPlot -> isNeighboring(existingPlot, newPlot) }
    }

    private fun isNeighboring(plot1: GardenPlot, plot2: GardenPlot): Boolean {
        return abs(plot1.x - plot2.x) + abs( plot1.y - plot2.y) == 1
    }
}
