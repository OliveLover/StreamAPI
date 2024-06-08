package streamOperator.intermediateOperations;

import java.util.stream.IntStream;

public class peekEx {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        IntStream.of(numbers)
                .peek(System.out::println)
                .forEach(n -> {});
    }
}
