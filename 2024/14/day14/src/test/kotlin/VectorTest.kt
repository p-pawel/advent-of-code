import aoc.year2024.Vector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VectorTest {

    @Test
    fun shouldRemainderAlsoForNegatives() {
        val p = Vector(x=12, y=-8)
        val board = Vector(x=11, y=7)

        var res = p % board

        assertEquals(12 % 11, res.x)
        assertEquals(6, res.y)
    }

}