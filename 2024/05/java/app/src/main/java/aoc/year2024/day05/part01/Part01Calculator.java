package aoc.year2024.day05.part01;

import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.services.PageMatchService;

import java.util.List;

public class Part01Calculator {
    private final PageMatchService pageMatchService;

    public Part01Calculator(PageMatchService pageMatchService) {
        this.pageMatchService = pageMatchService;
    }

    public int calculate(List<PagesToProduce> pages) {
        return pages.stream()
                .filter(pageMatchService::isOrderValid)
                .mapToInt(PagesToProduce::getMiddlePage)
                .sum();
    }
}
