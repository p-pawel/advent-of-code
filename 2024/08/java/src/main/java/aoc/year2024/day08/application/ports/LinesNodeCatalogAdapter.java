package aoc.year2024.day08.application.ports;

import aoc.year2024.day08.domain.NodesSituation;

import java.util.List;

public class LinesNodeCatalogAdapter implements NodeCatalogPort<List<String>> {

    private MapParser mapParser = new MapParser();

    @Override
    public NodesSituation toDomain(List<String> inputLines) {
                NodeMap map = mapParser.parse(inputLines);

        return new NodesSituation(map.nodes(), map.width(), map.height());
    }
}
