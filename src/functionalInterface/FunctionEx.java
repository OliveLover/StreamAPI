package functionalInterface;

import java.util.function.Function;

public class FunctionEx {
    public static void main(String[] args) {
        // ex
        Function<String, Integer> function = str -> str.length();
        function.apply("Hello World!");
    }

}
