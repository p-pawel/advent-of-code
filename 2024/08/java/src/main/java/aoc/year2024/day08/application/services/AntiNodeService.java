package aoc.year2024.day08.application.services;

import aoc.year2024.day08.dto.Point;
import aoc.year2024.day08.dto.PointPair;
import aoc.year2024.day08.dto.Rectangle;
import aoc.year2024.day08.domain.NodesSituation;

import java.util.Collection;
import java.util.List;

import static dev.skirmishhaversack.utils.combinatorics.ListExtensionsKt.mapToCombinations;

public class AntiNodeService {

    private final AntiNodeCalculator antiNodeCalculator = new AntiNodeCalculator();

    public List<Point> locateAntiNodes(NodesSituation situation, int part) {

        Rectangle boundaries = new Rectangle(new Point(0, 0), new Point(situation.getWidth(), situation.getHeight()));

        return situation.getPointsByFrequencies().values().stream()
                .map(points -> locateAntiNodesOfPointList(points, boundaries, part))
                .flatMap(Collection::stream)
                .distinct()
                .toList();
    }


    List<Point> locateAntiNodesOfPointList(List<Point> points, Rectangle boundaries, int part) {
        return mapToCombinations(points).stream()
                .map(pair -> new PointPair(pair.getFirst(), pair.getSecond()))
                .map(pair -> switch (part) {
                    case 1 -> antiNodeCalculator.forPair(pair, boundaries, false, false);
                    case 2 -> antiNodeCalculator.forPair(pair, boundaries, true, true);
                    default -> throw new IllegalStateException("Unexpected part number: " + part);
                })
                .flatMap(List::stream)
                .toList();
    }

}
