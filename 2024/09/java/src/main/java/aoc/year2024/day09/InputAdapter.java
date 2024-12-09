package aoc.year2024.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class InputAdapter {
    public int parseSize(String input) {
        return Stream.of(input.split(""))
                .map(Objects::toString)
                .mapToInt(Integer::parseUnsignedInt)
                .sum();
    }

    public List<FileData> parseFiles(String input) {
        List<Integer> digits = Stream.of(input.split(""))
                .map(Objects::toString)
                .map(Integer::parseUnsignedInt)
                .toList();

        List<FileData> files = new ArrayList<>();
        int pointer = 0;
        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                files.add(new FileData(pointer, digits.get(i), files.size(), 0));
            }
            pointer += digits.get(i);
        }
        return files;
    }
}
