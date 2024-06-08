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
System.out.println(stringsSpplier.get());

// 출력 > Hello World!

// 메서드 참조
Supplier<Double> randomSupplier = Math::random;
System.out.println(randomSupplier.get());

// 출력 > 0.4471631248628112
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
