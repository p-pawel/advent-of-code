package aoc.year2024.day08.application.services;

import aoc.year2024.day08.dto.Point;
import aoc.year2024.day08.dto.PointPair;
import aoc.year2024.day08.dto.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AntiNodeCalculatorTest {

    private final AntiNodeCalculator antiNodeCalculator = new AntiNodeCalculator();

    @Test
    void shouldCalculateAntiNodesForPair__part1() {

        // given
        PointPair points = new PointPair(
                new Point(4, 3),
                new Point(5, 5)
        );

        // when
        List<Point> result = antiNodeCalculator.forPair(points, new Rectangle(new Point(0, 0), new Point(13, 13)), false, false);

        // then
        assertThat(result).hasSize(2);
        assertThat(result).containsAll(List.of(new Point(3, 1), new Point(6, 7)));

    }

    @Test
    void shouldCalculateAntiNodesForList__part1() {

        // given
        List<Point> points = List.of(
                new Point(4, 3),
                new Point(5, 5),
                new Point(8, 4)
        );

        // when
        List<Point> result = new AntiNodeService().locateAntiNodesOfPointList(points, new Rectangle(new Point(0, 0), new Point(13, 13)), 1);

        // then
        assertThat(result).hasSize(6);
        assertThat(result).containsAll(
                List.of(
                        new Point(3, 1),
                        new Point(6, 7),

                        new Point(0, 2),
                        new Point(12, 5),

                        new Point(2, 6),
                        new Point(11, 3)
                ));

    }

    @Test
    void shouldCalculateAntiNodesForPair__part2() {

        // given
        PointPair points = new PointPair(
                new Point(0, 0),
                new Point(1, 2)
        );

        // when
        List<Point> result = antiNodeCalculator.forPair(points, new Rectangle(new Point(0, 0), new Point(13, 13)), true, true);

        // then
        assertThat(result).hasSize(7);
        assertThat(result).containsAll(List.of(
                new Point(0, 0),
                new Point(1, 2),
                new Point(2, 4),
                new Point(3, 6),
                new Point(4, 8),
                new Point(5, 10),
                new Point(6, 12)
        ));

    }

}