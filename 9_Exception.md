# 자바 9주차

# 목표 : 자바의 예외처리

- 

# 필수학습요소

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이
- RuntimeException(RE)과 아닌 것의 차이는?
- throw커스텀한 예외 만들기

# 목차

```java

```

# 자바의 예외처리(Exception Handling)

### Exception이란?

- 자바에는 컴파일에러와 런타임 에러 두가지 종류가 있고, 런타임 에러를 주로 다루는데(컴파일 에러는 발생하더라도 빌드가 안되기 때문에 별 문제가 안된다)
- 런타임 에러 중에서 두가지로 또 나뉘는데
    - 에러(Error) : 코드로 수습이 **불가능한 심각한** 오류
    - 예외(Exception) : 코드에 의해 수습 가능한 오류

: 위 두가지가 있으며,이번에는 주로 "예외"에 대하여 다룬다

- 인터넷에 많이 보이는데, 자바의정석에 있는 내용임

### 예외처리 효과

- 예외 발생에 대비한 대응 코드를 작성
- 실행상태를 유지(프로그램의 비정상 종료 방지)

# 자바 예외처리 방법

### 1) try-catch 구문,  catch 구문, throw를 통한 예외 발생시키기

```java
public class excp1 {
  //프로그램 사용법 및 의도
  //run1, run2 중에 하나만 사용하고 하나는 주석처리하고 사용

  public static void main(String[] args) {
      //run1();
      run2();
  }

  static void run1() {
      try {
          Exception exception = new Exception("고의로 발생시킨 예외");
          throw exception;
      }catch(Exception e) {
          System.out.println("에러메시지 : "+ e.getMessage());
          e.printStackTrace();
      }

      System.out.println("프로그램 정상 종료");
  }

  static void run2() {
    try {
        throw new Exception("익명클래스로 만든거임");
    }catch(NullPointerException e) {
        System.out.println("에러메시지 : "+ e.getMessage());
        e.printStackTrace();
    }catch(ClassCastException e) {
        System.out.println("에러메시지 : "+ e.getMessage());
        e.printStackTrace();
    }
    System.out.println("프로그램 정상 종료");
  }

	static void run3() {
		try {
        throw new Exception("익명클래스로 만든거임");
    }catch(NullPointerException e | ClassCastException e) {
        System.out.println("에러메시지 : "+ e.getMessage());
        e.printStackTrace();
		}

}

```

- try부분에서 오류가 발생하면 객체가 생성되고, catch부분이 True가 되어 catch 블럭 아래의 코드가 실행됨
- printStackTrace() : 호출 스택에 있었던 정보와 예외 메세지 출력
- getMessage()   : 발생한 예외 클래스의 인스턴스에 저장된 메세지
- 멀티 catch 블럭  - JDK1.7 하나의 catch블럭으로 합칠 수 있음
    - "|" 기호로 연결된 예외 클래스가 조상과 자손의 관계에 있으면 컴파일 에러가 발생함

- RuntimeException 클래스에 속하는 예외는 예외처리를 강제하지 않는다. -> unchecked예외
    - 프로그래머가 실수로 발생하는 예외(널포인터, 디바이드 제로)

### Checked /UnChecked

- Checked : 반드시 throw 로 예외 던질 준비를 해주거나, try-catch 로 담아줘야함! 강제적으로!
    - 여기저기에다가 thorw exception 붙이면 혼난다..
- UnChecked : 강제성 없음

![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%209%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20a762345f60234156a175f7d45d48ecef/Untitled.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%209%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20a762345f60234156a175f7d45d48ecef/Untitled.png)

### 4) finally

- finally는 try블럭이 끝날때 ( exception 발생여부, return, continue, break등과 상관없이) 반드시 수행된다.finally블럭은 반드시 작성할 필요는 없다.

![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%209%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20a762345f60234156a175f7d45d48ecef/Untitled%201.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%209%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20a762345f60234156a175f7d45d48ecef/Untitled%201.png)

- 로치말씀 : 이펙티브 자바에서도 나오지만, 안티패턴임

### 6)되던지기(re-throwing)

![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%209%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20a762345f60234156a175f7d45d48ecef/Untitled%202.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%209%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20a762345f60234156a175f7d45d48ecef/Untitled%202.png)

### 7) 사용자 정의 예외

Exception 클래스를 extends 받아 필요한 예외를 정의할 수 있다.

![https://blog.kakaocdn.net/dn/bYxNym/btqTp25dgmK/RLK1iX28oCPesVM9nIHfWK/img.png](https://blog.kakaocdn.net/dn/bYxNym/btqTp25dgmK/RLK1iX28oCPesVM9nIHfWK/img.png)

커스텀한 예외 생성 CustomException.java

![https://blog.kakaocdn.net/dn/FjAEP/btqTjExuc1F/mjKWMNHXkwMXk6hAzmoFVK/img.png](https://blog.kakaocdn.net/dn/FjAEP/btqTjExuc1F/mjKWMNHXkwMXk6hAzmoFVK/img.png)

커스텀한 예외 생성

![https://blog.kakaocdn.net/dn/cpzcCE/btqTjExudnm/D13fUkRmKJ5yXS5v0D7vr0/img.png](https://blog.kakaocdn.net/dn/cpzcCE/btqTjExudnm/D13fUkRmKJ5yXS5v0D7vr0/img.png)

결과

사용자정의 예외를 생성할때 uncheckedException 으로 생성하고자 한다면, RuntimeException을 extends 받아서 생성

[http://tcpschool.com/java/java_exception_intro](http://tcpschool.com/java/java_exception_intro)

[http://tcpschool.com/java/java_exception_class](http://tcpschool.com/java/java_exception_class)

[https://i-am-clap.tistory.com/12](https://i-am-clap.tistory.com/12)

학습할꺼  : 로치의 예외처리 코드

[https://velog.io/@tmdgusya/예외처리](https://velog.io/@tmdgusya/%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC)