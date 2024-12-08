package aoc.year2024.day08;

import aoc.year2024.day08.application.services.AntiNodeService;
import aoc.year2024.day08.dto.Point;
import aoc.year2024.day08.application.ports.LinesNodeCatalogAdapter;
import aoc.year2024.day08.domain.NodesSituation;

import java.util.List;

import static dev.skirmishhaversack.utils.io.ReadUtilsKt.readAllLines;

public class Main {

    private final LinesNodeCatalogAdapter nodeCatalogAdapter = new LinesNodeCatalogAdapter();
    private final AntiNodeService antiNodeService = new AntiNodeService();

    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {

        NodesSituation situation = nodeCatalogAdapter.toDomain(readAllLines());

        List<Point> antiNodes1 = antiNodeService.locateAntiNodes(situation, 1);
        List<Point> antiNodes2 = antiNodeService.locateAntiNodes(situation, 2);

        System.out.println("Part 1: " + antiNodes1.size());
        System.out.println("Part 2: " + antiNodes2.size());
    }

}
