package streamOperator.terminalOperations;

import java.util.stream.Stream;

public class foreEachEx {
    public static void main(String[] args) {
        // 문자 배열을 Stream으로 변환
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Stream<String> colorStream = Stream.of(colors);

        // Stream의 각 요소에 대해 forEach연산 수행.
        colorStream.forEach(System.out::println);
    }
}
