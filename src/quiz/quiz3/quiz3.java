package quiz.quiz3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class quiz3 {
    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public static void main(String[] args) {
        // 3.1 모든 숫자 쌍의 배열 리스트를 반환하여라.
        // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]

        // answer
        List<Integer[]> numberList1 = numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[]{n, m}))
                .toList();

        numberList1.forEach(list -> System.out.println(Arrays.toString(list)));

        // 3.2 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
        // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12

        // my answer
        int maxProductNumber1 = numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> n * m))
                .mapToInt(a -> a)
                .max().orElse(0);

        System.out.println("maxResult1 : " + maxProductNumber1);

        // answer
        int maxProductNumber2 = numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new int[] {n, m}))
                .mapToInt(a -> a[0] * a[1])
                .max().orElse(0);

        System.out.println("maxResult2 : " + maxProductNumber2);
    }
}
