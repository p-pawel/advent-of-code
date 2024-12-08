package aoc.year2024.day08.application.ports;

import aoc.year2024.day08.domain.NodesSituation;

public interface NodeCatalogPort<SOURCE> {
    NodesSituation toDomain(SOURCE source);
}
