package functionalInterface;

import java.util.function.Predicate;

public class PredicateEx {
    public static void main(String[] args) {
        // ex
        Predicate<String> predicate = (str) -> str.equals("Hello World!");
        System.out.println(predicate.test("Hello World!"));

        Predicate<Integer> isEven = number -> number % 2 == 0;

        // ex2
        // 짝수 여부를 판별할 숫자
        int number1 = 5;
        int number2 = 10;

        // Predicate를 사용하여 숫자가 짝수인지를 판별합니다.
        boolean result1 = isEven.test(number1); // false
        boolean result2 = isEven.test(number2); // true

        // 결과 출력
        System.out.println(number1 + " is even? " + result1); // "5 is even? false" 출력
        System.out.println(number2 + " is even? " + result2); // "10 is even? true" 출력
    }
}
