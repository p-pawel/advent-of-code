package aoc.year2024.day08.application.ports;

import aoc.year2024.day08.dto.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapParserTest {

    private final MapParser mapParser = new MapParser();

    @Test
    void shouldParse() {

        // given

        String input = """
            ............
            ........0...
            .....0......
            .......0....
            ....0.......
            ......A.....
            ............
            ............
            ........A...
            .........A..
            ............
            ............
            """;

        // when
        NodeMap result = mapParser.parse(Arrays.stream(input.split("\n")).toList());

        // then
        assertThat(result.width()).isEqualTo(12);
        assertThat(result.height()).isEqualTo(12);
        assertThat(result.nodes()).hasSize(7);
        assertThat(result.nodes()).containsAll(List.of(
                new Node(8, 1, '0'),
                new Node(5, 2, '0'),
                new Node(7, 3, '0'),
                new Node(4, 4, '0'),
                new Node(6, 5, 'A'),
                new Node(8, 8, 'A'),
                new Node(9, 9, 'A')
                )
        );
    }
}