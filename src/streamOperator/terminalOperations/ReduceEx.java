package streamOperator.terminalOperations;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceEx {
    public static void main(String[] args) {
        // 정수 배열을 Stream으로 변환
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> numberStream = Stream.of(numbers);

        Optional<Integer> sum = numberStream.reduce((a, b) -> {
            int result = a + b;
            System.out.println(a + " + " + b + " = " + result);
            return result;
        });

        sum.ifPresent(result -> System.out.println("Sum of numbers: " + result));
    }
}
