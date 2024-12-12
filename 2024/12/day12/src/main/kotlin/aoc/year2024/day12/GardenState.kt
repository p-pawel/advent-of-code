package aoc.year2024.day12

class GardenState(
    val clusters: List<GardenCluster> = listOf()
) {

    fun addPlot(gardenPlot: GardenPlot): GardenState {

        val matchingClusters = clusters
            .filter { c -> c.canMerge(gardenPlot) }

        val newClusters: List<GardenCluster> = when (matchingClusters.size) {
            0 -> clusters + (GardenCluster(this.clusters.size + 1, gardenPlot.plant) + gardenPlot)
            1 -> clusters - matchingClusters.first() + (matchingClusters.first() + gardenPlot)
            2 -> clusters - matchingClusters.toSet() + (matchingClusters.first() + matchingClusters[1] + gardenPlot)
            else -> error("unexpected matching clusters: $matchingClusters")
        }

        return GardenState(newClusters)
    }

    override fun toString(): String {
        return "GardenState(clusters=$clusters)"
    }
}
