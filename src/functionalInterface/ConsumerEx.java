package functionalInterface;

import java.util.function.Consumer;

public class ConsumerEx {
    public static void main(String[] args) {
        // ex
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
        consumer.andThen(System.out::println).accept("Hello World!");
    }
}
