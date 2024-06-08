package functionalInterface;

import java.util.function.Supplier;

public class SupplierEx {
    public static void main(String[] args) {
        // ex1
        Supplier<String> stringSupplier = () -> "Hello World!";
        System.out.println(stringSupplier.get());

        // ex2
        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get());

    }
}
