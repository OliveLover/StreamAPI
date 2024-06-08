package streamOperator.terminalOperations;

import java.util.Iterator;
import java.util.stream.Stream;

public class IteratorEx {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> numberStream = Stream.of(numbers);

        Iterator<Integer> iterator = numberStream.iterator();

        System.out.println("Stream elements:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
