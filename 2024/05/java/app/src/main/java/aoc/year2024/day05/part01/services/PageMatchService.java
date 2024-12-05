package aoc.year2024.day05.part01.services;

import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.repositories.PageOrderingRepository;

import java.util.List;
import java.util.stream.IntStream;

public class PageMatchService {
    private final PageOrderingRepository pageOrderingRepository;

    public PageMatchService(PageOrderingRepository pageOrderingRepository) {
        this.pageOrderingRepository = pageOrderingRepository;
    }

    public boolean isOrderValid(PagesToProduce pagesToProduce) {
        List<Integer> pages = pagesToProduce.pages();
        return IntStream.range(0, pages.size())
                .mapToObj(i -> pages.subList(i, pages.size()))
                .allMatch(this::isSublistValid);
    }

    private boolean isSublistValid(List<Integer> sublist) {
        if (sublist.size() < 2) {
            return true;
        }

        Integer first = sublist.getFirst();
        return sublist.subList(1, sublist.size()).stream()
                .allMatch(e -> pageOrderingRepository.isOrderAllowed(first, e));


    }
}
