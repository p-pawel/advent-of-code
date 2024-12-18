package aoc.year2024.day18.utils.search.array

fun linearSearch(range: ClosedRange<Int>, test: (Int) -> Boolean): Int? {
    val index = (range.start..range.endInclusive)
        .indexOfFirst { i: Int -> test(i) }

    return if (index == -1) null else index;
}