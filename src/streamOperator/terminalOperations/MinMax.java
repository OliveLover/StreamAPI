package streamOperator.terminalOperations;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {
        // 문자 배열을 Stream으로 변환
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Stream<String> colorStream = Stream.of(colors);

        Optional<String> minColor = colorStream.min(Comparator.naturalOrder());

        minColor.ifPresent(result -> System.out.println("Min color (alphabetically): " + result));

        // 닫힌 스트림은 재사용이 불가하므로 새로 할당
        colorStream = Stream.of(colors);

        Optional<String> maxColor = colorStream.max(Comparator.naturalOrder());

        maxColor.ifPresent(result -> System.out.println("Max color (alphabetically): " + result));
    }
}
