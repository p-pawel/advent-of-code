package aoc.year2024.day10;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ScannerAdapter {
    
    public static List<String> readLines(Scanner scanner) {
        Stream<String> inputStream = Stream.generate(() -> nextLineOrNull(scanner));

        return inputStream
                .takeWhile(line -> line != null && !line.isEmpty())
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
