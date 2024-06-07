package functionalInterface;

import java.util.function.Supplier;

public class SupplierEx {
    public static void main(String[] args) {
        // ex
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());
    }
}
