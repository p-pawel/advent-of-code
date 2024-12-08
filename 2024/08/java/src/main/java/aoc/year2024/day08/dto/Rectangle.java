package aoc.year2024.day08.dto;

public record Rectangle(Point p1, Point p2) {
    public int width() {
        return p2.minus(p1).x();
    }

    public int height() {
        return p2.minus(p1).y();
    }
}
