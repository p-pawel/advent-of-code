package aoc.year2024.day07;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<InputDataSet> inputDataSets = Stream.generate(() -> getNextLine(scanner))
                .takeWhile(line -> line != null && !line.isEmpty())
                .map(Main::parse)
                .toList();

        List<BinaryOperator<BigDecimal>> operators1 = List.of(
                BigDecimal::add,
                BigDecimal::multiply
        );
        BigDecimal result1 = inputDataSets.stream()
                .filter(ins -> canEquationBeTrue(ins, operators1))
                .map(InputDataSet::result)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(result1);

        List<BinaryOperator<BigDecimal>> operators2 = List.of(
                BigDecimal::add,
                BigDecimal::multiply,
                (a,b)->(new BigDecimal(a.toString() + b.toString()))
        );
        BigDecimal result2 = inputDataSets.stream()
                .filter(ins -> canEquationBeTrue(ins, operators2))
                .map(InputDataSet::result)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(result2);
    }

    private static String getNextLine(Scanner scanner) {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private static InputDataSet parse(String string) {
        String[] parts = string.split(": ");
        String[] numbers = parts[1].split(" ");
        return new InputDataSet(new BigDecimal(parts[0]), Arrays.stream(numbers).map(BigDecimal::new).toList());
    }

    private static boolean canEquationBeTrue(InputDataSet ins, List<BinaryOperator<BigDecimal>> operators) {
        List<List<BinaryOperator<BigDecimal>>> variations = prepareOperatorVariation(ins.numbers.size() - 1, operators);
        return variations.stream()
                .map(variation -> calculate(ins.numbers(), variation))
                .anyMatch(result -> result.equals(ins.result()));
    }

    private static List<List<BinaryOperator<BigDecimal>>> prepareOperatorVariation(int numberCount, List<BinaryOperator<BigDecimal>> operators) {
        int setSize = operators.size();

        int variationsCount = (int) Math.pow(setSize, numberCount);
        return IntStream.range(0, variationsCount)
                .mapToObj(i -> IntStream.range(0, numberCount)
                        .map(j -> i / (int) Math.pow(setSize, j) % setSize)
                        .mapToObj(operators::get)
                        .toList()
                )
                .toList();
    }

    public static BigDecimal calculate(List<BigDecimal> numbers, List<BinaryOperator<BigDecimal>> operators) {
        BigDecimal result = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            result = operators.get(i - 1).apply(result, numbers.get(i));
        }
        return result;
    }

    record InputDataSet(
            BigDecimal result,
            List<BigDecimal> numbers
    ) {
    }
}

