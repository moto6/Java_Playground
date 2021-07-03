# 자바 11주차 - 열거형(스터디 할래)

## **목표**
- 자바의 열거형(Enum)에 대한 학습
- enum 정의하는 방법
- java.lang.Enum
- EnumSet

---

## 목차

- Enum개요와 필요성
- 열거형의 prototype, declaration, usage
- 열거형에 멤버 추가하기
- 열거형의 이해
- java.lang.Enum 과 EnumSet

---

## Enum개요와 필요성
- 열거형(Enum) : 한정되고 불연속적인 값만을 갖는 데이터 타입의 일종
  - 예시로 방향(동, 서, 남, 북), 국가(한국, 미국 등등.. 약 200개국), 금융기관(국민은행, 기업은행 등등.. 20개 남짓)
- 예제코드

```java
enum Gogi { Pork, Beef, Chicken, Turkey }

public class ExEnum {
    public static void main(String[] args) {
        
        Gogi pok = Gogi.Pork; // 가장 흔하게 쓰이는 방식 Enum 에 .(dot)연산으로 열거형의 원소에 접근합니다
        
        Gogi kfc = Gogi.valueOf("Chicken"); // 이렇게 문자열에서 Enum으로 변경하며 대입도 가능합니다 1

        Gogi sirloin = Enum.valueOf(Gogi.class, "Beef"); // 이렇게 문자열에서 Enum으로 변경하며 대입도 가능합니다2
        
        Gogi samgyeobsal = Gogi.Pork; // 예를들어 "삼겹살"이라는 변수이름에 고기 이넘을 넣어줄 수 있습니다.


        //들어가 있는 값 확인
        System.out.println("inserted : pok = " + pok);
        System.out.println("inserted : kfc = " + kfc);
        System.out.println("inserted : Sirloin = " + Sirloin);
        System.out.println("");

        //이넘끼리 동등비교도 됩니다.
        System.out.println("compare : pok == kfc? : " + (pok == kfc));
        System.out.println("compare : pok == Sirloin? : " + (pok == Sirloin));
        System.out.println("compare : pok == samgyeobsal? : " + (pok == samgyeobsal));
        System.out.println("compare : Sirloin == beef? : " + (Sirloin == Gogi.Beef));
        System.out.println("");

        //equals 메서드 사용도 가능합니다
        System.out.println("pok equals Sirloin : " + pok.equals(Sirloin));
        System.out.println("pok equals samgyeobsal : " + pok.equals(samgyeobsal));
        
        //compareTo 메서드 사용도 가능합니다.
        System.out.println("pok comp kfc : " + (pok.compareTo(kfc)));
        System.out.println("pok.comp Gogi.Beef : " + (pok.compareTo(Gogi.Beef)));

        //열겨형으로 반복문을 돌리면 이렇게 됩니다.
        System.out.println("\nfoorloop Enum.values() method");
        Gogi[] gogis = Gogi.values();

        for (Gogi gogi : gogis) {
            System.out.printf("%s = %d%n", gogi.name(), gogi.ordinal());
        }
    }
}
```

- 실행결과


### 정적타입 vs 동적타입 구분 기준
- 변수의 Type이 결정되는 시점에 따라서 두가지로 나눠집니다 
  - 컴파일타임에 컴파일러에 의해 변수의 타입이 결정되면 : Statically typed (정적타입)
    : C/C++ , Java, TS(살짝 다르지만..)
    - 컴파일단계에서 대다수 변수들의 Type이 결정되어 있습니다.
    - 당연하게도 소스코드레벨에서부터 Type이 결정되어 있는게 대부분입니다.
  - 런타임(코드 실행중)에 실행환경에 의해 타입이 결정되면 : Dayamically typed, 동적타입
    : Python, JS
    - 컴파일단계에서는 변수의 Type이 대부분 결정되지 않은 상태입니다.
- 언어는 저마다 변수의 Type이 결정되는 "시기"에 따라서 동적이냐 정적이나로 구별할 수 있습니다.
- 아무리 Java와 같이 Statically typed(정적타입) 프로그래밍 언어라도 컴파일타임에 결정할 수 없는 경우가 종종 있는데, 대표적으로 "타입 변환" 동작코드에서는 런타임에 변수의 타입이 결정된다.
  ```java
    Object jackson = new Object();
    Person person = (Person)jackson
  ```
  - 그래서 결국 Statically typed 언어를 사용할지라도 일정부분은 불가피하게 Dayamically typed하는 부분이 발생할수 있고 **이 부분에서 논리적 에러가 발생할 가능성이 존재합니다 !**
- 소스코드에는 Type이 결정되지 않고 컴파일타임에 결정되는 문법적인 요소가 있는데 이를 Generic(자바 제네릭) 이라고 합니다.
  - 제네릭 링크 : 나중에추가예정

---

## Enum의 prototype, declaration, usage
- 열거형을 하나씩 분리해서 살펴보면 
  - prototype : 열거형을 만들고
  - declaration : 열거형 변수를 선언해서 값을 대입하고

### prototype

```java
enum Gogi { Pork, Beef, Chicken, Turkey }
```

### declaration

```java
Gogi pok = Gogi.Pork;
Gogi kfc = Gogi.valueOf("Chicken");
Gogi Sirloin = Enum.valueOf(Gogi.class, "Beef");
Gogi samgyeobsal = Gogi.Pork;
```

- 추가로  for문도 돌릴수 있는데

```java
Gogi[] darr = Gogi.values();

for (Gogi d : darr) {
    System.out.printf("%s = %d%n", d.name(), d.ordinal());
}
```

---

---

# 열거형에 멤버 추가하기

[목차로]()

 

---

---

# 열거형의 이해

[목차로]()

---

---

# java.lang.Enum

[목차로]()

- 모든 열거형의 조상(최 상위 클래스)
- protected Enum(String name, int ordinal)

    : 유일한 생성자로 프로그래머는 이 생성자를 호출할 수 없고, 열거형 선언(enum 키워드 사용)에 대한 응답으로 컴파일러에서 내보낸 코드에 사용됨

- Enum 파일에서 확인할 수 있는 지원 메서드 리스트

```
compareTo(E o) : ordinal을 기준으로 지정된 객체와 비교합니다.크면 양수 작으면 음수 같으면 0을 반환
eqauls(Object other) : 지정된 객체(other)가 열거형 상수와 같으면 true를 반환합니다.
finalize() : 해당 Enum클래스가 final 메서드를 가질 수 없게 합니다.
getDeclaring() : 열거형 상수의 열거형 타입에 해당하는 Class 객체를 반환합니다.
hashCode() : 열거형 상수의 해시 코드를 반환합니다.
name() : 열거형 상수의 이름을 반환합니다.
ordinal() : 이 열거형 상수가 정의된 순서를 반환합니다.
toString() : 열거형 상수의 이름을 반환합니다. (재정의 해서 개발자에게 더욱 친근하게 사용할 수 있습니다.)
values() : 열거형의 모든 상수를 배열에 담아 반환합니다.
	- Direction[] arr = Direction.values();
valueOf(String name) : 열거형 상수의 이름으로 문자열 상수에 대한 참조를 얻을 수 있게 해줍니다.
	- Direction.WEST == Direction.valueOf("WEST"); // true 반환
```

---

---

# EnumSet

[목차로]()

: 열거형 타입과 함께 사용하기 위한 특별한 Set 구현체

- 특징
    - 동기화되지 않음 (멀티쓰레드에서 사용시 주의)
    - iterator를 활용한 순회 가능(Enum으로 for문을 돌릴수 있다)
    - 생성자가 존재하지 않음
    - 

- 예제코드

```java
import java.util.EnumSet;
import java.util.EnumMap;

public class Enset_EX {
    public static void main(String[] args) {
        EnumSet<Flower> es1 = EnumSet.allOf(Flower.class);
        EnumSet<Flower> es2 = EnumSet.range(Flower.marigold_3, Flower.willow_5);

        for (Flower flo : es1) {
            System.out.print(flo + "  , ");
        }

        System.out.println();

        for (Flower flo : es2) {
            System.out.print(flo + "  , ");
        }
    }
}

enum Flower {
    rose_1, iris_2, marigold_3, primrose_4, willow_5
}
```

- 실행결과

![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2011%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20-%20%E1%84%8B%E1%85%A7%E1%86%AF%E1%84%80%E1%85%A5%E1%84%92%E1%85%A7%E1%86%BC(%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%E1%84%83%E1%85%B5%20%E1%84%92%E1%85%A1%E1%86%AF%E1%84%85%E1%85%A2)%200c9d3b0449874250a03e1a4f88124baa/Untitled%201.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2011%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20-%20%E1%84%8B%E1%85%A7%E1%86%AF%E1%84%80%E1%85%A5%E1%84%92%E1%85%A7%E1%86%BC(%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%E1%84%83%E1%85%B5%20%E1%84%92%E1%85%A1%E1%86%AF%E1%84%85%E1%85%A2)%200c9d3b0449874250a03e1a4f88124baa/Untitled%201.png)

- 링크 : 더 알아보기 about Enumset

    : EnumSet에 new 연산자를 사용하지 않는 이유, EnumSet은 생성자를 사용자가 호출불가이유

    - [https://parkadd.tistory.com/50](https://parkadd.tistory.com/50)
- 자매품으로 EnumMap 도 있다

---

---


### TMI : 자바의 열거형이 C/C++열거형보다 우월한 이유
- C/C++에서 제공하던 enum과 Java언어의 그것과는 내부 원리나 사용측면에서 완전히 다르다(근데 기능이랑 역할은 비슷하단 말이지)
  - Java의 enum에서는 열거형의 값 뿐만 아니라 타입까지 관리한다. 이를 **엄격한 타입 정의(strogly typed)**라고 한다
  - C/C++ enum에서는 열거형의 값만을 관리한다. 그러니까 C++의 Enum은 그냥 int형 정수에 껍데기만 이쁘게 덮어놓은것 
    - 아래 두 if문은 완전히 동일한 조건 입니다 (수도코드지만 C++과 매우 유사)
    ```cpp
    enum Season {
        WINTER, SPRING, SUMMER, FALL
    }
    //Direction mySeason : 위에서 사용되는 변수라고 가정
    if(mySeason == WINTER) {
        ...
    }

    if(myDir == 0) {// c++ 언어에서는 여기서 에러가 발생하지 않음, Java는 여기서 컴파일 에러 발생
        ...
    }
    ```
    - C++언어에서의 Enum을 굳이 Java로 표현하면 아래와 같습니다.
    ```java
    public static final int SEASON_WINTER = 0;
    public static final int SEASON_SPRING = 1;
    public static final int SEASON_SUMMER = 2;
    public static final int SEASON_FALL   = 3;
    ```
    


- 프로그래밍 언어차원에서 항상 모든 타입오류를 발견해 낼 수 있는 경우를, "엄격한 타입 정의 언어(strogly typed Lang)" 이라고 부릅니다(by 프로그래밍 언어론)
  - Java가 대표적 ㅎㅎ

:반대의 경우 cpp에서는

enum type과 실제 정수값을 동일시하고, 

공용체(union)등의 요소는 type과 bit단위의 해석을 오로지 프로그래머에게 전적으로 위임하는 방식이기에 에러의 발생 가능성이 높다.

심지어 동적할당을 위해 쓰이는 malloc함수는 (void *) 같은걸 리턴해준다.....

: 용어가지고 깐깐하게 구는 교수님을 엄격한 타입정의라고 생각해도 좋다. (예를들어 국, 찌개, 전골, 탕 간의 차이를 구분하지 못하면 까였다) 



# 끝