package aoc.year2024.day08.application.ports;

import aoc.year2024.day08.dto.Node;

import java.util.ArrayList;
import java.util.List;

class MapParser {

    public NodeMap parse(List<String> lines) {

        List<Node> nodes = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                if (isNodeCharacter(c)) {
                    nodes.add(new Node(x, y, c));
                }
            }

        }

        return new NodeMap(
                lines.getFirst().length(),
                lines.size(),
                nodes
        );
    }

    private boolean isNodeCharacter(char c) {
        return ((c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9'));
    }
}
