package streamOperator.intermediateOperations;

import java.util.stream.Stream;

public class SkipEx {
    public static void main(String[] args) {
        Stream<Integer> numbersStream = Stream.iterate(1, i -> i + 1).limit(10);

        numbersStream.skip(5)
                .forEach(System.out::println);
    }
}
