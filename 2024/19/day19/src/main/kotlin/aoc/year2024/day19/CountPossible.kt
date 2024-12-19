package aoc.year2024.day19

fun countPossible(design: String, patterns: List<String>): Long {
    return SimpleCache<String, Long>()
        .let { cache -> cache.getOrRunWithCache(design) { cache, it -> countPossibleCached(it, patterns, cache) } }
}

private fun countPossibleCached(design: String, patterns: List<String>, cache: SimpleCache<String, Long>): Long {
    return patterns.filter { design.startsWith(it) }
        .map { subPattern -> design.drop(subPattern.length) }
        .sumOf { subDesign ->
            when {
                subDesign.isEmpty() -> 1L
                else -> cache.getOrRunWithCache(subDesign) { cache, it -> countPossibleCached(it, patterns, cache) }
            }
        }
}
