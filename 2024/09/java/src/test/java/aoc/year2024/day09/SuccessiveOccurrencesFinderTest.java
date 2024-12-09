package aoc.year2024.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static aoc.year2024.day09.SuccessiveOccurrencesFinder.findFirstNSuccessiveOccurrences;


class SuccessiveOccurrencesFinderTest {

    @Test
    void shouldFindFirstNSuccessiveOccurrences() {

        // given
        List<Integer> list = List.of(1, 2, 2, 2, 3, 2, 2, 4, 2, 2, 2, 2);
        int value = 2;
        int n = 4;

        // when
        Optional<Integer> index = findFirstNSuccessiveOccurrences(list, value, n);

        // then
        Assertions.assertEquals(8, index.get(), "First " + n + " successive occurrences of " + value + " should start at index " + index);
    }
}