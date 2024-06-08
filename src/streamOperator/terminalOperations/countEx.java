package streamOperator.terminalOperations;

import java.util.stream.Stream;

public class countEx {
    public static void main(String[] args) {
        // 문자 배열을 Stream으로 변환
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Stream<String> colorStream = Stream.of(colors);

        // Stream의 요소 수를 연산
        long count = colorStream.count();

        System.out.println("count = " + count);
    }
}
