package streamOperator.terminalOperations;

import java.util.stream.Stream;

public class forEachOrderedEx {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> numberStream = Stream.of(numbers).parallel();

        System.out.println("Parallel Stream with forEachOrdered:");
        numberStream.forEachOrdered(System.out::println);
    }
}
