# 어노테이션
- 목표 : 어노테이션 학습하기
- 필수학습사항
  - 애노테이션 정의하는 방법
  - 필수 어노테이션
    - **[@retention]()**
    - **[@target]()**
    - **[@documented]()**
  - 애노테이션 프로세서


## 어노테이션이란?
- 추가적인 정보를 제공해주는 메타 데이터
- 코드(데이터)는 아니지만 정보를 담고 있어서 메타데이터 
- 단어의 의미인 주석과는 비슷하지만 다른 역할로써 사용되는데 메서드/클래스 등에 의미를 단순히 컴파일러에게 알려주기 위한 표식이 아닌 컴파일타임 이나 런타임에 해석되어 (static한)정보들을 (자바프로그램에게)제공해 줄 수 있다
- 할수 있는 것들
  - **metadata** : 유효성 검사, 문서화
    - 데이터를 설명 해 주는 데이터
  - **reflection** : 특정 클래스를 주입 
    - 객체를 분석(=반사/투영) 을 통해서 클래스의 정보를 분석해내는 기법

### 주석(comment)과 어노테이션(annotation) 차이

- comment : 자바 코드상에서/프로그램에게 아무런 영향을 줄수 없다!
- annotation : **다른 프로그램에게** 미리 약속된 형식의 정보를 제공한다 (ex:스프링 프레임워크)
- 내생각 : 코멘트와 어노테이션의 차이는 프로그램(자바)에게 정보(메타데이터)를 줄수 있는지에 대한 차이로 구별하면 된다. 

### 백기선님 강의중 포인트
- 어노테이션은 코드에 넣는 주석이다.
  - 완전히 주석같지 않지만, 주석과 비슷한 류의 장치다.
  - 주석이기 때문에, 실행되는 코드라고 생각하면 안된다.
- 어노테이션이 **마치 기능을 가지고 있는 것이라 생각할 수 있으나, 오해이며 그렇지 않다!**
  - 어노테이션은 마크, 표시 해놓는 주석이다! 
  - **어노테이션에 다이나믹하게 실행되는 코드는 들어가지 않음**
  - **런타임중에 알아내야 하는 값은 못들어 감**
- 어노테이션이 주석이고 정보를 제공한다고 했는데, 제공할수 있는 정보들은 **무.적.권**
  - 컴파일러 수준에서 해석이 되는것
  - 완전히 정적인 것들
  - 동적으로 런타임중에 바뀌어야 하는 것들은 애노테이션에 사용할 수 없다
- 면접질문이였는데...
```java
@RestController
public HelloController{
	
	private static final String hello = "hello";

	@GetMapping(hello)
	public String hello(){
		return "hello";
	}
	
}
```
- 위와 같이 hello 변수는 *static final* 한 정적 변수임으로 GetMapping 애노테이션에 사용할 수 있다.
- **but.** hello가 동적인 변수라면? (final이 없음)
```java
private String hello = "hello"; → @GetMapping(hello)*
```
- 컴파일 에러 발생
- 지금까지 어노테이션을 붙였던걸 다 생각해보면 정적인 요소들(클래스, 메서드, 필드변수의 프로토타입 등등..)에만 붙였다는걸 반추합시다!

### 어노테이션의 민낮 : 바이트코드에선 어떨까?
- 먼저 자바파일
```java
package com.dong.annotation;
public @interface MyAnnotation {

}
```
- 클래스 파일
```java
Picked up JAVA_TOOL_OPTIONS: -Djava.net.preferIPv4Stack=true
Compiled from "MyAnnotation.java"
public interface com.dong.annotation.MyAnnotation extends java.lang.annotation.Annotation {
}
```
- 컴파일 완료된 바이트코드를 살펴보면 java.lang.annotation.Annotation 이 extends 되어 있다
- 스터디를 진행하면서 어떤 의미인지 공부해봐요 :D

## 어노테이션 편가르기
- 어노테이션을 좀 분할정복 해보면
- 두가지 관점으로 분류해볼수 있는데
  - 먼저 어노테이션을 누가 제공해주는지에 따라서
  - 다음으로 사용 목적과 용도에 따른

### 어노테이션 제공자에 따른 분류
- 어노테이션 제공자에 따라서는종류가 있다
  - JDK 기본 제공 어노테이션 
  - JDK 이외의 어노테이션 
    - 우리가 스프링개발할때 쓰던것들...

### 사용목적/용도에 따른 분류
- 다른 관점으로는 사용목적과 용도에 따라서 어노테이션을 분류해 볼수 있는데
  1. Maker 어노테이션 : 멤버 변수가 없고 컴파일러에게 의미를 전달하기 위한 표식으로 사용되는 어노테이션 (ex. @Override )
  2. Single-value 어노테이션 : 멤버로 단일변수를 갖고 데이터를 전달할 수 있는 어노테이션
  3. Full 어노테이션 : 둘 이상의 변수를 갖는 어노테이션으로 데이터를 키 = 값형태로 전달한다.

## JDK가 기본으로 제공하는 어노테이션
- - Java/JDK 에 내장되어 기본 제공해주는 어노테이션은 또 두가지 종류가 있다.........
  - 1)Built-in : 빌트-인 어노테이션
    - 진짜 어노테이션으로 쓰이는거
  - 2)Meta : 메타 어노테이션
    - 어노테이션을 만들기 위한 어노테이션

### 1)Built-in Annotataion
- 빌트-인 어노테이션 정리

|어노테이션|설명|
| :-- | :-- |
|@Override| 컴파일러에게 이 메서드는 슈퍼클래스의 메서드를 오바리이딩하는 메서드라는 것을 명시, 동일한 시그니쳐의 메소드가 없다면 컴파일 에러를 발생시키기 때문에 실수도 미리 바로잡아준다 
|@Deprecated| 다음 버전에서는 지원되지 않으므로 ,앞으로 사용하지 않을 것을 권장하는 대상에 붙임 
|@SuppressWarnings| 경고 메시지를 제거함,컴파일러의 특정 경고메시지가 나타나지 않게 해주는데, 개발자가 의도를 가지고 설계를 했는데 컴파일은 이를 알지 못하고 컴파일 경고를 띄울 수 있기 때문에 사용
|@SafeVarargs| 제네릭스 타입의 가변인자에 사용한다, 가변인자 매개변수 사용시 경고를 무시 (JDK 1.7이상 사용가능)
|@FunctionalInterface| 함수형 인터페이스라는 것을 알린다. (JDK 1.8) 
|@Native native| 네이티브 메서드에서 참조되는 상수 앞에 붙인다. (JDK 1.8) 

- 질문의 추억  
  - 제네릭 : 사용할 클래스,메서드 내부에서의 데이터타입을 외부에서 지정하는 기법
  - 함수형 인터페이스 : 1개의 추상 메서드만을 갖고 있는 인터페이스, 자바에서 람다식을 구현하기 위해 사용


### 2)Meta Annotataion

- 메타 어노테이션은 기본으로 제공하는 어노테이션이긴 한데...
- 애너테이션을 정의할 때 애너테이션의 적용대상(target) 이나 유지기간(retention), 상속(Inherited)을 지정
- 한줄요약 : 어노테이션을 만들기 위한 어노테이션
  - 갑자기 생각든건데 메타가 약간 비슷하지만 어긋나서 확실히 같지 않은것들을 대충 묶어서 부르는거 같다
    - **메타포(metaphor) - 어떤 말을 전화된 의미로 사용하여 그것의 상징 의미나 특징과 매우 유사한 개념의 내용을 명확히 하는 작용**
- 메타 어노테이션 정리

|어노테이션|설명|
| :-- | :-- |
|@Target(*)| 어노테이션이 적용가능한 대상을 지정하는데 사용한다. 
|@Documented(*)| 어노테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다. 
|@Inherited(*)| 어노테이션이 자손 클래스에게도 상속되도록 한다. 
|@Retention(*)| 어노테이션이 유지되는 범위를 지정하는데 사용한다. 
|@Repeatable(*)| 어노테이션을 반복해서 사용(선언..?)할 수 있게 한다. (JDK 1.8)
- Retention, Target 어노테이션 설명은 길어져서 아래로 따로 뺌


### 3)이외.. JDK가 기본으로 제공해주지 않는 어노테이션

- 위에서 설명한거 빼고 전부다!
- Spring 제공 어노테이션 - (@Service / @Controller / @SpringApplication)
- Rombok 제공 
- 우리들이 만들어낸 어노테이션 (웹서버 과제 로치..?)

## 어노테이션의 용도
- 어노테이션은 크게 4가지 용도/목적이 있는데
  - 1)문서화
  - 2)컴파일러 체크
  - 3)코드 분석(+자동생성)
  - 4)런타임 프로세싱

- 1)컴파일러 체크
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

## 커스텀 어노테이션 사용법
- 만들게 되면 @interface의 형태로 만들어지고 위의 메타 어노테이션을 붙여 메타 데이터를 표시할 수도 있다.
- @interface 안에서 추가할수 있는 요소들로는
  - 매개변수가 없다면 Maker
  - 코드와 같이 한개만 존재한다면 Single-value
  - 두개이상을 갖는다면 Full어노테이션으로 구분 
  - 매개변수의 default값을 지정해줄 수 있음
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

## 사용법 예제코드와 테스트코드
- 

- 결과
  - 결과물을 보면 매개변수의 값은 이름없음이지만 각 필드에 할당된 어노테이션의 필드 값은 다른 것을 볼 수 있다.
  - 만일, 어노테이션에 Retention을 RUNTIME으로 하지 않으면 아래와 같이 런타임시에 동작하는 reflection을 이용해서 값을 불러오지 못한다.






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


## @Type : 적용(동작) 대상 지정

- 코드상에서 어노테이션을 적용할 수 있는 대상/범위/적용가능한 범위를 지정
- 어노테이션을 작성할 때 지정해 줘야 함
- 만약 다른 타입이 온다면 컴파일 에러 발생
- ElmentType이라는 enum을 통해 지정
  - `@Target(ElemntType.~)` 형식으로 사용
- java.lang.annotation.ElementType 열거형 상수로 정의되어 있음
- 예제는 '@SuppressWarnings' 정의
  - 이 애너테이션에 적용할 수 있는 대상을 '@Target' 으로 지정한다.
  - 여러 개의 값을 지정할 때는 배열처럼 괄호{} 를 이용하여 지정할 수 있다.
```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings{
	String[] value();
}
```

- ElementType 내용 소개

|ElementType 열거형 상수 | 적용 대상 |설명|
| :------ | :--- | :--- | 
|TYPE|클래스, 인터페이스, 열거 타입|Class, Interface(어노테이션 타입 포함), enum, jdk14에 생긴 record|
|ANNOTATION_TYPE|어노테이션||
|FIELD|필드 값|프로퍼티, enum 포함|
|CONSTRUCTOR|생성자||
|LOCAL_VARIABLE|로컬변수||
|PACKAGE|패키지||
|METHOD|메소드||
|PARAMETER | 메서드 파라미터 (매개 변수) | 
|TYPE_PARAMETER|타입 매개 변수|
|TYPE_USE | 타입 사용 |jdk 9 이후|
|MODULE | 모듈|
|RECORD_COMPONENT | Record 컴포넌트 | jdk14이후|


> Tip : static import문을 사용하면 ElementType.[TYPE] 이 아니라 [TYPE] 과 같이 간략히 사용할 수 있다.
- 타입 추가설명 
  - **`TYPE`** : **타입을 선언할 때** 애너테이션을 붙일 수 있다는 뜻
  - **`TYPE_USE`** : 해당 타입의 **변수를 선언할 때** 붙일 수 있다는 뜻이다.
  - **`FIELD`** : **기본형**에 사용할 수 있고(프리미티브 타입 : int, char)
  - **`TYPE_USE`** : **참조형**에 사용(레퍼런스 타입 : String, Inteager)
- 타입 선언부
    - 제네릭 타입, 변수 타입, 매개변수 타입, 예외 타입....
- **타입에 사용할 수 있으려면**
    - **`TYPE_PARAMETER`** : 타입 변수에만 사용할 수 있다.
    - **`TYPE_USE`** : 타입 변수를 포함해서 모든 타입 선언부에 사용할 수 있다.

```java
import static java.lang.annotation.ElementType.*;

@Target({FIELD, TYPE, TYPE_USE})
public @interface MyAnnotation{}

@MyAnnotation                // 적용 대상이 TYPE 인 경우
class MyClass{

	@MyAnnotation              // 적용 대상이 FIELD 인 경우
	int i;

	@MyAnnotation              // 적용 대상이 TYPE_USE 인 경우
	MyClass myClass;

}
```

```java
public enum ElementType {
    TYPE,
    FIELD,
    METHOD,
    PARAMETER,
    CONSTRUCTOR,
    LOCAL_VARIABLE,
    ANNOTATION_TYPE,
    PACKAGE,
    TYPE_PARAMETER,
    TYPE_USE,
    MODULE,

    @jdk.internal.PreviewFeature(feature=jdk.internal.PreviewFeature.Feature.RECORDS,essentialAPI=true)
    RECORD_COMPONENT;
}
```


### 어노테이션 적용 대상 지정 방법
- @Target 어노테이션으로 적용 대상 지정
  - 어노테이션 적용 대상을 지정하기 위해서 어노테이션을 사용한다
- @Target 의 기본 엘리먼트인 value의 타입은 ElementType배열
```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface AnnotationName{...}
```
- TYPE, FILED, METHOD 세가지 경우에 어노테이션을 적용 할 수 있다

## @Retention : 어노테이션 유지 정책
- 어노테이션의 유통기한을 지정하는건데 : 어노테이션 적용 코드가 유지되는 시점을 지정하는 것 **(Life Time)**
- java.lang.annotataion.RetentionPolicy 에 열거형 상수로 정의되어 있음
- RetentionPolicy 소개

|RetentionPolicy 열거형 상수|설명|
| :-- | :-- |
|SOURCE|소스코드상에서만 어노테이션에 의미가 있고, 바이트코드상에서는 정보가 없음, 컴파일러에 의해 버려지는 정보|
|CLASS|바이트 코드 파일까지 어노테이션 정보를 유지, 리플렉션을 이용할수 없다, 클래스파일에는 존재하지만 런타임 시에 유지할 필요 없다는 것을 알리고 이 값이 default이다|
|RUNTIME| 클래스파일에도 존재하고 런타임애 VM에 의해 유지되어 리플랙션을 통해 클래스 파일의 정보를 읽어 처리 가능하다.
```java
public enum RetentionPolicy {
    SOURCE,
    CLASS,
    RUNTIME
}
```
- 유지정책 설정하기
```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 런타임으로 리텐션 설정
public @interface AnnotationName{...}
```

### Retention Policy 강의중 
- 더 많은 내용은 바닥글에 잡설 참고
- **`CLASS`**
    - 애노테이션에 대한 정보를 클래스 파일까지, 즉 바이트 코드에도 남겨 두겠다.
    - 클래스 정보를 읽어들이는 방법(바이트 코드를 읽어들이는)을 바탕으로 애노테이션 정보를 읽어와서 처리할 수 있다.
        - 예) BYTE BUDDY, ASM 활용
    - 바이트 코드엔 남아 있지만, ***이 클래스파일을 JVM이 실행할 때 클래스에 대한 정보를 클래스로더가 읽어서 메모리에 적재하게되고,*** *이후 사용 시점에 메모리에서 읽어올 때 애노테이션 정보를 제외하고 읽어옴*

- **`RUNTIME`**
    - 위 CLASS와 동일하지만, ***메모리에 적재된 클래스 정보를 읽어올 때 애노테이션 정보를 그대로 포함하는 것이다.***




### Reflection(리플렉션) 이란?
- 런타임에 클래스의 메타정보를 얻는 기능 , 실행도중에 동적으로 알아낼 수 있다
  - 클래스 메타정보 : 클래스 이름, 클래스 필드 갯수,정보,타입 등등, 
    - 생성자 몇개 새ㅔ
    - 메서드가 뭐고 몇개있고 등등...
- 런타임에 어노테이션 정보를 얻으려면 RetentionPolicy 를 꼭 RUNTIME 으로 설정 해야 함

## 어노테이션 프로세서
- 런타임시에 리플랙션을 사용하는 어노테이션과 달리
- 컴파일 타임에 이루어지는것을 어노테이션 프로세서
- 컴파일 타임에 어노테이션들을 프로세싱하는 javac에 속한 빌드 툴로 어노테이션의 소스코드를 분석하고 처리하기 위해 사용되는 훅(갈고리?)이다.
- 보일러플레이트 코드를 제거하는데 도움이 된다.
  - ( AbstractProcessor를 implements하여 구현체를 만들 수 있으며 Lombok의 @Getter, @Setter와 같은 어노테이션을 이용하는 것만으로도 컴파일 타임에 알아서 getter/setter를 만들어주는 방식으로 보일러플레이트 코드 제거 )
### 어노테이션 프로세서는 보완이 필요하다
- 호눅스 예제인데 몰라
- https://velog.io/@honux/백기선-자바-라이브-스터디-13-Annotation
```
package com.example;

@SupportedSourceVersion(SourceVersion.latestSupported())
@SupportedAnnotationTypes({
   // Set of full qullified annotation type names
 })
public class MyProcessor extends AbstractProcessor {

	@Override
	public synchronized void init(ProcessingEnvironment env){ }

	@Override
	public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) { }
}
```

## 출처
- https://gowoonsori.site/java/annotation/
  - 빌트인 어노테이션의 개념이 참 좋았다
- https://www.notion.so/37d183f38389426d9700453f00253532
  - 백기선님 수업 이때 의욕이 없어서 안들었는데 열심히 들은척 할수 있어서 참 좋다

--------------

## 끝!!

--------------

## 잡설

- 좋긴한데.. 좀 늘어져서 뒤로 뺀것들

### 그래서 왜 어노테이션 쓰냐고 
```
- 왜 어노테이션을 써야되나? 코드+주석으로는 안될까???
  
  - 자바를 개발한 사람들은 소스코드에 대한 문서를 따로 만들기보다 소스코드와 문서를 하나의 파일로 관리하는 것이 낫다고 생각했다.
  
  - 먼저 소스코드의 주석 '/** ~ */' 에 소스코드에 대한 정보를 저장하고, 소스코드의 주석으로부터 HTML 문서를 생성해내는 프로그램(javadoc.exe)를 만들어 사용했는데 사람들이 생각보다 문서를 안읽더라
  
  - 그래서 나온게 "프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함" 시키자! 라는 아이디어에서 탄생한 문법적인 요소가 어노테이션
  
  - 애너테이션은 주석(comment)처럼 프로그래밍 언어에 영향을 미치지 않으면서도 **(코드를 읽는 개발자)** 와 **(다른 프로그램에게)** 유용한 정보들을 제공한다

- 사전적 의미는 
  - Annotation : 주석, 메모
  - comment : 주석, 메모........
```

### 어노테이션 장점이 뭔데

```
- 장점

- 기존의 자바는 선언적 프로그래밍방식으로 개발을 하면서 각 계층별 설정 데이터들을 XML에 명시했었는데 서비스의 규모가 클 수록 설정양이 많아지고 도메인 처리의 데이터들이 분산되어 있어 수정이 힘들었다.

- 어노테이션이 등장하면서 데이터 유효성 검사 등 직접 클래스에 명시해 줄 수 있게되어 수정이 필요할때 쉽게 파악할 수 있게 되었고 어토테이션의 재사용도 가능해졌다.

- AOP(관점 지향 프로그래밍)을 쉽게 구성할 수 있게 해준다.
```

### 리텐션 폴리시(어노테이션 유지정책) 강의중 포인트
- *SOURCE → CLASS → RUNTIME*

- `**SOURCE`** 는 소스코드에만 유지하겠다.
    - 컴파일 시에만 사용하겠다는 의미 !
    - 컴파일 하고 나면 애노테이션은 없어진다.

        → 필요없으니까!, 바이트 코드에 남아있지도 않다.

- `**CLASS**`
    - 애노테이션에 대한 정보를 클래스 파일까지, 즉 바이트 코드에도 남겨 두겠다.
    - 클래스 정보를 읽어들이는 방법(바이트 코드를 읽어들이는)을 바탕으로 애노테이션 정보를 읽어와서 처리할 수 있다.
        - 예) BYTE BUDDY, ASM 활용
    - 바이트 코드엔 남아 있지만, ***이 클래스파일을 JVM이 실행할 때 클래스에 대한 정보를 클래스로더가 읽어서 메모리에 적재하게되고,*** *이후 사용 시점에 메모리에서 읽어올 때 애노테이션 정보를 제외하고 읽어옴*

- **`RUNTIME`**
    - 위 CLASS와 동일하지만, ***메모리에 적재된 클래스 정보를 읽어올 때 애노테이션 정보를 그대로 포함하는 것이다.***

바이트 코드에서 읽어오는게 빠르냐? 

- RetentionPolicy를 CLASS로 한 이후, 바이트코드를 읽어 처리하는 라이브러리를 활용?!

리플렉션으로 읽어오는게 빠르냐? 

- RetentionPolicy를 RUNTIME로 하여 리플렉션 기술을 활용?!

→ 몰라요. 리플렉션 자체가 부하가 있긴하다.

→ 바이트 코드의 양에 영향

→ 리플렉션은 메모리에 이미 올라와있는 정보를 읽는 것, 클래스 로더가 읽고 메모리에 적재시킨 후 읽어오는 것,

→ 직접 확인해봐야 한다!

커스텀하게 만든 애노테이션이 정말로 `**RUNTIME`** 까지 필요한 정보인가?

RUNTIME 까지 사용할 필요가 없다면, CLASS 레벨로 내려가거나 SOURCE 레벨로 내려갈 수도 있을 것이다.

그냥, 의례적으로 RUNTIME으로 작성하는 경우가 있었다면? 그 역할을 다시 살펴보고 명확한 Retention Policy 를 정의하자.

---

표준 애너테이션 중 **'@Override'** 나 **'@SuppressWarnings'** 처럼 
컴파일러가 사용하는 애너테이션은 **`유지 정책이 'SOURCE'`** 이다. 
→ 컴파일러를 직접 작성할 것이 아니면, SOURCE 이상의 유지정책을 가질 필요가 없다.

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override{}
```

유지 정책을 **`RUNTIME`** 으로 한다면,

실행 시에 **`리플렉션(Reflection)`** 을 통해 클래스 파일에 저장된 애너테이션의 정보를 읽어서 처리 할 수 있다.

- Retention 정책은 RUNTIME 으로 정의하고
- Target은 TYPE과 FIELD로 정의한다.

```java
package com.ssonsh.study.annotationstudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface SsonAnnotation {
}
```

- Target이 TYPE과 FIELD 임으로 클래스에도 애노테이션을 선언할 수 있고
- 클래스 내부의 필드에도 애노테이션을 선언할 수 있다.

```java
package com.ssonsh.study.annotationstudy;

@SsonAnnotation
public class SsonClass {

    @SsonAnnotation
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

- [SsonClass](http://ssonclass.java) 클래스에 선언된 Annotation을 리플랙션을 이용해 확인할 수 있다.

```java
package com.ssonsh.study.annotationstudy;

import java.lang.reflect.Field;
import java.util.Arrays;

public class App {

    public static void main(String[] args){

        Arrays.stream(SsonClass.class.getAnnotations()).forEach(System.out::println);

        Field[] declaredFields = SsonClass.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Arrays.stream(declaredField.getAnnotations()).forEach(System.out::println);
        }
    }
}
```

결과

```java
"C:\Program Files\Java\jdk1.8.0_251\bin\java.exe" -agentlib:jdwp=transport=dt_shmem,address=javadebug,suspend=y,server=n -javaagent:C:\Users\ssh1224\.IntelliJIdea2019.3\system\captureAgent\debugger-agent.jar -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_251\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\rt.jar;D:\dev\workspace\java-study\out\production\java-study;D:\dev\workspace\java-study\lib\archunit-0.12.0.jar;D:\dev\workspace\java-study\lib\slf4j-api-1.7.25.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.5\lib\idea_rt.jar" com.ssonsh.study.annotationstudy.App
Connected to the target VM, address: 'javadebug', transport: 'shared memory'
@com.ssonsh.study.annotationstudy.SsonAnnotation()
@com.ssonsh.study.annotationstudy.SsonAnnotation()
Disconnected from the target VM, address: 'javadebug', transport: 'shared memory'
Picked up JAVA_TOOL_OPTIONS: -Djava.net.preferIPv4Stack=true

Process finished with exit code 0
```

표준 애너테이션 중 **`'@FunctionalInterface'`** 는 '@Override' 처럼 컴파일러가 체크해주는 애너테이션이지만, **실행 시에도 사용되므로 유지 정책이 "RUNTIME"으로 되어 있다.**

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FunctionalInterface{}
```

유지 정책을 **`"CLASS"`** 으로 한다면 

컴파일러가 애너테이션의 정보를 클래스 파일에 저장할 수 있게 하지만,

클래스 파일이 **JVM에 로딩 될 때는 애너테이션의 정보가 무시**되어 실행 시에 애너테이션에 대한 정보를 얻을 수 없다.

→ CLASS 가 유지정책의 기본값임에도 불구하고 잘 사용되지 않는 이유

지역 변수에 붙은 애너테이션은 컴파일러만 인식할 수 있으므로, 유지 정책이 RUNTIME인 애너테이션을 지역변수에 붙여도 실행 시에는 인식되지 않는다.

- `**유지 정책을 CLASS**`로 변경하여 위에서 확인한 예시를 실행해보자.

```java
package com.ssonsh.study.annotationstudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface SsonAnnotation {
}
```

```java
package com.ssonsh.study.annotationstudy;

import java.lang.reflect.Field;
import java.util.Arrays;

public class App {

    public static void main(String[] args){

        Arrays.stream(SsonClass.class.getAnnotations()).forEach(System.out::println);

        Field[] declaredFields = SsonClass.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Arrays.stream(declaredField.getAnnotations()).forEach(System.out::println);
        }
    }
}
```

결과

```java
"C:\Program Files\Java\jdk1.8.0_251\bin\java.exe" -agentlib:jdwp=transport=dt_shmem,address=javadebug,suspend=y,server=n -javaagent:C:\Users\ssh1224\.IntelliJIdea2019.3\system\captureAgent\debugger-agent.jar -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_251\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_251\jre\lib\rt.jar;D:\dev\workspace\java-study\out\production\java-study;D:\dev\workspace\java-study\lib\archunit-0.12.0.jar;D:\dev\workspace\java-study\lib\slf4j-api-1.7.25.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.5\lib\idea_rt.jar" com.ssonsh.study.annotationstudy.App
Connected to the target VM, address: 'javadebug', transport: 'shared memory'
Disconnected from the target VM, address: 'javadebug', transport: 'shared memory'
Picked up JAVA_TOOL_OPTIONS: -Djava.net.preferIPv4Stack=true

Process finished with exit code 0
```

런타임 시 리플랙션을 이용해 선언된 애노테이션을 가져오고자 하였으나, 아무런 정보가 출력되지 않음을 확인할 수 있다. (유지정책 → CLASS)
