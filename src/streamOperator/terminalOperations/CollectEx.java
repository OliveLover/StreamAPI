package streamOperator.terminalOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectEx {
    public static void main(String[] args) {
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Red", "Green"};

        // toList() : 스트림 요소를 리스트로 수집
        List<String> transList1 = Stream.of(colors).collect(Collectors.toList());
        List<String> transList2 = Stream.of(colors).toList();

        System.out.println("transList1 = " + transList1);
        System.out.println("transList2 = " + transList2);

        // toSet() : 스트림 요소를 셋으로 수집
        Set<String> transSet = Stream.of(colors).collect(Collectors.toSet());

        System.out.println("transSet = " + transSet);

        // joining() : 문자열 스트림의 요소를 결합하여 하나의 문자열로 수집
        String strJoin = Stream.of(colors).collect(Collectors.joining("_"));

        System.out.println("strJoin = " + strJoin);

        // groupingBy() : 스트림 요소를 그룹화하여 맵으로 수집
        Map<Integer, List<String>> lengthMap = Stream.of(colors).collect(Collectors.groupingBy(String::length));

        System.out.println("lengthMap = " + lengthMap);

        // partitioningBy() : 스트림 요소를 분하여 맵으로 수집
        IntStream numbers = IntStream.rangeClosed(1, 10);

        Map<Boolean, List<Integer>> evenOddMap = numbers.boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even numbers : " + evenOddMap.get(true));
        System.out.println("Odd numbers :   " + evenOddMap.get(false));

        Map<Boolean, List<String>> colorPartition = Stream.of(colors).collect(Collectors.partitioningBy(color -> color.length() > 3));

        System.out.println("More than 3 characters : " + colorPartition.get(true));
        System.out.println("No more than 3 characters : " + colorPartition.get(false));

        // reducing() :
        String chainColors = Stream.of(colors).collect(Collectors.reducing((s1, s2) -> s1 + s2)).orElse("");

        System.out.println("chainColors : " + chainColors);
    }
}
