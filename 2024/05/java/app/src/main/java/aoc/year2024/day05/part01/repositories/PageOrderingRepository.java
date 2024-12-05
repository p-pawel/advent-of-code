package aoc.year2024.day05.part01.repositories;

import aoc.year2024.day05.part01.domain.PageOrderingRule;

import java.util.ArrayList;
import java.util.List;

public class PageOrderingRepository {
    private List<PageOrderingRule> rules = new ArrayList<>();
    
    public void saveAll(List<PageOrderingRule> rules) {
        this.rules.addAll(rules);
    }

    public boolean isOrderAllowed(Integer before, Integer after) {
        return rules.stream()
                .anyMatch(e -> e.x() == before && e.y() == after);
    }

}
