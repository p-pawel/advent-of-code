package aoc.year2024.day18.utils.search.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchKtTest {

    @Test
    fun shouldSearch() {
        assertEquals(5, binarySearch(0..10) { it >= 5})
        assertEquals(0, binarySearch(0..10) { it >= 0})
        assertEquals(10, binarySearch(0..10) { it >= 10})
        assertEquals(null, binarySearch(0..10) { it >= 11})
    }

}