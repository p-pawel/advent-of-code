package aoc.year2024.day08.application.services;

import aoc.year2024.day08.dto.Point;
import aoc.year2024.day08.dto.PointPair;
import aoc.year2024.day08.dto.Rectangle;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

class AntiNodeCalculator {

    public List<Point> forPair(PointPair pair, Rectangle bounds, boolean multipleAntiNodes, boolean includeOriginalPoints) {

        Point b = pair.b();
        Point a = pair.a();
        Point delta = a.minus(b);

        int pointsLimit = multipleAntiNodes ? Math.max(bounds.width(), bounds.height()) : 1; // instead of calc loop, we can afford to generate more points and then trim them out from the boundaries
        return IntStream.rangeClosed(0, pointsLimit)
                .mapToObj(i -> List.of(
                                b.minus(delta.multiply(i)),
                                a.plus(delta.multiply(i))
                        )
                )
                .flatMap(Collection::stream)
                .filter(point -> point.withinBounds(bounds))
                .filter(point -> !point.equals(a) || includeOriginalPoints)
                .filter(point -> !point.equals(b) || includeOriginalPoints)
                .toList();


    }

}


