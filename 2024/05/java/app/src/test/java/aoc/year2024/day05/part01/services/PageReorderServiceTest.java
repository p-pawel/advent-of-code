package aoc.year2024.day05.part01.services;

import aoc.year2024.day05.part01.domain.PageOrderingRule;
import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.repositories.PageOrderingRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageReorderServiceTest {

    @Test
    void shouldReorderPages() {

        // given
        PageOrderingRepository pageOrderingRepository = new PageOrderingRepository();
        pageOrderingRepository.saveAll(List.of(
                new PageOrderingRule(75, 13),
                new PageOrderingRule(75, 29),
                new PageOrderingRule(75, 47),
                new PageOrderingRule(75, 53),
                new PageOrderingRule(75, 61),
                new PageOrderingRule(47, 13),
                new PageOrderingRule(47, 29),
                new PageOrderingRule(47, 53),
                new PageOrderingRule(47, 61),
                new PageOrderingRule(61, 13),
                new PageOrderingRule(61, 29),
                new PageOrderingRule(61, 53),
                new PageOrderingRule(53, 29),
                new PageOrderingRule(29, 13)
        ));


        PagesToProduce pagesToProduce = new PagesToProduce(List.of( 61, 13, 29));

        // when
        PagesToProduce result = new PageReorderService(pageOrderingRepository).reorder(pagesToProduce);

        // then
        assertEquals(List.of( 61, 29, 13), result.pages());
        
    }
}