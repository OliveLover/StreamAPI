package functionalInterface;

import java.util.function.Predicate;

public class PredicateEx {
    public static void main(String[] args) {
        Predicate<String> predicate = (str) -> str.equals("Hello World!");
        predicate.test("Hello World!");
    }
}
