package aoc.year2024.day05.part01.adapters;

@FunctionalInterface
public interface FromStringMapper<T> {
    T parse(String input);
}
