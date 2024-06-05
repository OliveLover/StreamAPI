package functionalInterface;

public class FunctionalInterface {
    public static void main(String[] args) {
        // 기존의 익명 함수
        System.out.println("기존의 익명 함수 : " + new MyLambdaFunction() {
            public int add (int a, int b) {
                return a + b;
            }
        }.add(4, 7));

        // 출력 : 11

        MyLambdaFunction2 lambdaFunction2 = (int a, int b) -> a + b;
        System.out.println("람다식을 이용한 익명 함수 : " + lambdaFunction2.add(4, 7));

        // 출력 : 11
    }
}