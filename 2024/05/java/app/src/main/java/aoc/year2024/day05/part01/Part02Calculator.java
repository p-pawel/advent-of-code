package aoc.year2024.day05.part01;

import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.services.PageMatchService;
import aoc.year2024.day05.part01.services.PageReorderService;

import java.util.List;

import static java.util.function.Predicate.not;

public class Part02Calculator {
    private final PageMatchService pageMatchService;
    private final PageReorderService pageReorderService;

    public Part02Calculator(PageMatchService pageMatchService, PageReorderService pageReorderService) {
        this.pageMatchService = pageMatchService;
        this.pageReorderService = pageReorderService;
    }

    public int calculate(List<PagesToProduce> pages) {
        return pages.stream()
                .filter(not(pageMatchService::isOrderValid))
                .map(pageReorderService::reorder)
                .mapToInt(PagesToProduce::getMiddlePage)
                .sum();
    }
}
