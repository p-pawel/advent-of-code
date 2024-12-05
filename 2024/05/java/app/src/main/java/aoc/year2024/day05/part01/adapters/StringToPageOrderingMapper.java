package aoc.year2024.day05.part01.adapters;

import aoc.year2024.day05.part01.domain.PageOrderingRule;

public class StringToPageOrderingMapper implements FromStringMapper<PageOrderingRule> {

    @Override
    public PageOrderingRule parse(String input) {
        String[] parts = input.split("\\|");

        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        return new PageOrderingRule(x, y);
    }
}
