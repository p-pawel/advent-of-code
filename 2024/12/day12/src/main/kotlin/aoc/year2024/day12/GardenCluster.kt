package aoc.year2024.day12

class GardenCluster(
    private val id: Int,
    private val plant: Char,
    private val plots: List<FencedPlot> = listOf()
) {

    fun canMerge(newPlot: GardenPlot): Boolean {
        if (this.plant != newPlot.plant) {
            return false
        }
        return getNeighbors(newPlot).isNotEmpty()
    }

    operator fun plus(gardenPlot: GardenPlot): GardenCluster {
        check(plots.isEmpty() || canMerge(gardenPlot))
        return GardenCluster(this.id, this.plant, mergePlots(this.plots, FencedPlot(gardenPlot)));
    }

    operator fun plus(otherCluster: GardenCluster): GardenCluster {
        check(this.plant == otherCluster.plant) {
            "Difference between clusters: $plant vs ${otherCluster.plant}"
        }
        return GardenCluster(id, plant, plots + otherCluster.plots)
    }

    fun getArea(): Int {
        return plots.size
    }

    fun getPerimeter(): Int {
        return plots
            .sumOf { p1 -> p1.sides.size }
    }

    fun getSides(): Int {
        val sameSideFences: Int = plots.sumOf { p1 ->
            plots
                .filter { isNeighboring(p1, it) }
                .sumOf { hasSameSideFence(p1, it) }
        }

        return getPerimeter() - sameSideFences;
    }

    override fun toString(): String {
        return "GardenCluster(id=$id, plant=$plant, plots=$plots)"
    }

    private fun getNeighbors(newPlot: GardenPlot): List<FencedPlot> {
        return plots
            .filter { existingPlot -> existingPlot.plant == newPlot.plant }
            .filter { existingPlot -> isNeighboring(existingPlot, newPlot) }
    }

}
