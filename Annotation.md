# 어노테이션

## 어노테이션이란?
- 추가적인 정보를 제공해주는 메타 데이터
- 코드(데이터)는 아니지만 정보를 담고 있어서 메타데이터 

## 용도
- 컴파일러 체크
  - 코드 작성 문법 에러를 체크하도록 정보 제공
  - 예시
    - @override : 부모클래스에 메서드를 오버라이드 한다는걸 알려줌
    - 
- 개발툴이
  - 예시
    - Jar로 컴파일하는지, War로 컴파일하는지 
- 특정 기능이나 역할을 수행하도록 정보를 제공
  - 예시
    - @Service / @Controller / @SpringApplication
    -

## 어노테이션 사용법

### 타입정의
- 자바코드 작성 : DongAnnotation.java
```java
public @interface DongAnnotation {

}
```

### 어노테이션 사용하기
```java
@DongAnnotation
```

### 어노테이션의 엘리먼트 맴버
- 엘리먼트 : 어노테이션을 코드에 적용할 떄 외부의 값을 입력받을 수 있도록 하는 역할
```java
public @interface DongAnnotation {
    <Type> elementName() [Default 값]; //어노테이션의 엘리먼트를 선언
    int elementName() [Default 값]; //두개 이상의 엘리먼트를 선언할수 있고
    Inteager elementName() ; // 엘리먼트에는 타입자료형도 사용할 수 있고 "[Default 값]" 도 없어도 된다
    
}
```
- 기본타입과 참조타입(레퍼런스, 프리미티브) 둘다 사용할 수 있다
```java
public @interface DongAnnotation {
    String elementName1();
    int elementName2() default 5;
}
```
### 어노테이션 사용
- 
```java
@AnnotationName(elementName1 = '값', elementName2 = 3);
@AnnotationName(elementName1 = '값'); // default 를 명시하였으므로 따로 지정하지 않아도 된다
```
- 실제 사용 예시
```java
@Controller(name="main")
public class MainController{...}
```
```java
@Controller(name="main")
public class MainController{...}
```
```java
@JsonProperty("user_id")
private String userId;
@JsonProperty("user_password")
private String userPassword;
```

## 특별한 엘리먼트 : (기본 엘리먼트 / value 엘리먼트)
- value 라는 특별한 엘리먼트가 있는데, 사용법을 알아보면
- 엘리먼트를 포함하는 어노테이션을 선언하고
```java
public @Interface AnnotationName{
    String value(); // value라는 엘리먼트를 만들어놓으면
    int count() default 5;
}
```
- value는 특별해서 어노테이션을 적용할 때 엘리먼트의 이름을 생략할 수 있다
```java
@AnnotataionName("값"); // 이렇게 해도 된다! 왜냐면 value는 특별하기 때문에
@AnnotataionName(value="값"); // 원래는 이렇게 써야하는데
```
- 두 개 이상의 속성을 기술할 때에는 value=값 형태로 꼭 기술
```java
@AnnotataionName(value="값", count=7);
```

## 어노테이션의 적용 대상
- 코드상에서 어노테이션을 적용할 수 있는 대상/범위를 지정
- 어노테이션을 작성할 때 지정해 줘야 함
- java.lang.annotation.ElementType 열거형 상수로 정의되어 있음

### ElementType 내용 소개

|ElementType 열거형 상수 | 적용 대상 |설명|
| :------ | :--- | :--- | 
|TYPE|클래스, 인터페이스, 열거 타입||
|ANNOTATION_TYPE|어노테이션||
|FIELD|필드||
|CONSTRUCTOR|생성자||
|METHOD|메소드||
|LOCAL_VARIABLE|로컬변수||
|PACKAGE|패키지||

### 어노테이션 적용 대상 지정 방법
- @Target 어노테이션으로 적용 대상 지정
  - 어노테이션 적용 대상을 지정하기 위해서 어노테이션을 사용한다
- @Target 의 기본 엘리먼트인 value의 타입은 ElementType배열
```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface AnnotationName{...}
```
- TYPE, FILED, METHOD 세가지 경우에 어노테이션을 적용 할 수 있다

## 어노테이션 유지 정책
- 어노테이션의 유통기한을 지정하는건데 : 어노테이션 적용 코드가 유지되는 시점을 지정하는 것
- java.lang.annotataion.RetentionPolicy 에 열거형 상수로 정의되어 있음
- RetentionPolicy 소개

|RetentionPolicy 열거형 상수|설명|
| :-- | :-- |
|SOURCE|소스코드상에서만 어노테이션에 의미가 있고, 바이트코드상에서는 정보가 없음|
|CLASS|바이트 코드 파일까지 어노테이션 정보를 유지, 리플렉션을 이용할수 없다|
|RUNTIME||

- 유지정책 설정하기
```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 런타임으로 리텐션 설정
public @interface AnnotationName{...}
```

### Reflection(리플렉션) 이란?
- 런타임에 클래스의 메타정보를 얻는 기능 , 실행도중에 동적으로 알아낼 수 있다
  - 클래스 메타정보 : 클래스 이름, 클래스 필드 갯수,정보,타입 등등, 
    - 생성자 몇개 새ㅔ
    - 메서드가 뭐고 몇개있고 등등...
- 런타임에 어노테이션 정보를 얻으려면 RetentionPolicy 를 꼭 RUNTIME 으로 설정 해야 함
