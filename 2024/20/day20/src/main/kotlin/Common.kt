package aoc.year2024.day20

import dev.skirmishhaversack.algorithms.search.path.CharMapNodeProvider
import dev.skirmishhaversack.algorithms.search.path.aStar
import dev.skirmishhaversack.algorithms.search.path.reconstructPath
import dev.skirmishhaversack.structures.CharMap2D
import dev.skirmishhaversack.utils.combinatorics.forEachCombination
import dev.skirmishhaversack.utils.geometry.manhattanDistance

fun executeCommon(lines: List<String>, maxAllowedCheat: Int): String {

    val charMap = CharMap2D(lines)
    val start = charMap.locateItem('S')
    val goal = charMap.locateItem('E')

    val goals = aStar(CharMapNodeProvider(charMap, '#'), start, goal)
    val path = reconstructPath(goals!!)

    val saves = mutableMapOf<Int, Int>()

    path.forEachCombination { n1, n2 ->
        val p1 = n1.point
        val p2 = n2.point

        val xyDistance = manhattanDistance(p1, p2)
        val pathDistance = n2.gCost - n1.gCost

        if (xyDistance <= maxAllowedCheat) {
            val save = (pathDistance - xyDistance).toInt()
            if (xyDistance < pathDistance) {
                saves.put(save.toInt(), (saves[save] ?: 0) + 1);
            }
        }
    }

    return saves.entries
        .filter { it.key >= 100 }
        .sumOf { it.value }
        .toString()
}
