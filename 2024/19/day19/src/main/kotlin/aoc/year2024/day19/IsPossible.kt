package aoc.year2024.day19

fun isPossible(design: String, patterns: List<String>): Boolean {
    return patterns.filter { design.startsWith(it) }
        .map { subPattern -> design.drop(subPattern.length) }
        .any { subDesign ->
            when (patterns.contains(subDesign)) {
                true -> true
                else -> isPossible(subDesign, patterns)
            }
        }
}
