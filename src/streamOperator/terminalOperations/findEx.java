package streamOperator.terminalOperations;

import java.util.Optional;
import java.util.stream.Stream;

public class findEx {
    public static void main(String[] args) {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};

        Optional<String> firstColor = Stream.of(colors).findFirst();

        firstColor.ifPresent(color -> System.out.println("First color: " + color)); // "First color: Red" 출력

        Optional<String> anyColor = Stream.of(colors).findAny();

        anyColor.ifPresent(color -> System.out.println("Any color: " + color)); // 예: "Any color: Green" 출력

        Optional<String> anyColorParallel = Stream.of(colors).parallel().findAny();

        anyColorParallel.ifPresent(color -> System.out.println("Any color (parallel): " + color)); // 예: "Any color (parallel): Blue" 출력
    }
}
