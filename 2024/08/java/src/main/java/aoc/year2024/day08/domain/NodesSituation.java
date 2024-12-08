package aoc.year2024.day08.domain;


import aoc.year2024.day08.dto.Node;
import aoc.year2024.day08.dto.Point;

import java.util.*;

public class NodesSituation {

    private final Map<Character, List<Point>> pointsByFrequencies = new HashMap<>();
    private final int width;
    private final int height;

    public NodesSituation(List<Node> nodes, int width, int height) {
        this.width = width;
        this.height = height;
        nodes.forEach(
                node -> this.pointsByFrequencies.computeIfAbsent(node.frequency(), (k) -> new ArrayList<>()).add(node.point())
        );

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Character, List<Point>> getPointsByFrequencies() {
        return new HashMap<>(this.pointsByFrequencies);
    }
}
