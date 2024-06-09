package quiz.quiz5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class quiz5 {
    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public static void main(String[] args) {
        // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
        // my answer
        int totalLength1 = Arrays.stream(STRING_ARR).mapToInt(String::length).reduce(Integer::sum).orElse(0);
        System.out.println("totalLength1 : " + totalLength1);

        // answer
        int totalLength2 = Arrays.stream(STRING_ARR).mapToInt(String::length).sum();
        System.out.println("totalLength2 : " + totalLength2);

        // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
        // my answer
        int maxString1 = Arrays.stream(STRING_ARR).mapToInt(String::length).max().orElse(0);
        System.out.println("maxString1 = " + maxString1);

        // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
        // answer
        List<Integer> lottoNumber = new Random()
                .ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .toList();

        System.out.println("lottoNumber = " + lottoNumber);

        // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
        // my answer
        Map<Integer, List<int[]>> sumGroup = IntStream.rangeClosed(1, 6)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, 6).boxed().map(j -> new int[]{i, j}))
                .collect(Collectors.groupingBy(arr -> arr[0] + arr[1]));
        sumGroup.get(6).forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println();

        // answer
        List<Integer[]> sumList = IntStream
                .rangeClosed(1, 6)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, 6).boxed().map(j -> new Integer[] {i, j}))
                .filter(arr -> arr[0] + arr[1] == 6)
                .toList();

        sumList.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
