package aoc.year2024.day10;

import java.util.List;

public class Hike {
    private final Point point;
    private List<Hike> next;

    public Hike(Point point, List<Hike> next) {
        this.point = point;
        this.next = next;

    }

    public Point getPoint() {
        return point;
    }

    public List<Hike> getNext() {
        return next;
    }
}
