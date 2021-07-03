# 자바 15주차

# 학습내용

- 람다식 사용법
- 함수형 인터페이스
- Variable Capture
- 메소드, 생성자 레퍼런스

### 할일

- 불변성 (Immutable) 변수를 활용
- 함수가 참조 투명성을 지키고, 부작용을 줄일 수 있도록 구현
- 순수함수 (Pure Function) 구현

# 목차

[함수형 프로그램의 특징](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)
[키워드 (용어정리)](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)
[마스터즈 클래스 수업내용](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

[람다식 (Lambda Expres)](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

[함수형 인터페이스](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

**[자바 Java Stream 인터페이스](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)**

[배경지식](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

[나의 궁금증](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

[해커랭크 FP 사용예시](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

# 람다식이란?

- 메서드(함수)를 하나의 식(expression)으로 표현한 것이다
- 메서드를 람다식으로 바꾸는 규칙은 다음과 같다.

    1. 반환 타입과 메서드 이름을 지운다.

    2. 매개변수 선언부와 몸통 사이를 화살표( ->)로 연결한다.

```java
int max (int a, int b) -> { return a > b ? a : b; }
```

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

---

# 함수형 프로그램의 특징

### 함수형 프로그래밍 정의

    : 함수를 이용한 프로그래밍으로, 함수를 인자값으로 사용하거나 리턴값으로 사용할 수 있으며, 순수 함수를 만들어 모듈화 수준을 높이는 프로그래밍

- 람다식(Lambda Exp) : 메서드(함수)를 하나의 식으로 표현한 것, 메서드(함수)를 간략하면서도 명확한 식으로 표현
- 메서드를 람다식으로 표현하면 메서드명(이름)과 반환값(return)이 사라지게 되는데
- 이런 람다식으로 표현된 메서드를 익명함수라고 한다.

### FP 특징

1. input과 output과 동일
2. 외부환경으로부터 철저히 독립적 : 외부에 어떤데이터를 읽지도 쓰지도  참조하지도 않음
3. 순수함수 : 같은 input은 무조건 같은 output이 나온다. (사이드 이펙트가 없다)
4. 외부변수 오류가 생기지 않음., 부작용(부수효과)에 의한 상태가 없어서 주목받음, 
5. 입력대비 출력이 정해져있으므로, 멀티프로세싱과 궁합이 좋다
6. 함수를 특별하게

    : 함수는 1등 시민이 된다

    : 함수를 타입으로 지정할수 있다

    : 함수를 입력파라미터로 넣어줄 수 있다

    : 함수를 리턴으로 받을 수 있다

- 출처 : [https://youtu.be/jVG5jvOzu9Y](https://youtu.be/jVG5jvOzu9Y)

### FP 공부법

1. 선언형 프로그래밍이다 : 이전에는 명령형 사고
2. 함수도 변수처럼 생각, 값으로 바라보고 생각
3. 고계함수(고차원 함수) : 
4. 메서드에서 함수로의 사고전환

    : 함수는 클래스에 독립적이고 더 제네럴한 표현

    : 메서드는 클래스에 종속적이고 객체지향에 적합

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

# 키워드 (용어정리)

### 키워드 정리

```java
메서드와 함수의 차이
1급객체
순수함수
Funtion 은 First Class Citizen이다!
Colosure(**람다 또는 클로저 closure)
고차함수(고계함수)
프로그래밍 패러다임(객체지향과 함수형 패러다임의 공통점과 차이점)**
```

### 메서드와 함수의 차이

- 메서드랑 함수랑 같은건데 다르다.
- 뭔말이냐면 관점과 패러다임은 다르지만, 의미하는 바는 같다.
    - 메서드 : 객체지향(oop)에서 객체의 행위나 동작을 표현, 반드시 클래스에 소속됨
    - 함수 : 하나의 특별한 목적의 작업을 수행하기 위해 독립적으로 설계된 코드의 집합, 
    : oop 패러다임 이전에 C/C++ 같은 절차지향적 언어들에서는 "단위 작업을 캡슐화" 하는데 사용
- 자바 8버전 이후에 람다식을 통해 매서드 하나로 뭔가를 할수 있게 되서... 아무튼 대부분 비슷한 용어로 쓰는데 문맥이나 맥락상 통하는 단어고, 두 단어를 크게 구분짓는다고 좋을것도 없고 혼동될꺼도 없을듯 하다..

### 1급 객체

- 1급 함수라고도 하며 자바에서는 함수형 인터페이스를 통해 **구현** 이 가능
- 보통 자바스크립트를 배울때 많이 나오는 내용
- 변수나 데이터 구조안에 넣을 수 있다.
- 파라미터로 전달 할 수 있다.
- 동적으로 프로퍼티 할당이 가능
- 리턴값으로 사용할 수 있다.

### 순수함수(Pure Function)

- 입력값이 동일하면 결과가 동일하게 리턴되는 함수. (Test 할때 정확도)
- 부작용 (Side-effect)가 없는 함수
- 함수의 실행이 외부의 상태를 변경시키지 않는 함수
- 함수에서 외부 인자를 변경하지 않고, 입력이 같다면 출력은 무조건 같다
    - 오직 입력에 의해서만 출력이 정해지고, 환경이나 상태에 영향을 받아서는 안된다
- 순수한 함수는 멀티 쓰레드 환경에서도 안전하고, 병렬처리 및 계산이 가능
- 객체지향에서는 객체들간의 상호작용이 중요한것에 대비됨

### 근데.. 자바에서는 함수의 개념이 없다. 오직 클래스 내부의 매서드 뿐

- 자바의 메소드는 일급 함수가 아니므로, 다른 메소드로 전달할 수 없다.
- 자바에는 모든 것이 객체다. 메소드는 객체의 행위를 정의하고 객체의 상태를 변경한다
- 이런 이유로 기존의 자바 언어 체계에서는 함수형 언어를 언어 차원에서 지원하지는 못하였다.
- 함수형 프로그래밍의 조건을 만족하도록 구현하지 못했었는데... (8버전 이전에는)

### 그래서 Java8에서는 함수형 인터페이스(Funtional interface, 클래스 앞에 @붙여서 표현해주면 됨) 개념을 도입했어요

- 함수형 인터페이스의 경우, 람다식으로 표현이 가능하도록 자바에서 새로 지원하게 됨
- 그래서 함수형 인터페이스라는 개념과 람다식 표현을 통해 입력에 의해서만 출력이 결정되도록 ‘순수한 함수’를 표현할 수 있게 됨!
    - 람다식으로 표현함으로써 ‘익명 함수’를 정의할 수 있게 되었고
    - 함수형 인터페이스의 메소드에서 또다른 함수형 인터페이스를 인자로 받을 수 있도록 하여 ‘고계 함수’를 정의할 수 있게 되었다.
- 함수형 프로그래밍 패러다임을 언어차원에서 새로 도입! (멀티패러다임이 따로 없군요!)

- 순수함수 예제코드

```java
public interface Functional1 {
  boolean accept();
}

public interface Functional2 {
  boolean accept();
  default boolean reject() { return !accept(); }
}

@FunctionalInterface
public interface Functional3 {
  boolean accept();
}

public interface NotFunctional {
  boolean accept();
  boolean reject();
}
```

- Functional1, 2, 3는 모두 함수형 인터페이스를 만족
- Functional3 인터페이스의 경우, @FunctionalInterface 어노테이션이 있는데, 컴파일러에게 명시적으로 Functional Interface 임을 알려주고 규칙 위반(하나의 인터페이스에 오직 하나의 함수만) 시 컴파일 에러를 뿜어준다

### Funtion 은 First Class Citizen이다!

- 함수형 언어에서는 함수도 하나의 값으로 취급하고, 함수의 인자로 함수를 전달할 수 있는 특성이 있다. 이러한 함수를 일급 객체 (a.k.a 일급 함수)라 칭함
- First Class Citizen이 되기 위한 3가지의 특징
    - parameter로 함수를 받을수있고
    - retrurn으로 함수를 돌려줄수 있고
    - variable / data Structure로도 함수를 사용한다
- First Class Citizen을 위한 구현방법 : Anonymous Funtion(자바는 Method)
    - 자바에서는 Lamda Expresstion 이라고 함

### Colosure(**람다 또는 클로저 closure)**

: 함수 내에서 함수를 정의하고 사용하면 클로저라고 한다. 

: 대개는 정의한 함수를 리턴하고 사용은 바깥에서 하게된다

- 클로저 closure는 람다계산식(lamda Calculus) 구현체
- 이름 없는 함수(anonymous function)로 리터럴하게 작성가능
- 선언된 범위(scope)에서 접근 가능한 변수를 캡처해서 저장하고 닫힘
- Java(8이후) 클로저는 캡처한 변수를 참조(reference)한다
- 자바에서도 람다를 활용할 수 있다.
    - (JS나 Swift에서는 함수형 프로그래밍 클로저를 쉽게 만들 수 있고)

- 클로져 예제코드

```jsx
function getClosure() {
  var text = 'variable 1';
  return function() {
    return text;
  };
}

var closure = getClosure();
console.log(closure()); // 'variable 1'
```

### **고차함수(고계함수, Higher-order Function)**

- 함수를 더 추상화하면 차원이 높아지는 고차함수로 표현할 수 있다.
- 함수를 다루는 상위의 함수
- 주 사용 용도는
    - 콜랙션을 탐색하고, 비교하고, 찾아서 정리하는 기능 (여러 값이 들어있는)
- 고차함수 예제코드

```java

```

### 익명함수(Annonymous Function)

- 이름이 없는 함수(자바의 메서드)를 정의할 수 있어야 한다.
- 이러한 익명 함수는 대부분의 프로그래밍 언어에서 ‘람다식’으로 표현하고 있다
- 이론적인 근거는 람다 대수(람다 계산, 람다 계산법)에 있다.

    : 추상화와 함수 적용 등의 논리 연산을 다루는 형식 체계이다

    : [https://ko.wikipedia.org/wiki/람다_대수](https://ko.wikipedia.org/wiki/%EB%9E%8C%EB%8B%A4_%EB%8C%80%EC%88%98)

- 람다식으로 표현된 메서드를 익명함수라고 한다.
- 메서드를 람다식으로 표현하면 메서드명(이름)과 반환값(return)이 사라지게 되는데
- 람다식(Lambda Exp) : 메서드(함수)를 하나의 식으로 표현한 것, 메서드(함수)를 간략하면서도 명확한 식으로 표현

### **프로그래밍 패러다임**

: **객체지향과 함수형 패러다임의 공통점과 차이점**

- 적을예정

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

# 마스터즈 클래스 수업내용

### 이외 첨언

- 객체지향 : 객체를 모델링, 상호작용, 흐름제어가 중요해
- FP는 흐름 하나, 스테이지 하나 입력대비 출력만 중요해
- 실제 객체를 모델링해서 객체들과의 상호작용 같은걸 생각하면 객체지향이 편한데
어떤 일을 순서대로 처리한다는 느낌으로는 함수형이 좋은거같아요
- 난 지금 이해가 안되는데, 이런거 많이 짜보면 된다
    - 코딩 많이하세요

        ![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled.png)

        ![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled%201.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled%201.png)

- 포이치, 맵, 필터, 이런거 잘 쓰는게 중요해
    - 포이치 foreach
    - 맵map
    - 썸과 에브리(some & every)
    - 리듀스
    - 필터 : filter
    - 스트림(함수 합성에 사용)
- FP 가 처음 쓸때나 진입점에서는 어색함을 인정하고 그냥 받아들이자
- 사고의 흐름이 매끄러운지를 다듬어야해 가**장 중요한건 사고의 흐름!**
    - 잘하고싶어요

        ![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled%202.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled%202.png)

### FP를 쓰는 이유

- 테스트하기 용이하다  : 좋은 코드일 수 밖에 없다
- Side-Effect 가 없거나 적다, Side-Effect 가 일어나게 한다면 FP라고 말하기에는 곤란
- 멀티쓰레드에 안전하다, 멀티코어에 적합한 프로그래밍 패러다임

### 공부해야할 키워드

- : 리액티브x,
- 스코프,
- call-by-name,
- 모나드
- 커링(Curry, Curring)
- 함수 역할 나누기 연습 잘하기!!!!!!!!!!!!!!!!!!!!!(개중요)
    - 레고블럭 하나가 없는데 어떻게
    - 함수 역할 정의를 잘 하기
    - 함수를 순수하게 만들기

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

# 람다식 (Lambda Expres)

: original by 자바의정석 남궁석님

- 람다식은 익명함수
- 자바에서는 익명함수가 아니라 익명클래스의 익명객체, 객체의 생성과 선언을 동시에

```java
new Object() {
	int max(int a, int b) {
		return a>b ? a:b;
	}
}
```

### 메서드 To Lambda 변환공식

- 함수/메서드를 식(Express)로 변환

```java
int max(int a, int b) {
	return a>b ? a:b;
}
```

```java
(int a, int b) **->** {
	return a>b ? a:b;
}
```

```java
(a, b) -> {	return a>b ? a:b; }
```

- 메서드의 이름과 반환타입을 제거
- 함수 블록{} 앞에 화살표(→) 를 추가
- 반환값이 있는경우
    - return 생락가능
    - 마지막에 ; 를 붙이지 않음
- 입력매개변수의 자료형이 생락가능(대부분 가능하며, 추론이 가능해야함)
- 매개변수가 하나인경우, 괄호는 생략 가능
- 블록안의 문장이 하나뿐일 때는 괄호 생략가능
- 하나뿐인 문장이 return문이면 괄호생략불가

### Ex1

```java
package other_funcProg;

import javax.management.ObjectName;
@FunctionalInterface
interface Myf {
    void run(); // public abstract only
}

public class Chp14_ex1 {
    static void execute(Myf f) {
        f.run();
    }

    static Myf getFunc() {// 반환타입이 함수형인터페이스
        /*
        Myf f = () -> System.out.println("GET FUNC");
        return f;
         */
        // 위 두줄을 한줄로 줄이면
        return () -> System.out.println("GET FUNC");
        // 람다식을 리턴하는거임
    }

    public static void main(String[] args) {
        Myf f1 = () -> System.out.println("f1.run()");
        // 입력도 출력도 없는 시그니쳐 함수가 필요
        // 람다식 쓸때는 꼭 입출력 함수 시그니쳐가 동일해야함

        //
        Myf f2 = new Myf() {
            public void run() {
                System.out.println("f2.run()");
            }
        };

        Myf f3 = getFunc();
        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("???n()"));
        execute(() -> System.out.println("run()"));

    }
}
```

- 798페이지

# Ex2

### Ex2 코드

```java
package other_funcProg;

@FunctionalInterface
interface Myfunc{
    void mymethod();//public abstract void mymethod()
}

public class Chp14_ex2 {
    public static void main(String[] args) {
        Myfunc f = () -> {};
        Object obj = (Myfunc) (() -> {});
        String s = ((Object) (Myfunc) (() -> {}) ).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(s);
        //System.out.println(()->());
        System.out.println((Myfunc)(() -> {}));
        //System.out.println((Myfunc)(() -> {}).toString;
        System.out.println(( (Object) (Myfunc)(() -> {})).toString());
        System.out.println(( (Object) (Myfunc)(() -> {})).toString());

    }
}
```

### 위 예제의 해석

- 함수형 인터페이스로 람다식을 "참조"할 수만 있다.
- 람다식의 타입이 함수형 인터페이스 타입과 일치하는것은 아니다
- 람다식은 익명 객체이고, 타입이 없다(있긴 있는데, 컴파일러가 임의로 이름을 지정해버리그 때문에 사용자코드에서는 이름이 없고, 그래서 익명이다)
- 대입 연산자는 양변(L-val과 R-val)의 Type이 같야아 한다 그래서 아래 코드와 같은 형변환이 필요한데

```java
MyFunc f = (MyFunc)(() -> {});
```

- 람다식은 MyFunc 인터페이스를 구현하지 않았지만, 해당 인터페이스를 구현한 클래스객체와 완전히 동일한 객체이기 때문에 형변환이 허용된다
- 위 형변환은 생략가능
- 자바에서의 람다식은 이름이 없을뿐 객체인데, 자바 최상위 Object 타입으로의 형 변환이 불가능하다
- 람다식은 오직 함수형인터페이스로만 형 변환이 가능하다

```java
Object obj = (Myfunc) (() -> {});
```

- 굳이 꼭 Object 타입으로의 형 변환하려면, 먼저 함수형 인터페이스로 변환후 가능하다

```java
Object obj = (Myfunc) (() -> {});
String s = ((Object) (Myfunc) (() -> {}) ).toString();
```

### 실행결과

### Ex3 코드

```java
package other_funcProg;

public class Chp14_ex3 {
    @FunctionalInterface
    interface Myfunc {
        void mymethod();
    }
}

    class Outer {
        int val = 10;

        class Inner {
            int val = 20;

            void method(int i) {
                int val = 30;
                //i=10;

                Myfunc f = () -> {
                    System.out.println("i:" + i);
                    System.out.println("val:" +val);
                    System.out.println("this.val:" + ++this.val);
                    System.out.println("Outer.this.val:" + ++ Outer.this.val);

                };
                f.mymethod();
            }
        }
    }

class LambdaEx3 {

    public static void main(String[] args) {
        Outer o =new Outer();
        Outer.Inner i = o.new Inner();
        i.method(100);
    }
}
```

### 해석

- ㄴㅇㄹ

### 실행결과

- 아래와 같은 결과가 나타난다

    ![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled%203.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2015%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%201319dc63ca654e37a86bdaf411abbb04/Untitled%203.png)

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

# 함수형 인터페이스

- 단 하나의 추상메서드만 선언된 인터페이스
- ㄹㅇ

```java
@FunctionalInterface // 함수형 인터페이스는 오직하나의 추매만
interface Myfunc {
    //public abstract int max(int a, int b)        return a> b ? a:b ;
    int max(int a, int b)        return a> b ? a:b ;
   /*
   오버라이딩 규칙중에서, 접근제어자는 좁게 못바꾼다!!
    */
}
```

- ㄴ

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

---

---

# **자바 Java Stream 인터페이스**

### **자바 Java Stream 인터페이스**

`스트림stream`은 자바 8 API에 새로 추가한 기능이다. 스트림을 이용해서 선언형으로 콜렉션 데이터를 처리하도록 구현할 수 있다.

### **filter**

요구사항은 파일 문자 중 길이가 12보다 큰 문자의 수를 구한다.

```java
// next.fp.StreamStudy countWords method

String contents = new String(Files.readAllBytes(
  Paths.get("../ war-and-peace.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 0;
for (String w : words) {
  if (w.length() > 12) count++;  
}
코드복사
```

---

### **filter 활용해 구현**

```java
String contents = new String(Files.readAllBytes(
  Paths.get("../alice.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 
  words.stream().filter(w -> w.length() > 12).count();
코드복사
```

---

### **map**

List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.

```java
// next.fp.StreamStudy 클래스의 doubleNumbers method 참고
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> dobuleNumbers =
  numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
코드복사
```

---

### **reduce**

List에 담긴 모든 숫자의 합을 구한다.

```java
// next.fp.StreamStudy 클래스의 sumAll method 참고

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAll(List<Integer> numbers) {
    return numbers.stream().reduce(0, (x, y) -> x + y);
}
코드복사
```

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

---

# 배경지식

- 완전수 : 진약수를 모두 더하면 자기 자신이 되는 수 (ex. 6 : 1+2+3 = 6)
- 과잉수 : 진약수를 모두 더한 수가 자기 자신보다 큰 수 (ex. 12 : 1+2+3+4+6 = 16)
- 부족수 : 자신을 제외한 양의 약수(이하 진약수)를 모두 더한 수가 자기 자신보다 작은 수 (ex. 26 : 1+2+13 = 15)
- 소수 : 나누어 떨어지는 수가 1과 자기 자신뿐(13 : 1,13), 모든 소수
- 진약수 : 어떤 자연수를 n이라고 할 때 n의 약수 중 n을 제외한 모든 약수를 진약수

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

---

# 나의 궁금증

- foreach?

- stream 에서 reduce?

```java
return factors.stream().reduce(0,Integer::sum);
```

- 상속받을때 super 키워드 (리뷰)

      - 부모생성자 호츨해서 초기화

- 함수형의 불변성 : protected final int

- 함수에서 public static final

- 매서드에서 final : 재정의안됨 오버라이딩 X

- Intstream 이란 도대체 뭘까

[목차로](%E1%84%92%E1%85%A1%E1%86%B7%E1%84%89%E1%85%AE%E1%84%92%E1%85%A7%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC%20f66a732a986d4ea39f45a07cff28ca88.md)

---

---

---

# 해커랭크

- 스니핏

```java
int priceOfJeansCount = Integer.parseInt(bufferedReader.readLine().trim());

List<Integer> priceOfJeans = IntStream.range(0, priceOfJeansCount).mapToObj(i -> {
    try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
})
    .map(String::trim)
    .map(Integer::parseInt)
    .collect(toList());
 
```

- 해커랭크 코드 (전문,클릭해서 확인)

    ```java
    import java.io.*;
    import java.math.*;
    import java.security.*;
    import java.text.*;
    import java.util.*;
    import java.util.concurrent.*;
    import java.util.function.*;
    import java.util.regex.*;
    import java.util.stream.*;
    import static java.util.stream.Collectors.joining;
    import static java.util.stream.Collectors.toList;

     

    class Result {
     
       /*
         * Complete the 'getNumberOfOptions' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY priceOfJeans
         *  2. INTEGER_ARRAY priceOfShoes
         *  3. INTEGER_ARRAY priceOfSkirts
         *  4. INTEGER_ARRAY priceOfTops
         *  5. INTEGER budgeted
         */
     
        public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {
        // Write your code here
     
        }
     
    }
    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
     
            int priceOfJeansCount = Integer.parseInt(bufferedReader.readLine().trim());
     
            List<Integer> priceOfJeans = IntStream.range(0, priceOfJeansCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
     
            int priceOfShoesCount = Integer.parseInt(bufferedReader.readLine().trim());
     
            List<Integer> priceOfShoes = IntStream.range(0, priceOfShoesCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
     
            int priceOfSkirtsCount = Integer.parseInt(bufferedReader.readLine().trim());

     

            List<Integer> priceOfSkirts = IntStream.range(0, priceOfSkirtsCount).mapToObj(i -> {

                try {

                    return bufferedReader.readLine().replaceAll("\\s+$", "");

                } catch (IOException ex) {

                    throw new RuntimeException(ex);

                }

            })

                .map(String::trim)

                .map(Integer::parseInt)

                .collect(toList());

     

            int priceOfTopsCount = Integer.parseInt(bufferedReader.readLine().trim());

     

            List<Integer> priceOfTops = IntStream.range(0, priceOfTopsCount).mapToObj(i -> {

                try {

                    return bufferedReader.readLine().replaceAll("\\s+$", "");

                } catch (IOException ex) {

                    throw new RuntimeException(ex);

                }

            })

                .map(String::trim)

                .map(Integer::parseInt)

                .collect(toList());

     

            int budgeted = Integer.parseInt(bufferedReader.readLine().trim());

     

            long result = Result.getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budgeted);

     

            bufferedWriter.write(String.valueOf(result));

            bufferedWriter.newLine();

     

            bufferedReader.close();

            bufferedWriter.close();

        }

    }
    ```