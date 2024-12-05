package aoc.year2024.day05.part01.adapters;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class ScannerAdapter<T> {
    
    public List<T> read(Scanner scanner, Function<String, T> parser) {
        Stream<String> inputStream = Stream.generate(() -> nextLineOrNull(scanner));

        return inputStream
                .takeWhile(line -> line != null && !line.isEmpty())
                .map(parser)
                .toList();
    }

    private static String nextLineOrNull(Scanner scanner) {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
