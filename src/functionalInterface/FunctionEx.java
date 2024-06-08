package functionalInterface;

import java.util.function.Function;

public class FunctionEx {
    public static void main(String[] args) {
        // ex
        Function<String, Integer> function = str -> str.length();
        System.out.println(function.apply("Hello World!"));

        // ex
        // 두 함수를 정의합니다.
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;

        // compose() 메서드를 사용하여 두 함수를 조합합니다.
        Function<Integer, Integer> composedFunction = addOne.compose(multiplyByTwo);

        // andThen() 메서드를 사용하여 두 함수를 조합합니다.
        Function<Integer, Integer> andThenFunction = addOne.andThen(multiplyByTwo);

        // 조합된 함수를 사용하여 결과를 계산합니다.
        int result1 = composedFunction.apply(5); // (5 * 2) + 1 = 11
        int result2 = andThenFunction.apply(5); // (5 + 1) * 2 = 12

        System.out.println("Composed Function Result: " + result1); // "Composed Function Result: 11" 출력
        System.out.println("AndThen Function Result: " + result2); // "AndThen Function Result: 12" 출력
    }

}