package aoc.year2024.day05.part01.domain;

import java.util.List;

public record PagesToProduce(
        List<Integer> pages
) {
    
    public Integer getMiddlePage() {
        return pages.get(pages.size() / 2);
    }
}
