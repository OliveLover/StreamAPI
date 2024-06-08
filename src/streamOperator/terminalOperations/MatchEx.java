package streamOperator.terminalOperations;

import java.util.stream.Stream;

public class MatchEx {
    public static void main(String[] args) {
        Integer[] numbers = {2, 4, 6, 8, 10};
        Stream<Integer> numberStream = Stream.of(numbers);

        boolean allEven = numberStream.allMatch(n -> n % 2 == 0);

        System.out.println("All numbers are even: " + allEven); // "All numbers are even: true" 출력

        numberStream = Stream.of(numbers);

        boolean anyGreaterThanFour = numberStream.anyMatch(n -> n > 4);

        System.out.println("Any number greater than 4: " + anyGreaterThanFour); // "Any number greater than 4: true" 출력

        numberStream = Stream.of(numbers);

        boolean noneGreaterThanEleven = numberStream.noneMatch(n -> n > 11);

        System.out.println("No number greater than 11: " + noneGreaterThanEleven); // "No number greater than 11: true" 출력

    }
}
