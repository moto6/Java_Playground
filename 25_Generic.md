# 자바 14주차 제네릭 정리

## 목차

- 제네릭 사용법
- 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
- 제네릭 메소드 만들기
- Erasure

<br><br>

-------------------

<br><br>

## 제네릭이란?
- 컴파일타임 타입체크해주는 기능
- 타입오류를 컴파일타임에 잡아내기 위해서 사용

### 제네릭의 특징
- 제네릭을 쓰면 data type이 generalize된다(타입을 일반화한 문법)
- Data type 이 변해도 동일한 코드를 재사용 할수 있게 된다
- 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정해둔다
- 컴파일 시 type check를 하는데, 런타임시 매번 타입체크를 하는 방식에 비해 장점이 많다

### 장점

- 컴파일 타임 에러보다 런타임에러가 압도적으로 디버깅이 편하므로, 제네릭을 사용하면 형변환 에러를 컴파일타임에 찾을수 있어서 런타임에 (객체의 타입의) 안정성이 놓다
- 타입 변환 && 타입 검사를 덜 신경써도 된다 : 제네릭을 사용하면 잘못된 타입이 사용될 수 있는 문제를 컴파일타임에 제거 가능
- 런타임의 타입체크/형변환 생략할 수 있어 성능이 좋다 :  프로그램 성능 향상 (타입변환을 할 필요가 없다)


### 이 기술을 쓰게 된 배경과 과거이야기 
- Java 5 이전에서는 여러 타입을 사용하는 대부분의 클래스나 메소드에서 인수나 반환값으로 Object타입을 사용했었는데
- 이 경우에는 반환된 Object 객체를 다시 원하는 타입으로 타입을 변환해야하고 이때 형변환 실수로 인해 TypeCastException가 발생할 가능성도 있었는데
- 이 문제를 해결하기 위해 Java5 이후에 도입된 제네릭을 사용해 문제를 해결했는데, 컴파일타임에 컴파일러가 타입을 알고 타입이 정해진다
- 따라서 과거에 런타임에 코드로 하던 타입 검사나 타입 변환과 같은 번거로운 작업을 생략할 수 있게 되어서 제네릭을 쓴다
- Java5 이전에 Object형으로 반환하던 코드들과의 호환성을 위해서 **``raw-type-generic``** 이라는걸 만들었는데, 2021년 기준 **``raw-type-generic``** 은 쓸 필요가 없다.


<br><br>

-------------------

<br><br>


## 제네릭을 선언하고 사용하는 방법

- 타입을 파라미터로 가지는 클래스/인터페이스 가 제네릭이다
- 클래스/인터페이스 이름 뒤 <> 기호 이후 타입 파라미터
- 알파벳 대문자 한글자가 디-펙토

### 형식

```java
public class 클래스명<T> {...} 
public interface 인터페이스명<T> {...}
```

### 예제코드

```java
interface Tux<T> {
    public T getData();
    public void setData(T data);
}

class Lux<T> implements Tux<T> {
    T data;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}
```

```java
<타입인자 > 설명

<T> Type 
<E> Element
<K> Key
<N> Number 
<V> Value 
<R> Result
```

### 예제

```java
public class Box<T> {            // 타입 파라미터 T를 사용하여 Object 타입을 t로 변경
    private T t;
    public T get() {
        return T;
    }
    public void set(T t) {
        this.t = t;
    }
}
    // Box 클래스로 객체를 생성할 때 구체적인 타입으로 변경된다
    Box<String> box = new Box<String>();

// 타입 파라미터 T는 String 타입으로 변경되어 Box 클래스 내부는 다음과 같이 자동으로 재구성된다.
public class Box<String> {
    private String t;
    public String get() {
        return T;
    }
    public void set(String t) {
        this.t = t;
    }
}   
```

```java
// 필드 타입, set 파라미터 와 get 리턴타입 모두 String 타입으로 변경되었기에 저장, 읽을 때 타입 변환 일어나지 않는다.
Box<String> box = new Box<String>();
box.set("hello");
String str = box.get();
```

### 제네릭 인터페이스

```java
interface ExInterfaceGeneric<T> {
  T example(); 
}

class ExGeneric implements ExInterfaceGeneric<String> {
  @Override public String example() {
    return null;
  }
}
```

- 인터페이스도 위와 같이 클래스처럼 제네릭으로 설정해두고 활용할 수 있다.

### 멀티타입 파라미터

```java
public class GenericTest<A, B, C> {
    private A first;
    private B second;
    private C third;

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public void setThird(C third) {
        this.third = third;
    }

    public void show() {
        System.out.println("A의 타입은 : " + first.getClass().getTypeName());
        System.out.println("B의 타입은 : " + second.getClass().getTypeName());
        System.out.println("C의 타입은 : " + third.getClass().getTypeName());
    }

    public static void main(String[] args) {
        GenericTest<String, Integer, Double> genericTest = new GenericTest<>();
        genericTest.setFirst("안녕하세요.");
        genericTest.setSecond(10);
        genericTest.setThird(10.0);
        genericTest.show();
    }
} // 결과 A의 타입은 : java.lang.String B의 타입은 : java.lang.Integer C의 타입은 : java.lang.Double Process finished with exit code 0
```


### 바운디드 타입

- under bounded : 객체 정의할 때 사용 불가. 메소드 파라미터에 사용 가능, 클래스 뿐 아니라 인터페이스도 지원.
- Dao 객체에 generic 적용해볼수 있고, 런타임 중에 제네릭 타입을 알아낼 수 있을까? yes. 리플렉션으로 가능
- 제한된 타입 파라미터( <T extends 최상위타입> )  : 클래스 혹은 인터페이스 타입 파라미터의 상위 타입을 제한
- 메소드의 중괄호 {} 안에서 타입 파라미터 변수로 사용 가능한 것은 상위 타입의 멤버(필드, 메소드)로 제한. 하위 타입에만 있는 필드, 메소드 사용 불가


## 와일드 카드

- 와일드카드 타입 (<?>, <? extends ...> , <? super ...> )

코드에서 ?를 일반적으로 와일드카드(wildcard)라고 부른다. 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신에 와일드카드를 다음과 같이 세 가지 형태로 사용할 수 있다.

- 제네릭타입<?> : Unbounded Wildcards(제한없음)
    - 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다.
- 제네릭타입<? extends 상위타입> : Upper Bounded Wildcards(상위클래스 제한)
    - 타입 파라미터를 대치하는 구체적인 타입으로 상위 타입이나 하위 타입만 올 수 있다.
- 제네릭타입 <? super 하위타입> : Lower Bounded Wildcards (하위클래스 제한)
    - 타입 파라미터를 대치하는 구체적인 타입으로 하위 타입이나 상위 타입이 올 수 있다.



## 바운디드 타입과 와일드 카드
제네릭 타입 코드 에서 와일드 카드 라고하는 물음표 ( ? ) 는 알 수 없는 유형을 나타낸다. 와일드 카드는 파라미터 변수, 필드 또는 지역변수의 타입 등 다양한 상황(때때로 리턴 타입에도 사용할 수 있음.)에서 사용할 수 있다. 와일드 카드는 제네릭 메서드 호출, 제네릭 클래스 인스턴스 생성 또는 수퍼 타입의 타입 인자로는 사용될 수 없다.
상한 바운디드(Upper Bounded) 와일드 카드Permalink
상한 와일드 카드를 사용하여 변수에 대한 제한을 완화 할 수 있습니다. 예를 들어 List<Integer>, List<Double>,List<Number>를 동시에 사용하고 싶을때 이 방법을 사용합니다.

예) public static void process(List<? extends Foo> list) { /* … */ }

무제한(Unbounded) 와일드 카드Permalink
Object 클래스 에서 제공하는 기능을 사용하여 구현할 수있는 메서드를 작성하는 경우 .
코드가 타입 파라미터에 의존하지 않는 제네릭 클래스의 메서드를 사용하는 경우. 예를 들어, List.size 또는 List.clear 입니다.
예) public static void process(List<?> list) { /* … */ }

하한 바운디드(lower bounded) 와일드 카드Permalink
하위 경계와일드카드는 알 수 없는 타입을 특정 타입 또는 해당 타입의 부모 타입으로 제한합니다.

예) public static void process(List<? super Foo> list) { /* … */ }


### Upper Bounded Wildcards

상한 와일드 카드를 사용하여 바운디드 타입의 상위 제한을 완화할 수 있다.

<? extends UpperBound>

### Lower Bounded Wildcards

하한 와일드 카드는 상한 와일드 카드와 비슷한 방식으로 제네릭 타입을 특정 타입의 상위 클래스로 제한한다.

<? super LowerBound>



### Unbounded Wildcards

두 가지 시나리오에서 와일드 카드를 별도의 상하한계 없이 사용한다. <?>

Object 클래스에서 제공하는 기능만을 사용하여 구현할 수 있는 메서드를 작성하는 경우 .
코드가 타입 매개변수에 의존하지 않는 제네릭 클래스의 메소드를 사용하는 경우.(예를 들어, List.size() 또는 List.clear().)


### 와일드 카드 주의사항

와일드 카드를 사용한 제네릭 List 타입은 비공식적으로 read-only로 간주된다. 하지만 아래 작업이 가능하기 때문에 이 말이 완전히 보장되지는 않는다.

null 을 추가 할 수 있다 .
clear 를 호출 할 수 있다 .
iterator를 가져오고 remove를 호출 할 수 있다 .
와일드 카드를 캡처하고 List에서 읽은 요소를 쓸 수 있다.


## 제네릭 메소드 만들기

- 제네릭 메소드(<T,R> R method(T t)) : 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드
- 선언 방법 : 리턴 타입 앞에 <> 기호를 추가하고 타입 파라미터를 기술한 다음, 리턴 타입과 매개 타입으로 타입 파라미터를 사용하면 됨.

```java
public <타입파라미터, ...> 리턴타입 메소드명(매개변수 ,... ) { 

}

// boxing() 제네릭 메소드는 <> 기호 안에 타입 파라미터 T를 기술한 뒤, 매개 변수 타입으로 T를 사용하였고,
// 리턴 타입으로 제네릭 타입 Box<T>를 사용했다.
public <T> Box<T> boxing(T t) {

}
```

- 제네릭 메소드 호출 방법

```java
리턴타입 변수 = <구체적타입> 메소드명(매개값) ; 	//명시적으로 구체적 타입을 지정
Box<Integer> box = <Integer>boxing(100);

리턴타입 변수 = 메소드명(매개값); 	// 매개값을 보고 구체적 타입 추정 
Box<Integer> box = boxing(100);
```

## Erasure

- 실행 시간에 제네릭은 모두 raw 형태 (제네릭 타입에서 타입이 소거된 타입).
- 제네릭 타입을 정의하면 해당 타입은 로(raw) 타입으로 컴파일된다.

```java
public class Product<T, M> {
	private T kind;
    private M model;
    
    
    public T getKind() { return this.kind; }
    public M getModel() { return this.model; }
    
    public void setKind(T kind){ this.kind = kind; }
    public void setModel(M model){ this.model = model;}
}

컴파일 후

public class Product<Object, Object> {
	private Object kind;
    private Object model;
    
    
    public Object getKind() { return this.kind; }
    public Object getModel() { return this.model; }
    
    public void setKind(Object kind){ this.kind = kind; }
    public void setModel(Object model){ this.model = model;}
}
```



## Type Erasure
- 컴파일러는 컴파일 타임에 타입 파라미터를 사용하는 대상의 타입을 컴파일러가 정하는 타입으로 대체하는 Type Erasure를 실행하게 된다. 컴파일된 바이트코드에서는 T 대신 특정 타입으로 대체되어 있다.
- Type Erasure의 규칙
  - 제네릭 타입의 타입 파라미터가 상하한이 있는 경우에는 타입 파라미터를 한계 타입으로, 없는 경우 모든 타입 파라미터를 Object로 바꾼다 . 따라서 생성 된 바이트 코드에는 보통의 클래스, 인터페이스 및 메서드 만 포함된다.
type-safety를 유지하기 위해 필요한 경우 타입 캐스팅을 사용할 수 있다.
제네릭 타입을 상속받은 클래스에서는 다형성을 유지하기 위해 브리지 메서드를 생성한다.
제네릭 타입 Erasure



## 제네릭 주의사항 && TMI

### raw 타입

raw 타입은 제네릭을 사용하지 않았던 과거 자바 버전과의 호환성을 위해서 존재하는 타입 매개변수가 없는 제네릭 타입이다.

raw 타입에 매개변수화된 제네릭 타입을 할당할 수 있다.\
```
public class Box<T> {
    private T t;

    public void set(T t) {this.t = t;}
    public T get() {return t;}

    public static void main(String[] args) {
        //raw 타입 생성
        Box rawBox = new Box();

        Box<String> pBox = new Box<>();

        //raw type에 parameterized type 대입
        rawBox = pBox;
    }
}
```
- 반대로 매개변수화된 제네릭 타입에 raw 타입을 대입하면? 또는 raw 타입으로 제네릭 메소드를 호출한다면?
- 오라클 문서에 의하면 unchecked는 컴파일러가 type-safety를 보장하기 위한 타입 검사에 필요한 충분한 타입 정보가 없음을 의미한다고 한다.

@SuppressWarnings 애노테이션으로 경고를 무시할 수 도 있다.
- raw 타입은 제네릭 타입 검사를 우회(type-unsafety)하여 안전하지 않은 코드에 의해 런타임 오류로 연장될 수 있으므로 raw 타입을 사용하지 않아야 한다고 말하고 있다.
- 로타입 이펙티브자바 정리 : https://www.notion.so/4735e9a564e64bceb26a1e5d1c261a3d



### 제네릭 메소드
- 제네릭 메소드는 타입 매개변수를 사용하는 메소드이다. 제네릭 타입을 선언하는 것과 비슷하지만 제네릭 메소드에서 타입 매개변수의 scope는 선언 된 메소드로 제한된다.

- 제네릭 메소드의 구문에는 메소드의 리턴 타입 전에 나타나는 꺾쇠 괄호 안에 타입 매개변수 목록이 포함된다. static 제네릭 메소드의 경우 타입 매개변수 섹션이 메소드의 리턴 타입 전에 나타나야한다.
```java
public <타입 파라미터 . . . > 리턴타입 메소드명 (매개변수, . . . ) { . . . }
```

```java
public static <타입 파라미터 . . . > 리턴타입 메소드명 (매개변수, . . . ) { . . . }
```

- 타입 인자를 받고 해당 타입 인자에 해당하는 타입의 객체를 파라미터로 받는 static 제네릭 메소드

```java
public class Util {
    public static <T> WitchPot<T> put(T t) {
        return new WitchPot<>(t);
    }
}
```

### 브릿지 메소드
매개 변수화된 클래스를 확장하거나 매개 변수화된 인터페이스를 구현하는 클래스 또는 인터페이스를 컴파일 할 때, 컴파일러는 유형 삭제 프로세스의 일부로 브릿지 메서드 라는 합성 메서드를 생성할 때도 있습니다. 일반적으로 브리지 메서드에 대해 걱정할 필요가 
없지만 스택 추적시 당황 할 수 있습니다.


### 비검사 경고 제거하기
제네릭을 사용하기 시작하면 수많은 컴파일러 경고를 보게 될 것이다.

- 비검사 형변환 경고
- 비검사 메서드 호출 경고
- 비검사 매개변수화 가변변수 타입 경고
- 비검사 변환 경고
- 등..

제네릭에 익숙해질수록 마주치는 경고는 줄어들겠지만 새로 작성한 코드가 한번에 깨끗하게 컴파일되리라 기대하지는 말자.

비검사에 대한 다양한 예시는 살펴보지 않겠지만, 대게 IDE의 도움을 받아 해결방안을 확인할 수 있다.

**정리**

비검사 경고는 중요하니 무시하지 말자.

모든 비검사 경고는 런타임에 ClassCastException을 일으킬 수 있는 잠재적 가능성을 뜻한다.

경고를 없앨 방법을 찾지 못하겠다면, 그 코드가 타입 안전함을 증명하고 가능한 한 범위를 좁혀 @SuppressWarnings("unchecked") 애너테이션으로 경고를 숨겨라.

그런 다음 경고를 숨기기로 한 근거를 주석으로 남겨라.



### 배열보다는 리스트를 사용하라

배열과 제네릭 타입에는 중요한 차이 두가지가 있다.

**첫번째. 공변과 불공변**

1. **배열은 공변(convariant)이다.** 

    Sub가 Super의 하위타입이라면 배열 Sub[]는 배열 Super[]의 하위 타입이 된다.

    공변 즉, 함께 변한다는 뜻이다.

2. **제네릭은 불공변이다**.

    서로다른 타입 Type1과 Type2가 있을 때, List<Type1>은 List<Type2>의 하위 타입도 아니고 상위 타입도 아니다.

```java
Object[] objectArray = new Long[1];
objectArray[0] = "입력~!";
```

결과

- 런타임 에러가 발생한다.

```java
Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
	at com.ssonsh.study.generics.App.main(App.java:9)
Picked up JAVA_TOOL_OPTIONS: -Djava.net.preferIPv4Stack=true
```

```java
List<Object> objectList = new ArrayList<Long>();
objectList.add("입력~!");
```

결과

- 컴파일 에러가 발생한다

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9798fbbc-c5bf-4c07-9156-8f7be9579f16/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9798fbbc-c5bf-4c07-9156-8f7be9579f16/Untitled.png)



## 제네릭 원시타입 (raw-type-generic)
- 이펙티브 자바를 추천

- 제네릭 선언
```java
class Box<T> {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
```
- rawtype의 사용
```java
//public class Launcher255 {
Box<String> stringBox = new Box<>();
Box<Integer> integerBox = new Box<>();
Box rawBox = new Box<>();
Box rawBox2 = new Box();
Box rawBox3 = stringBox;
Box rawBox4 = integerBox;
```



## 각 언어별 제네릭
### CPP의 제네릭
```c++
using namespace std;
//템플릿, 제네릭
//큰값을 리턴하는 제네릭 함수
template<class T>
T bigger(T a, T b) {
    if (a > b) {
        return a;
    }
    else{
        return b;
    }
        
}

int main()
{
    int a = 10, b = 20;
    char c = 'a', d = 'z';
    cout << bigger(a, b) << endl;
    cout << bigger(c, d) << endl;
}
```



## 참고문헌
- https://docs.oracle.com/javase/tutorial/java/generics/rawTypes.html
- https://docs.oracle.com/javase/tutorial/java/generics/why.html
- https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
- https://rockintuna.tistory.com/102
