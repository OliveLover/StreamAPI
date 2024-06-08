<h1>Stream API</h1>

<h3>1. Lambda 표현식(expression)</h3>

<p>익명 클래스를 사용하면 가독성이 떨어지고 불편합니다. 이를 보완하기 위하여 람다 표현식이 만들어 졌습니다.<br />
람다 표현식은 대신에 메서드가 "하나"인 것들만 적용 가능합니다.</p>
<br />
<p>Java에 있는 메서드가 하나인 인터페이스</p>
<ul>
  <li>java.lang.Runnable</li>
  <li>java.util.Comparator</li>
  <li>java.io.FileFilter</li>
  <li>java.security.PrivilegeAction</li>
  <li>java.nio.file.PathMatcher</li>
  <li>java.lang.reflect.InvocationHandler</li>
</ul>

<h4>람다 표현식의 예</h4>

```
(int x, int y) -> x + y

() -> 43

(String s) -> { System.out.println(s); }
```

<h4>람다 표현식의 구조</h4>

|매개 변수 목록|화살표 토큰(Arrow Token)|처리 식|
|:---:|:---:|:---:|
|(int x, int y)|->|x + y|

<h4>람다 표현식의 특징</h4>
<ul>
  <li>람다 표현식은 단순한 처리를 위하여 익명 클래스를 만들 필요가 없기 때문에 필요한 코드의 양이 줄어듭니다.<br />

```
// 익명 클래스 사용
Runnable r1 = new Runnable() {
  @Override
  public void run(){
    System.out.println("Hello World!");
  }
}

// 람다 표현식 사용
Runnable r2 = () -> System.out.println("Hello World!");
```
  
  </li>
  <li>
    람다 표현식은 함수로 처리되기 때문에 .class 파일을 생성하지 않습니다.
  </li>
  <li>
    자바에서 제공하는 Functional Interface를 활용할 수 있습니다.
  </li>
</ul>

<h3>2. 함수형 인터페이스(Functional Interface)</h3>

> <h4>Supplier 인터페이스</h4>

```
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

<h4>주요 특징</h4>
<ul>
  <li><code>T get()</code> : 인수를 받지 않고, <code>T</code>의 객체를 반환합니다.</li>
</ul>

```
// 기본 사용법
Supplier<String> stringSupplier  =  () -> "Hello World!";
System.out.println(stringsSpplier.get()); // "Hello World!" 출력

// 메서드 참조
Supplier<Double> randomSupplier = Math::random;
System.out.println(randomSupplier.get()); // 0.4471631248628112 출력
```

> <h4>Consumer 인터페이스</h4>

```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```

<h4>주요 특징</h4>
<ul>
  <li>단일 인수를 받아 아무것도 반환하지 않는 동작을 정의합니다.</li>
  <li><code>void accpet(T t)</code> : 주어진 인수를 소비하고 반환값이 없습니다.</li>
  <li><code>default Consumer<T> andThen(Consumer<? super T> after)</code> : <code>Consumer</code>를 실행 후에 다른 <code>Consumer</code>를 실행할 수 있도록 합니다.</li>
  <li><code>after</code>매개변수 뒤로 전달된 <code>Consumer</code>가 현재 <code>Consumer</code>다음에 실행됩니다.</li>
</ul>

```
// ex
Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
consumer.andThen(System.out::println).accept("Hello World!");

// 출력
// > Hello
// > Hello World!

// ex2
List<String> strings = Arrays.asList("apple", "banana", "cherry");
Consumer<String> printConsumer = System.out::println;
strings.forEach(printConsumer);

// 출력
// > apple
// > banana
// > cherry
```

> <h4>Function 인터페이스</h4>

```
@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

<h4>주요 특징</h4>
<ul>
  <li><code>T</code> 타입의 입력을 받아 <code>R</code>타입을 반환합니다.</li>
  <li><code>default <V> Function<V, R> compose(Function<? super V, ? extends T> before)</code> : 현재 Function을 다른 Function(before)의 입력으로 사용하여 그 Function을 실행한 결과를 현재 Function의 입력으로 하여 최종 결과를 반환합니다.</li>
  <li><code>default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)</code> : 현재 Function의 결과를 다른 Function(after)의 입력으로 사용하여 그 Function을 실행한 결과를 반환합니다.</li>
  <li><code>static <T> Function<T, T> identity()</code> : 동일한 입력을 받아 그대로 반환하는 Function을 생성하여 반환합니다.</li>
</ul>

```
// ex
Function<String, Integer> function = str -> str.length();
System.out.println(function.apply("Hello World!")); // 12 출력

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
```

> <h4>Predicate 인터페이스</h4>

```
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }

    @SuppressWarnings("unchecked")
    static <T> Predicate<T> not(Predicate<? super T> target) {
        Objects.requireNonNull(target);
        return (Predicate<T>)target.negate();
    }
}
```
<h4>주요 특징</h4>
<ul>
  <li><code>boolean test(T t)</code> : <code>T</code>를 매개변수로 받아 <code>boolean</code> 타입을 반환합니다.</li>
  <li><code>default Predicate<T> and(Predicate<? super T> other)</code> : 두 개의 <code>Predicate</code>를 조합하여 논리적 "AND"연산을 수행하며, 현재의 <code>Predicate</code>가 <code>false</code>일 때 다른 <code>Predicate</code>를 판단하지 않습니다.</li>
  <li><code>default Predicate<T> negate()</code> : <code>Predicate</code>의 결과를 반전시켜 새로운 <code>Predicate</code>를 생성합니다.</li>
  <li><code>default Predicate<T> or(Predicate<? super T> other)</code> : 두 개의 <code>Predicate</code>를 조합하여 "OR"연산을 수행하며, 현재의 <code>Predicate</code>가 <code>true</code>일 때 다른 <code>Predicate</code>는 판단하지 않고 바로 <code>true</code>를 반환 합니다.</li>
  <li><code>static <T> Predicate<T> isEqual(Object targetRef)</code> : 두 인수가 동일한지를 판별합니다.</li>
  <li><code>static <T> Predicate<T> not(Predicate<? super T> target)</code> : <code>negate()</code>를 호출하여 결과를 반전 시킵니다. 정적 매서드로 기존의 객체는 변하지 않고 반전된 객체를 새롭게 생성합니다.</li>
</ul>

```
// ex
Predicate<String> predicate = (str) -> str.equals("Hello World!");
System.out.println(predicate.test("Hello World!")); // true 출력

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
```

> <h4>그외 </h4>
<h4>UnaryOperator 인터페이스 :  A unary operator from T -> T</h4>
<p>apply()라는 하나의 매개 변수를 갖는 메서드가 있으며, 리턴값도 존재합니다. 단, 한 가지 타입에 대하여 결과도 같은 타입일 경우 사용합니다.</p><br />

<h4>BinaryOperator 인터페이스 : A binary operator from (T, T) -> T</h4>
<p>apply()라는 두개의 매개 변수를 갖는 메서드가 있으며, 리턴값도 존재합니다. 단, 한 가지 타입에 대하여 결과도 같은 타입일 경우 사용합니다.</p>

<hr />

<h3>2. Stream</h3>

<p>자바의 스트림은 컬렉션과 같은 연속된 정보를 처리하는데 사용합니다. 컬렉션에는 스트림을 사용할 수 있지만, 배열에는 스트림을 사용할 수 없습니다. 하지만, 배열을 컬렉션의 <code>List</code>로 변환하는 방법이 존재합니다.</p>

```
Integer[] values = { 1, 3, 5 };
List<Integer> list = new ArrayList<Integer>(Arrays.asList(values));
```

<p>위와 같이 <code>Arrays</code>클래스의 <code>asList()</code> 메서드로 변환이 가능합니다.</p>

```
Integer[] values = { 1, 3, 5 };
List<Integer> list = Arrays.stream(values).collect(Collectors.toList());
```

<p>위와 같이 <code>stream()</code>메서드를 사용하는 방법도 있습니다.</p>

<h4>스트림의 구조</h4>

<p>스트림은 다음과 같은 구조를 가집니다.</p>

```
// ex

list.stream().filter(x-> x>10).count()
// 스트림 생성 : stream()
// 중개 연산 : filter()
// 종단 연산 : count() 
```

<ul>
  <li>스트림 생성 : 컬렉션의 목록을 스트림 객체로 변환합니다.</li>
  <li>중개 연산 : 생성된 스트림 객체를 사용하여 중개 연산 부분에서 처리합니다. 이 부분에서는 아무런 결과를 리턴하지 못합니다.</li>
  <li>종단 연산 : 중개연산에서 작업된 내용을 바탕으로 결과를 리턴합니다.</li>
</ul>

<h4>주로 사용하는 연산자</h4>

|연산자|설명|
|:---|:---|
|filter(pred)|데이터를 조건으로 거를 때 사용|
|map(mapper)|데이터를 특정 데이터로 변환|
|forEach(block)|for 루프를 수행하는 것처럼 각각의 항목을 꺼냄|
|flatMap(flat-mapper)|스트림의 데이터를 잘게 쪼개서 새로운 스트림 제공|
|sorted(comparator)|데이터 정렬|
|toArray(array-factory)|배열로 변환|
|any / all / noneMatch(pred)|일치하는 것을 찾음|
|findFirst / Any(pred)|맨 처음이나 순서와 상관없는 것을 찾음|
|reduce(binop) / reduce(base, binop)|결과를 취합|
|collect(collector)|원하는 타입으로 데이터를 리턴|

<h4>종단 연산(Terminal Operations)</h4>

> <h5>forEach(Consumer)</h5>
<p><code>forEach()</code>는 각 요소에 대해 지정된 동작을 파이프라인에서 처리하는 종단 연산입니다.</p>

```
// 문자 배열을 Stream으로 변환
String[] colors = {"Red", "Green", "Blue", "Yellow"};
Stream<String> colorStream = Stream.of(colors);

// Stream의 각 요소에 대해 forEach연산 수행.
colorStream.forEach(System.out::println);

// 출력
// > Red
// > Green
// > Blue
// > Yellow
```

> <h5>count()</h5>
<p><code>stream</code>의 요소수를 <code>long</code>타입으로 반환합니다.</p>

```
// 문자 배열을 Stream으로 변환
String[] colors = {"Red", "Green", "Blue", "Yellow"};
Stream<String> colorStream = Stream.of(colors);

// Stream의 요소 수를 연산
long count = colorStream.count();

System.out.println("count = " + count); // "count = 4" 출력
```

> <h5>collect(Collector)</h5>
<p><code>Stream</code>의 요소를 수집합니다.</p>

```
// 문자 배열을 Stream으로 변환
String[] colors = {"Red", "Green", "Blue", "Yellow"};
Stream<String> colorStream = Stream.of(colors);

Map<Integer, List<String>> lengthMap = colorStream.collect(Collectors.groupingBy(String::length));

System.out.println("lengthMap = " + lengthMap); // lengthMap = {3=[Red], 4=[Blue], 5=[Green], 6=[Yellow]} 출력
```

> <h5>reduce(BinaryOperator)</h5>
<p><code>Stream</code>의 요소를 차례대로 더해 나갑니다.</p>

```
// 정수 배열을 Stream으로 변환
Integer[] numbers = {1, 2, 3, 4, 5};
Stream<Integer> numberStream = Stream.of(numbers);

Optional<Integer> sum = numberStream.reduce((a, b) -> {
    int result = a + b;
    System.out.println(a + " + " + b + " = " + result);
    return result;
});

sum.ifPresent(result -> System.out.println("Sum of numbers: " + result));

// 출력
// > 1 + 2 = 3
// > 3 + 3 = 6
// > 6 + 4 = 10
// > 10 + 5 = 15
// > Sum of numbers: 15
```

> <h5>min(Comparator), max(Comparator)</h5>
<p><code>Stream</code>에서 최소값과 최대값을 찾습니다.</p>

```
// 문자 배열을 Stream으로 변환
String[] colors = {"Red", "Green", "Blue", "Yellow"};
Stream<String> colorStream = Stream.of(colors);

Optional<String> minColor = colorStream.min(Comparator.naturalOrder());

minColor.ifPresent(result -> System.out.println("Min color (alphabetically): " + result));

// 닫힌 스트림은 재사용이 불가하므로 새로 할당
colorStream = Stream.of(colors);

Optional<String> maxColor = colorStream.max(Comparator.naturalOrder());

maxColor.ifPresent(result -> System.out.println("Max color (alphabetically): " + result));

// 출력
// > Min color (alphabetically): Blue
// > Max color (alphabetically): Yellow
```

> <h5>findAny(), findFirst()</h5>
<p><code>findFirst()</code>는 항상 <code>Stream</code>의 첫 번째 요소를 반환하며, <code>findAny()</code>는 임의의 요소를 반환합니다.</p>

```
String[] colors = {"Red", "Green", "Blue", "Yellow"};

Optional<String> firstColor = Stream.of(colors).findFirst();

firstColor.ifPresent(color -> System.out.println("First color: " + color)); // "First color: Red" 출력

Optional<String> anyColor = Stream.of(colors).findAny();

anyColor.ifPresent(color -> System.out.println("Any color: " + color)); // 예: "Any color: Green" 출력

Optional<String> anyColorParallel = Stream.of(colors).parallel().findAny();

anyColorParallel.ifPresent(color -> System.out.println("Any color (parallel): " + color)); // 예: "Any color (parallel): Blue" 출력
```

> <h5>allMatch(Predicate), anyMatch(Predicate), noneMatch(Predicate)</h5>
<ul>
  <li><code>allMatch()</code> : 스트림의 모든 요소가 주어진 조건을 만족하는지 확인합니다.</li>
  <li><code>anyMatch()</code> : 스트림의 임의의 요소가 주어진 조건을 만족하는지 확인합니다.</li>
  <li><code>noneMatch()</code> : 스트림의 모든 요소가 주어진 조건을 만족하지 않는지 확인합니다.</li>
</ul>

```
Integer[] numbers = {2, 4, 6, 8, 10};
Stream<Integer> numberStream = Stream.of(numbers);

boolean allEven = numberStream.allMatch(n -> n % 2 == 0);

System.out.println("All numbers are even: " + allEven); // "All numbers are even: true" 출력

numberStream = Stream.of(numbers);

boolean anyGreaterThanFour = numberStream.anyMatch(n -> n > 4);

System.out.println("Any number greater than 4: " + anyGreaterThanFour); // "Any number greater than 4: true" 출력

numberStream = Stream.of(numbers);

boolean noneGreaterThanEleven = numberStream.noneMatch(n -> n > 11);

System.out.println("No number greater than 11: " + noneGreaterThanEleven); // "No number greater than 11: true" 출력

```

> <h5>toArray()</h5>
<p>특정 타입의 배열로 변환할 수 있습니다.</p>

```
String[] colors = {"Red", "Green", "Blue", "Yellow"};
Stream<String> colorStream = Stream.of(colors);

Object[] colorArray = colorStream.toArray();

for (Object color : colorArray) {
    System.out.println(color);
}
```

> <h5>forEachOrdered(Consumer)</h5>
<p><code>Stream</code>의 요소를 순서대로 처리합니다. 병렬 스트림에서도 순서가 유지됩니다.</p>

```
Integer[] numbers = {1, 2, 3, 4, 5};
Stream<Integer> numberStream = Stream.of(numbers).parallel();

System.out.println("Parallel Stream with forEachOrdered:");
numberStream.forEachOrdered(System.out::println);

// 출력
// > Parallel Stream with forEachOrdered:
// > 1
// > 2
// > 3
// > 4
// > 5
```

> <h5>iterator()</h5>
<p><code>Stream</code>의 요소를 순차적으로 접근할 수 있는 <code>Iterator</code>를 얻습니다.</p>

```
Integer[] numbers = {1, 2, 3, 4, 5};
Stream<Integer> numberStream = Stream.of(numbers);

Iterator<Integer> iterator = numberStream.iterator();

System.out.println("Stream elements:");
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

// 출력
// > Stream elements:
// > 1
// > 2
// > 3
// > 4
// > 5
```
