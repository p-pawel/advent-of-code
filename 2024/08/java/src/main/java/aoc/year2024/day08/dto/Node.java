package aoc.year2024.day08.dto;

public record Node(
        Point point,
        Character frequency
) {
    public Node(int x, int y, char frequency) {
        this(new Point(x, y), frequency);
    }
}
