package quiz.quiz2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class quiz2 {
    private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea", "Bus", "Bus");

    public static void main(String[] args) {
        // 문제 2.1 : List에 저장된 단어들의 접두사가 각각 몇개 있는지 Map<String, Integer>으로 변하여라
        // ex) ("T", 1), ("a", 2)

        // answer
        Map<String, Integer> map = WORDS.stream()
                .map(w -> w.substring(0, 1))
                .collect(Collectors.toMap(prefix -> prefix, prefix -> 1, (oldValue, newValue) -> oldValue + newValue));

        System.out.println("map = " + map);

        // 문제 2.2 : List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
        // ex) ["Hello", "a", "Island", "b"] -> “H I”

        // my answer
        WORDS.stream()
                .filter(w -> w.length() >= 2)
                .map(w -> w.charAt(0) + " ")
                .map(String::toUpperCase)
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

        // answer
        String str = WORDS.stream()
                .filter(w -> w.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));

        System.out.println("str = " + str);
    }
}
