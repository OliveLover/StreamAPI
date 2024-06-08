package streamOperator.intermediateOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortedEx {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "grape", "orange"};
        Stream<String> stream = Arrays.stream(words);

        Stream<String> sortedStream = stream.sorted(Comparator.comparingInt(String::length).reversed());

        sortedStream.forEach(System.out::println);
    }
}
