package aoc.year2024.day10;

import java.util.*;
import java.util.stream.IntStream;

public class Terrain {

    private static final List<Delta> NEIGHBOURS = List.of(
            new Delta(-1, 0),
            new Delta(+1, 0),
            new Delta(0, -1),
            new Delta(0, +1)
    );

    private final List<List<Short>> data;
    private final int width;
    private final int height;

    public Terrain(List<String> lines) {
        this.data = lines.stream()
                .map(line -> Arrays.stream(line.split(""))
                        .map(s -> s.equals(".") ? null : Short.parseShort(s))
                        .toList()
                )
                .toList();

        this.width = data.getFirst().size();
        this.height = data.size();
    }

    public List<Point> findAllTrailHeads() {
        short lowest = this.findLowestElevation();

        return IntStream.range(0, height)
                .boxed()
                .flatMap(y -> IntStream.range(0, width).mapToObj(x -> new Point(x, y, data.get(y).get(x))))
                .filter(point -> point.height() == lowest)
                .toList();
    }

    private short findLowestElevation() {
        return data.stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("No elevation found"));
    }

    public List<Point> findEvenGradualUphillsFromPoint(Point point) {
        return NEIGHBOURS.stream()
                .map(delta -> getPoint(point.x() + delta.x, point.y() + delta.y))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(newPoint -> newPoint.height() == point.height() + 1)
                .toList();
    }

    private Optional<Point> getPoint(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Optional.empty();
        }
        List<Short> row = data.get(y);
        if (row.get(x) != null) {
            return Optional.of(new Point(x, y, row.get(x)));
        } else {
            return Optional.empty();
        }
    }

    record Delta(int x, int y) {
    }
}
