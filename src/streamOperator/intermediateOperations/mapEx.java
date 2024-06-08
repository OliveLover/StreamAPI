package streamOperator.intermediateOperations;

import java.util.ArrayList;
import java.util.List;

public class mapEx {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        numbers.stream().map(number -> number * 2).forEach(System.out::println);
    }
}
