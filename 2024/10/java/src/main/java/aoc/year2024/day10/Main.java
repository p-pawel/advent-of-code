package aoc.year2024.day10;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static aoc.year2024.day10.ScannerAdapter.readLines;

public class Main {

    public static final int MAX_HEIGHT = 9;
    private Terrain terrain;

    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {

        List<String> input = readLines(new Scanner(System.in));

        terrain = new Terrain(input);

        List<Point> heads = terrain.findAllTrailHeads();

        int score = 0;
        int rank = 0;
        for (Point head : heads) {
            Hike hike = getHike(head);

            Set<Point> nines = countNinesFrom(hike);
            int ranks = countRankFrom(hike);
            score = score + nines.size();
            rank = rank + ranks;
        }
        System.out.println("Part 1: " + score);
        System.out.println("Part 2: " + rank);
    }

    private int countRankFrom(Hike hike) {
        if (hike.getPoint().height() == MAX_HEIGHT) {
            return 1;
        }
        return hike.getNext().stream().mapToInt(this::countRankFrom).sum();
    }

    private Set<Point> countNinesFrom(Hike hike) {
        if (hike.getPoint().height() == MAX_HEIGHT) {
            return Set.of(hike.getPoint());
        }
        return hike.getNext().stream().map(this::countNinesFrom).flatMap(Collection::stream).collect(Collectors.toSet());
    }

    private Hike getHike(Point point) {
        List<Point> nextPoints = terrain.findEvenGradualUphillsFromPoint(point);
        List<Hike> nextHikes = nextPoints.stream().map(this::getHike).toList();
        return new Hike(point, nextHikes);
    }
}
