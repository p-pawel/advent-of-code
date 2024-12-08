package aoc.year2024.day08.application.ports;

import aoc.year2024.day08.dto.Node;
import aoc.year2024.day08.dto.Point;
import aoc.year2024.day08.dto.Rectangle;

import java.util.List;

record NodeMap(
        int width,
        int height,
        List<Node> nodes
) {
    public Rectangle boundaries() {
        return new Rectangle(
                new Point(0, 0),
                new Point(width, height)
        );
    }
}
