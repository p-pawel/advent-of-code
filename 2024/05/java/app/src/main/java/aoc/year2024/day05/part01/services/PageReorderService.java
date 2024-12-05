package aoc.year2024.day05.part01.services;

import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.repositories.PageOrderingRepository;

import java.util.ArrayList;
import java.util.List;

public class PageReorderService {
    private final PageOrderingRepository pageOrderingRepository;

    public PageReorderService(PageOrderingRepository pageOrderingRepository) {
        this.pageOrderingRepository = pageOrderingRepository;
    }

    public PagesToProduce reorder(PagesToProduce pagesToProduce) {
        List<Integer> pages = new ArrayList<>(pagesToProduce.pages());
        pages.sort((o1, o2) -> {
            if (pageOrderingRepository.isOrderAllowed(o1, o2)) {
                return -1;
            }
            if (pageOrderingRepository.isOrderAllowed(o2, o1)) {
                return 1;
            }
            return 0;
        });
        return new PagesToProduce(pages);
    }
}
