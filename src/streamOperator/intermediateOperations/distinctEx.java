package streamOperator.intermediateOperations;

import java.util.ArrayList;
import java.util.List;

public class distinctEx {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(5);

        numbers.stream().distinct().forEach(System.out::println);
    }
}
