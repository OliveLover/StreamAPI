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
