package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {
    public static void main(String[] args) {
        // ex
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
        consumer.andThen(System.out::println).accept("Hello World!");

        // ex2
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Consumer<String> printConsumer = System.out::println;
        strings.forEach(printConsumer);
    }
}
