package aoc.year2024.day05.part01.services;

import aoc.year2024.day05.part01.domain.PageOrderingRule;
import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.repositories.PageOrderingRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageMatchServiceTest {

    @Test
    void shouldValidateOrder() {
        
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
                new PageOrderingRule(53, 29)
        ));


        PagesToProduce pagesToProduce = new PagesToProduce(List.of(75, 47, 61, 53, 29));

        // when
        boolean result = new PageMatchService(pageOrderingRepository).isOrderValid(pagesToProduce);

        // then
        assertTrue(result);
        
        
    }
}