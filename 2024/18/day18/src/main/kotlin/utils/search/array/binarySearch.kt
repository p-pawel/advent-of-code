package aoc.year2024.day18.utils.search.array


fun binarySearch(range: ClosedRange<Int>, test: (Int) -> Boolean): Int? {

    var left = range.start
    var right = range.endInclusive
    var result: Int? = null

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (test(mid)) {
            result = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return result
}