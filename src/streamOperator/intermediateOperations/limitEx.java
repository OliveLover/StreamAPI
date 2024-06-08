package streamOperator.intermediateOperations;

import java.util.stream.Stream;

public class limitEx {
    public static void main(String[] args) {
        // 1부터 시작하는 무한 스트림 생성
        Stream<Integer> infiniteStream = Stream.iterate(1, i -> i + 1).peek(infinite -> System.out.println("infinite : " + infinite));

        Stream<Integer> limitedStream = infiniteStream.limit(5);

        limitedStream.forEach(System.out::println);
    }
}
