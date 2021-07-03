# Reflection API

## 리플렉션이란?

### 리플렉션 Why ??? (왜 이게 필요하지)
- 자바는 정적인 언어라 부족한 부분이 많은데 이 동적인 문제를 해결하기 위해서 리플렉션을 사용
- 컴파일을 하는 자료형(Type)이 정적(Static)한 Java나 C++같은 언어들이 프레임워크를 만들수 있도록 도와줌

### 리플렉션 What? (그래서 뭐하는거지)
- 런타임 시 클래스, 인터페이스, 필드, 메서드 등의 속성을 검사하거나 조작할 수 있는 자바 프로그래밍 언어의 기능
- 리플렉션은 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드, 타입, 변수들에 접근할 수 있도록 해주는 자바 API
  - 구체적인 클래스 타입을 알지 못해도 : 나중에 구현 클래스를 만들껀데 >> 내가 아닌 다른사람이 만든 클래스가 내 코드속에서 동작되기 위해
- 원래 Java는 컴파일언어/정적인 언어라 동적으로 객체를 생성할수 없는데(new Object가 없으면 실체화 불가능), 이걸 가능하게 해주는게 바로 Reflection
- 애플리케이션 개발에서보다는 프레임워크, 라이브러리에서 많이 사용
  - 프레임워크, 라이브러리는 사용하는 사람이 어떤 클래스를 만들지 모른다
  - 이럴 때 사용자가 만든 코드를 동적으로 프레임워크 속에서 돌아가도록 ,연결해주기(IoC,DI) 위해서 리플렉션 사용
  - 대표적인 사용 예로는 스프링의 DI(dpendency injection), Proxy, ModelMapper 등등...
- 결국 Reflection은 실행 중인 자바 프로그램이 아래 3가지를 할수 있다는건데
  - 1)클래스 속성 값에 대한 분석 및 검사를 진행할 수 있도록 한다.
  - 2)런타임에 동적으로 클래스 정보에 접근해서 메소드, 필드 등 프로그램의 내부 속성에 접근하고 사용할 수 있도록 한다
  - 3)확장 가능한 인스턴스를 만들어 외부 사용자 정의 클래스를 작성 할 수 있도록 한다

## Reflection API 사용법과 특징
### 사용
- 라이브러리 추가 없이 사용가능하며, 리플렉션 API는 **`java.lang.reflect`** 패키지에 있는 클래스와 **`java.lang.Class`** 클래스에 있는 메서드를 사용하여 구현가능
  - java.lang.Class의 메서드: getName(), getSuperclass(), getInterfaces(), getModifiers()
  - java.lang.reflect 패키지 : **`JDK 열어서 꼭 확인해보렴`**

| 원하는 정보  | 메서드명         | 설명                                                         |
| ------------ | ---------------- | ------------------------------------------------------------ |
| Class        | getClass()       | 객체에 속한 `class name`를 확인하고 싶은 경우 사용하는 메서드 |
| Constructors | getConstructor() | 객체에 속한 `public constructor`를 사용하고 싶은 경우 사용하는 메서드 |
| Methods      | getMethods()     | 객체에 속한 `public method`를사용하고 싶은 경우 사용하는 메서드 |



### Reflection API를 활용해서 String 클래스에 정의된 메소드 정보를 가져오고 싶다고 가정했을 때
- 1)클래스 객체 검색 (Retrieving Class Object)
  - java.lang.Class 객체 가져오기 -> Class 객체에서 제공하는 메소드를 통해 클래스 정보에 접근할 수 있다.
    - .class syntax
    - Object::getName
    - Class::getClass
```java
Class c = Class.forName("java.lang.String");
```
- 2)클래스 맴버 탐색 (Discovering Class members)
  - getDeclaredMethods 메소드를 호출해서 클래스에 의해 정의된 메소드 객체를 추출.
```java
Method m[] = c.getDeclaredMethods();
```
- 3)정보 활용 : Reflection API를 사용해서 얻어온 정보들을 사용
```java
System.out.println(m[0].toString());
```

### 예제1
- 예제코드
```java
package Chp30_AnnotationReflection.ex2;

import java.lang.reflect.Field;

class Person {
    private String address;
    private Integer asset;
    private int age;
    private String national;
}

public class Launcher302 {
    public static void main(String[] args) {
        Object obj = new Person();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            System.out.println(Integer.toString(i) + " ================");
            System.out.println(fields[i].getName() + ", " + fields[i].toGenericString() + ", " + fields[i].toString() + "\r\n\r\n");
        }
    }
}
```
- 돌려보면 이런저런 정보들을 알 수 있으며, Person class 를 변경해도 정확히 알아낼 수 있다
- 또 Person class 를 다른 파일로 변경해도 알아낼 수 있다, 메서드를 추가해도 어떤 메서드들을 가지고 있는지도 알아낼 수 있다.


### 예제2
- Launcher303 예제를 좀 더 다듬어서 올리길
```java
Launcher303
```
- 예제 참고 : https://www.geeksforgeeks.org/reflection-in-java/

## Member를 상속하는 대표적인 클래스들과 메소드들
- Oracle - Members : http://www-inf.it-sudparis.eu/cours/java/javatutorial/reflect/member/index.html

| Member      | Class API      | Inherited Members | Private Members |
| ----------- | -------------- | ----------- | ----------- |
| Field       | getDeclaredField(), getDeclaredFields()             | NO                | YES             |
|             | getField(), getFields()                             | YES               | NO              |
| Method      | getDeclaredMethod(), getDeclaredMethods()           | NO                | YES             |
|             | getMethod(), getMethods()                           | YES               | NO              |
| Constructor | getDeclaredConstructor(), getDeclaredConstructors() | NO                | YES             |
|             | getConstructor(), getConstructors()                 | YES               | NO              |
- 뿐만아니라 by getDeclaredFields()), 어노테이션 정보(by getDeclaredAnnotatio()) 등 다양한 메소드들을 통해 클래스 속성 값들을 추출해올 수 있다.


### 특징
- 한마디로 "미래에 어떤게 만들어질지 모르는 클래스에 대하여 런타임에 정보들(메서드,클래스,인터페이스)을 런타임에 얻어낼 수 있는 API
- 리플렉션을 사용하여 객체 초기화, 메서드 호출, 필드 값 설정 등 가능
- 클래스의 private 멤버도 조작할 수 있다.
- 성능 저하, 보안 취약성 등의 오버헤드가 발생할 수 있다.

## Reflecction 단점
- Performance Overhead
  - reflection은 동적으로 수행이 되기 때문에 아무래도 reflection을 수행하지 않은 프로그램 보단 상대적으로 JVM의 퍼포먼스를 떨어트릴 수 있다(JVM 최적화가 힘들다고 한다). 때문에 performance-sensitive 한 프로그램에서는 빈번하게 사용하는 것은 좋지 않을 수 있다.
- Security Restrictions
  - reflection은 엄격한 보안 시스템 아래서는 허용하지 않는 런타임 접근 권한을 요구하기 때문에 유의해야 한다.
- Exposure of Internals
  - reflection을 통해 직접 접근하기 힘든 private 필드 혹은 메소드에 접근이 가능해지면서 예상치 못한 사이드 이펙트가 발생 할 수 있다.
  - 이 과정에서 추상화를 깨는 경우가 발생할 수도 있다 - data encapsulation
  - 출처 : https://stackoverflow.com/a/16635211
- Performance Overhead : reflection 연산은 속도면에서 느리다 (성능에 예민한 애플리케이션에서 사용을 자제.)
- Exposure of Internals : reflective code는 추상화를 깨트린다.(?)
- 추상화 : 여러 객체에 공통적으로 사용되는, 사용되어야 하는 내용을 추출하는 작업

## Reflecction장점
- Extensibility Feature : 정규화된 이름을 사용하여 확장성 개체의 인스턴스를 만들어 외부 사용자 정의 클래스를 사용할 수 있다.
- 확장성 : reflection을 통해 객체 내부 필드 설정 가능 + 조금 더 유연한 코드를 작성할 수 있다(?)
- 외부 사용자 정의 클래스 : reflection을 통해 객체를 생성할 수 있다.
- Debugging and testing tools : 디버거는 클래스의 private 멤버를 reflection의 특성을 이용한다.

### 스프링 코드 예시
- 간단한 컨트롤러로 예시를 들면
```java
@Controller
@RequestMapping("/articles")
public class ArticleController {    

    @Autowired    
    private ArticleService articleService;       
    
    // 중략...

    @PostMapping
    public String write(UserSession userSession, ArticleDto.Request articleDto){
       // 중략...
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
       //중략...
    }
}
```
- @Controller 를 붙이면 내가 인스턴스를 생성 하지 않아도 스프링이 알아서 생성해서 빈으로 관리해줍니다.
  - 그러니까 이런짓 한적이 없는데 어떻게 실체화되서 돌아가냐? 이말이다!
  ```java
  ArticleController articleController = new ArticleController();
  ```
  - 스프링은 ArticleController의 존재를 어떻게 알고 만들어주는 것일까요?
  - ArticleService 라는 필드는 어떻게 주입해주는 걸까요?
  - 모든 메소드의 파라미터 개수, 타입이 다른데 어떻게 알고 해당하는 값을 바인딩 해줄까요?
  - ArticleController을 작성한 개발자는 클래스의 정보를 알겠지만, 스프링은 모릅니다.
- 위 문제를 해결하기 위해서 리플렉션을 사용합니다. 
  - 스프링이 ArticleController의 정보를 알아내기 위해서 사용 (reflection은 반사가 아니라 투영이였다 : 그림자를 어떤 물체 위에 비추는 일/ 도형이나 입체를 다른 평면에 옮기는 일)
  - Spring Framework 는 @Controller 를 갖고있는 클래스를 스캔해서
  - @Controller 를 갖고있는 클래스의 **`인스턴스 생성`** 를 스프링이 한다음에 
  - 위에서 실체화 필드 DI


## Reflecction이 사용되는곳
- 프레임워크, IDE 자동완성 기능, 라이브러리
  - intellij의 자동완성, jackson 라이브러리, Hibernate 등등 많은 프레임워크나 라이브러리에서 Reflection을 사용한다.

- Debuggers and Test Tools
  - 디버깅 혹은 테스트 도구에서도 reflection을 통해 클래스를 탐색하고 private 멤버 혹은 클래스에 접근해서 사용자에게 편리함을 제공한다.
  - 우리가 아는 Spring을 예로 들어보면, Spring Container의 BeanFactory가 reflection을 사용한다.
  - Bean은 애플리케이션이 실행한 후 런타임에 객체가 호출될 때 동적으로 객체의 인스턴스를 생성하는데 이때 Spring Container의 BeanFactory에서 리플렉션을 사용한다.
- Spring Data JPA
  - Spring Data JPA 에서 Entity에 기본 생성자가 필요한 이유인데
  - Spring Data JPA 에서 Entity에 기본 생성자가 필요한 이유는 동적으로 객체를 생성 할 때 Reflection을 활용하기 때문!
  - Reflection API로 생성자의 인자 정보는 가져올 수가 없다. 때문에 기본 생성자가 반드시 있어야 객체를 생성할 수 있다. 기본 생성자로 객체를 생성을 한 뒤 Reflection을 통해 필드 값을 넣어준다. (setter가 없어도 값을 넣을 수 있는 이유!)


## 의존성 주입 예제
- 꼭좀 해봐라 : https://blog.naver.com/swoh1227/222229853664
  - https://github.com/codesquad-study/java/tree/main/Special/Reflection/%EB%85%B8%EC%9D%84
  - https://www.youtube.com/watch?v=7pZq35Cg3D4

# 너무 피곤한데 내일 첫출근이라 빨리 자느라 안하고 잠..
- 이거또 읽어보랭 https://madplay.github.io/post/java-reflection

## 출처
- https://dublin-java.tistory.com/53
- https://docs.oracle.com/javase/tutorial/reflect/
- https://slidetodoc.com/reflection-bibliografie-sun-the-java-tutorials-the-reflection/
- https://woowacourse.github.io/javable/post/2020-07-16-reflection-api/
- https://www.oracle.com/technical-resources/articles/java/javareflection.html
- https://www.geeksforgeeks.org/reflection-in-java/

## 잡설

### Reflection을 사용하는 이유
  - 컴파일 언어(정적인 언어)인 자바에 없는 동적으로 객체를 생성하는 기술을 Reflection으로 대신한다.
- 정적인 언어 : Compile 시점에 타입을 결정하는 언어 (Java, C/C++)
- 동적인 언어 : Runtime 시점에 타입을 결정하는 언어 (Javascript, Python)

### 게임분야(언리얼C++, C#)에서도 동일한 개념의 리플렉션이 등장한다
- https://youtu.be/VpEe9DbcZIs : 언리얼 엔진을 통해 살펴보는 리플렉션과 가비지 컬렉션