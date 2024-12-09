package aoc.year2024.day09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class DiskController {

    private final int size;
    private final List<FileData> files;

    public DiskController(int size, List<FileData> files) {
        this.size = size;
        this.files = files;
    }

    public List<Integer> getContent() {

        List<Integer> repeatedList = new ArrayList<>(Collections.nCopies(size, null));

        for (FileData file : files) {
            for (int i = 0; i < file.digit(); i++) {
              repeatedList.set(file.pointer()+i, file.index());
            }

        }
        return repeatedList;
    }

    public void moveFile(int index, int holeAt) {
        FileData file = files.get(index);
        files.set(index, new FileData(holeAt, file.digit(), file.index(), file.length()));
    }

    public String getPrint() {
        return this.getContent()
                .stream()
                .map(integer -> ofNullable(integer).map(Object::toString).orElse("."))
                .collect(Collectors.joining (" "));
    }

    public Long getChecksum() {
        List<Integer> content = getContent();
        Long result = 0L;
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i) != null) {
                result += content.get(i) * i;
            }
        }
        return result;
    }
}
