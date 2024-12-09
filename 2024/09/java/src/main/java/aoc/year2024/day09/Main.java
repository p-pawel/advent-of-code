package aoc.year2024.day09;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {
        String input = new Scanner(System.in).nextLine();
        int size = new InputAdapter().parseSize(input);
        List<FileData> files = new InputAdapter().parseFiles(input);

        DiskController diskController = new DiskController(size, files);

        for (int i = files.size() - 1; i >= 0; i--) {
            List<Integer> content = diskController.getContent();
            FileData file = files.get(i);
            Optional<Integer> holeAt = SuccessiveOccurrencesFinder.findFirstNSuccessiveOccurrences(content, null, file.digit());

            if (holeAt.isPresent() && holeAt.get() < file.pointer()) {
                diskController.moveFile(file.index(), holeAt.get());
            }
        }

        System.out.println("Part 2: " + diskController.getChecksum());
    }
}