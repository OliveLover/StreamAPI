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

    /**
     * Runnable의 run() 메서드 구현
     */

    private void runCommonThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(runnable).start();
    }

    /**
     * Runnable은 run() 메서드 밖에 없기 때문에 아래와 같이 람다 표현식으로 처리가 가능합니다.
     */

    private void runThread() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }

    /**
     * 중괄호를 제거하고 출력문 뒤의 세미콜론을 지워도 정상적으로 컴파일이 수행됩니다.
     */

    private void runThreadSimple() {
        new Thread(() -> System.out.println(Thread.currentThread().getName()));
    }
}