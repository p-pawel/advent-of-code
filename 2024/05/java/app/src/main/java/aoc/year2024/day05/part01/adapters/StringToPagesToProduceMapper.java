package aoc.year2024.day05.part01.adapters;

import aoc.year2024.day05.part01.domain.PagesToProduce;

import java.util.Arrays;
import java.util.List;

public class StringToPagesToProduceMapper implements FromStringMapper<PagesToProduce> {

    public PagesToProduce parse(String input) {
        List<Integer> pages = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        return new PagesToProduce(pages);
    }
}
