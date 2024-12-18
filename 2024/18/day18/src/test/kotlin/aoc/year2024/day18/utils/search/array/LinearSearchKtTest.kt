package aoc.year2024.day18.utils.search.array

import aoc.year2024.toolbox.search.array.binarySearch
import aoc.year2024.toolbox.search.array.linearSearch
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LinearSearchKtTest {

    @Test
    fun shouldSearch() {
        assertEquals(5, linearSearch(0..10) { it >= 5})
        assertEquals(0, binarySearch(0..10) { it >= 0})
        assertEquals(10, linearSearch(0..10) { it >= 10})
        assertEquals(null, linearSearch(0..10) { it >= 11})
    }

}