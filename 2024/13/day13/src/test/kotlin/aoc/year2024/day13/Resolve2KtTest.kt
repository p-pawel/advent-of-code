package aoc.year2024.day13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Resolve2KtTest {

    @Test
    fun shouldResolveForSample1() {

        // given
        val jumpA = Vector(94, 34)
        val jumpB = Vector(22, 67)
        val goal = Vector(8400, 5400)

        // when
        var res = resolve2(jumpA, jumpB, goal)

        // then
        assertThat(res!!.cost()).isEqualTo(280)
    }

    @Test
    fun shouldResolveForSample2() {

        // given
        val jumpA = Vector(26, 66)
        val jumpB = Vector(67, 21)
        val goal = Vector(10000000012748, 10000000012176)

        // when
        var res = resolve2(jumpA, jumpB, goal)!!

        // then
        assertThat(res).isEqualTo(Result(118679050709L, 103199174542L))
    }
}