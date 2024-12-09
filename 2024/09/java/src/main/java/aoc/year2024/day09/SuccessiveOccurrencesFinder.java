package aoc.year2024.day09;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SuccessiveOccurrencesFinder {

    public static Optional<Integer> findFirstNSuccessiveOccurrences(List<Integer> list, Integer value, int n) {

        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), value)) {
                count++;
                if (count == n) {
                    return Optional.of(i - n + 1);
                }
            } else {
                count = 0;
            }
        }

        return Optional.empty();
    }

}
