# 15 함수형 인터페이스

9999999999



### 함수형 인터페이스(Funtional Interface)

- 추상 메소드를 딱 하나만 가지고 있는 인터페이스
- SAM(Single Abstract Method) 인터페이스
- @FunctionalInterface 애노테이션을 가지고 있는 인터페이스

 

### 람다 표현식(Lambda Expressions)

- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메소드 매개변수, 리턴타입, 변수로 만들어 사용할 수 있다.

 

### 자바에서 함수형 프로그래밍

- 함수를 First-class object로 사용할 수 있다.
  - 여기서 (First-class) 요소(Object)라는건데 : class가 자바클래스가 아니고 Object가 자바의 객체랑은 다르다 
  - First-class 요소는 몇가지 조건/특징이 있는데
    - 변수에 할당할 수 있는 요소
    - 메서드에 파라미터로 넣어서 전달해줄수 있는 요소
    - 리턴값으로 받아볼수 있는 요소
  - 이 모든 요소의 조건들이 함수(혹은 메서드)가 충족시킬때 : 함수가 First-class 라고 부를수 있다
- 순수함수(Pure function)
  - 순수함수는 side-effect가 없다. 즉 함수 외부에 영향을 미치지 못함
  - 상태가 없다. 즉 입력이 동일하면 출력도 무조건 동일하다
  - HTTP / RESTful-API 에서 말하는 멱등성과 유사하다
  - 외부에 정의되어 있는 람다식 내부에서 변경하려는 경우 Pure function이 아니며
    - 자바에서는 컴파일 에러를 발생시킨다(컨셉 유지를 위해)
- 고차 함수(High-Order Fucntion)
  - 함수가 함수를 매개변수로 받을 수 있는 경우
  - 함수가 함수를 리턴할 수 있는 경우

 

## 일급요소 가 뭐냐고..

### 왜 first class citizen 인가? (+뇌피셜 함유)

- 과거에는 진짜 돈많고 잘사는 소위 "귀족"들이 대통령을 지들끼리 쑥떡쑥떡해서 뽑아서 1등시민(귀족), 2등시민(백인), 3등시민(나머지) 요런 개념이 대놓고 있었는데, 요즘에는 괜히 이런말 꺼내면 혼나는 시대가 왔다
- 미국 정치제도에서 대통령 선출 방법은 아직도 직접선거제가 아니라, 대의원들의 투표를 통한 간접선거제인데요
  - 물론 각State별 대의원수, 득표율, 승자독식제 어쩌고가 있는데 이런개념은 다음 미국대선때 티비에서 엄청 설명해줄테니까 패스
- 막 그렇게 유쾌한 출처는 아니라 다들 묵념+봉인 하는게 아닐까.. 하는생각! 아무튼 1등시민은 나라의 동작과 운영에 참여할수 있고 앞뒤로 나서서 대표할수 있는(parameter, 변수에 담아서 전달) 그런 느낌이 아닐까 추론.. 
- [출처링크](http://cefia.aks.ac.kr:84/index.php?title=4%EA%B3%BC_%EC%A0%95%EC%B9%98%EA%B6%8C%EC%9D%98_%EB%B0%98%EC%9D%91)

### First-class 설명

- 변수에 할당할수 있어야 하고
  - var variable = first-class-Something;
- 메서드에 파라미터로 넣어서 전달
  - Method( first-class_1, first-class_2 );
- 리턴으로 받을수 있다
  - var variable = Method( first-class_1, first-class_2 );

- 과거의 자바는 객체지향언어라서
  - java8 이전까지 First-Class는 객체와 값(프리미티브 타입)
  - 함수를 변수에 담을수 없었다

### C/C++ 에서는

- 함수포인터 등을 활용해서 함수를 일급요소(Object)로 사용할수 있다

- ```c++
  #include <stdio.h>
  
  void hello() // parameter(입력매개변수)와 return 이 없는 함수
  {
      printf("Hello, world!\n");
  }
  
  int sum(int a, int b) // 반환값과 매개변수가 없음
  {	
      printf("hello sum\n");
      return a+b;
  }
  
  int main()
  {
    // function pointer 사용을 위해서는 함수 시그니쳐가 동일해야 함
    // 시그니쳐 = return(반환값) + parameter(입력매개변수의 타입 && 갯수 && 순서)
    
    void (*fp_type1)();   // 반환값과 매개변수가 없는 함수 포인터 변수 선언
    fp_type1 = hello;     // hello 함수의 메모리 주소를 함수 포인터 fp에 저장
    fp_type1();           // Hello, world!: 함수 포인터로 hello 함수 호출
  
   	int (*fp_type2)(int, int) // 함수포인터 변수 선언
    fp_type2 = sum; // sum 함수의 메모리 주소를 함수 포인터 변수에 저장
    fp_type2(); // 함수 포인터로 변수에 담겨있는 함수 호출
  
    void * vp; // 타입 멈춰!
    vp = sum;
    vp = hello;
    vp = main;
    
    return 0;
  }
  ```

- 당연히 입력 파라미터로 함수(정확히는 함수포인터)를 사용 가능

- ```c++
  #include <stdio.h>
  
  int sum(int a, int b) { return a + b; }
  
  int mul(int a, int b) { return a * b; }
  
  int cha(int a, int b) { return a - b; }
  
  int div(int a, int b) { return a / b; }
  
  void executer(int (*fp)(int, int), int front, int back)    
  {
    // 함수 포인터를 매개변수로 지정, 함수(함수포인터)도 다른 자료형처럼 입출력 Type으로 사용
    printf("%d\n", fp(front, back)); // 매개변수로 함수 호출하고, 결과값을 출력
  }
  
  int main()
  {
    executer(sum,1,2);    // executer를 호출할 때 함수의 메모리 주소를 전달
  	executer(mul,3,4);
  	executer(cha,5,6);
  	executer(div,7,8);
    return 0;
  }
  ```

- 이런걸 배웠었죠... 

### Java의 람다는 함수를 First-class요소로 다룰수 있도록 도와줌

- 자바8부터 함수를(함수같이 보이는 무언가를)변수에 선언하거나, 매서드에 전달하거나 하는 등의 행위가 가능

```java
String [] names = {"DONG","SAN","JANE","COOP","WOODY"};

Comparator<String> stringComparator = ((o1, o2) -> o1.compareTo(o2));
Comparator<String> sc2 = String::compareTo;

Arrays.sort(names,stringComparator);
Arrays.sort(names,sc2);
Arrays.sort(names,Comparator.reverseOrder());
Arrays.sort(names,Comparator.naturalOrder());
Arrays.sort(names,(s1, s2) -> s1.length()+s2.length());
//type만 맞춰준 형태일뿐 아무런 의미없는 코드

System.out.println(Arrays.toString(names));
```



```java
Arrays.sort(names,Comparator.reverseOrder());
```

- 요기부분 따라가보면

  ```
  public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
          return Collections.reverseOrder();
      }
  ```

  ```
  public static <T> Comparator<T> reverseOrder() {
          return (Comparator<T>) ReverseComparator.REVERSE_ORDER;
      }
  ```

  ```
  @FunctionalInterface
  public interface Comparator<T> {
  ```

- 결국 @FunctionalInterface 로 선언된 어떤거라는걸 알수 있다



## 자바에서 제공하는 @FunctionalInterface 어노테이션

## 예제코드

```java
public class Launcher152 {
    public static void main(String[] args) {
        int testNum = 20;

        System.out.println("1 - old java way");
        Something runSomething = new Something() {
            @Override
            public int justDoIt(int number) {
                //testNum++; 사이드 이펙트를 만들 수 없다.(함수 밖에 있는 값을 변경하지 못한다.)
                return number + 10;
            }
        };
        System.out.println(runSomething.justDoIt(10));
        // 익명 내부 클래스 방식이 사용되던 과거




        System.out.println("2 - after Java8, use Lambda");
        Something runSomeLambda = (number) -> {
            //testNum++; // 변경안됨 1
            return number + 20 + testNum;
        };
        //System.out.println(testNum++); // 람다식 내부에 쓰인 변수들은 수정할수 없는 effectively final 상태가 된다
        System.out.println(runSomeLambda.justDoIt(10));
    }
}

// testNum++ 주석처리한 이유 : 컴파일 에러 발생
// 람다식 내부에서 side-effect 만들 수 없도록 컴파일 에러 발생(Variable used in lambda expression should be final or effectively final)
// 함수 밖에 있는 값을 변경하지 못한다 = make atomic !!


@FunctionalInterface // 자바에서 지원하는 어노테이션
interface Something {
    int justDoIt(int number);
}
```

- 위 예제코드로 알수있는 사실 
  - 자바 Lambda가 나름 순수함수로 동작할 수 있도록 제한을 걸어둠(effectively final)
    - 외부에서 정의된 값을 변경할수 없도록 컴파일 에러 발생시킴
  - 과거에도 비스무리한 "익명내부클래스" 같은 방식을 사용해서 람다 비슷한걸 만들어 썻는데
    - 이름없는 클래스를 바로 만들어서 매서드 하나만 생성해서 동작하도록
  - 자바 Lambda 도 원리는 동일한데
    - Interface 에 단하나의 유일한 메서드만 만들고 호출해서 사용하는 방식
    - 물론 따로  Interface를 생성하지 않고 코드 in-line에서도 사용 가능



## Java가 기본으로 제공하는 함수형 인터페이스

- [java.lang.funcation 패키지](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html) 참고하면 훨씬~ 더 많은 함수형 인터페이스들이 있다
  - 코드 링크  : 준비해둠
- 자바에서 미리 정의해둔 자주 사용할만한 함수 인터페이스
  - Function<T, R>
  - BiFunction<T, U, R>
  - Consumer<T>
  - Supplier<T>
  - Predicate<T>
  - UnaryOperator<T>
  - BinaryOperator<T>

 

Function<T, R>

- T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
  - R apply(T t)
- 함수 조합용 메소드
  - andThen
  - compose

 

BiFunction<T, U, R>

- 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
  - R apply(T t, U u)

 

Consumer<T>

- T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
  - void Accept(T t)
- 함수 조합용 메소드
  - andThen

 

Supplier<T>

- T 타입의 값을 제공하는 함수 인터페이스
  - T get()

 

Predicate<T>

- T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
  - boolean test(T t)
- 함수 조합용 메소드
  - And
  - Or
  - Negate



UnaryOperator<T>

- Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스

 

BinaryOperator<T>

- BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스



// todo 위에꺼 표로 정리





## ㄴ

- 인터페이스로 선언해놓고 사용하는경우
  - 결국 자바 람다식의 본질은 인터페이스에 메서드 하나
  - 과거에 익명내부클래스 쓰던거랑 바이트코드상 100% 일치하지는 않음
  - 자바에서 람다식을 특수한 오브젝트의 하나로 취급함!!!!!

- 코드 인라인 방식으로 사용하는 경우
  - 동작코드가 한줄만 있으면 브레이스{} 생략가능
  - 두줄이상이면 브레이스{} 해줘야함 (if문의 그것과 유사)
  - 메서드에 객체를 한번 덧씌워주는데
    - 과거에는 익명내부클래스라는 문법요소로 메서드를 덧씌워줬다면
    - 람다 공식지원버전(Java8) 이후로는 람다 전용의 객체로 덧씌워주는 방식임
    - 



## 쉐도잉

- ㅇㅏ 어렵다 쉐도잉

- 사실상 람다는 람드를 감싸는 스콥과 같다
- 람다는 쉐도잉이 일어나지 않는다
- 씨계열에서 지역성 가까운거부터 변수 스코프 /라이프타임으로 잠깐 배우고 넘어거ㅏ미

- 람다는 다르다
  - 같은 스코프 내에 동일한 변수이름 정의 불가능
  - 람다는 같은 스코프이다!

## 보충필요 todo



https://rlawls1991.tistory.com/entry/%EB%9E%8C%EB%8B%A4-%ED%91%9C%ED%98%84%EC%8B%9D?category=878314



개발자의 공부이야기 참고







### 메소드 레퍼런스

- 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.

## 메소드 참조하는 방법

| 스태틱 메소드 참조               | 타입::스태틱 메소드            |
| -------------------------------- | ------------------------------ |
| 특정 객체의 인스턴스 메소드 참조 | 객체 레퍼런스::인스턴스 메소드 |
| 임의 객체의 인스턴스 메소드 참조 | 타입::인스턴스 메소드          |
| 생성자 참조                      | 타입::new                      |

 

- 메소드 또는 생성자의 매개변수로 람다의 입력값을 받는다.
- 리턴값 또는 생성한 객체는 람다의 리턴값이다.

 

## 참고

- https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

 









## TMI 인터페이스

- 펑서녈 인터페이스 어노테이션에다가 업스트랙트, 스태틱 매서드 있어도 에러안나는거 하나 보여줘