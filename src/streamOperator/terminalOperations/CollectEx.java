package streamOperator.terminalOperations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx {
    public static void main(String[] args) {
        // 문자 배열을 Stream으로 변환
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Stream<String> colorStream = Stream.of(colors);

        Map<Integer, List<String>> lengthMap = colorStream.collect(Collectors.groupingBy(String::length));

        System.out.println("lengthMap = " + lengthMap);
    }
}
