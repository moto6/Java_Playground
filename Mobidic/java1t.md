# 자바 스터디 1주차 : JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.

- 참고링크
```
https://sowhat4.tistory.com/61
https://github.com/yeo311/java-study-with-whiteship/tree/main/week1
https://gblee1987.tistory.com/173
https://github.com/kksb0831/Practice_project/blob/master/Java_Study_01.md
https://velog.io/@jaden_94/1%EC%A3%BC%EC%B0%A8-%ED%95%AD%ED%95%B4%EC%9D%BC%EC%A7%80

```

- 백기선장님 목차랑 조금 다릅니다
  - 어차피 늦은거 제 방식대로 순서를 재구성 했고, 포함된 내용은 같습니다

# 목차

- JVM이란?
  - JVM 정의
  - 바이트코드
  - JIT 컴파일러
  - JIT 컴파일러 동작
  - JVM 구성 요소 
- Java 컴파일 및 실행 방법
  - Complie(컴파일) 방법
  - Execute(실행) 실행하는 방법
  - JDK와 JRE의 차이 - 3.자바 컴파일 및 실행 방법
  - 

<br> 
<br> 
<br> 

# JVM이란?
- JVM 정의
  - JVM : Java Virtual Machine, 자바 가상 머신, 컴퓨터가 자바 프로그램을 실행할수 있도록 도와준다.
  - 일종의 런타임 엔진이며, .java 파일이 .class파일로 변경된 후 실행될 때 필요하다

- 자바프로그램을 바로 실행할수는 없을까?
  - 불가능하다!, 왜냐하면 자바는 "compiled interpreted language" 라고 불리는데
  - 자바는
    - Java Source( #.java/소스코드 )는 JVM 에서 실행될 수 있는 Bytecode(#.class / 바이트 코드) 로 번역되며
    - 번역된 바이트 코드는 바이트 코드 해석기가 있는 어떠한 기종의 컴퓨터 환경에서도 실행될 수 있음
  - 컴퓨터(CPU/AP/무슨 프로세서든 간에) 는 오직 바이너리(0 or 1)코드 만 바로 실행 가능하다.


- JVM 이 왜 나왔을까?? 
  - 부제 : 자바가 탄생한 이유 / C & C++ 언어의 단점
    - 메모리 직접 관리하는데 따른 어려움(malloc 에 의한 누수, array인덱스 초과시 펑..) : Garbage Collection이 존재 but, 성능에서는 단점
    - C++에서 대규모 프로젝트를 진행할때의 복잡함 해결
    - OS에 독립적으로 App을 만들고싶어 : java가 처음 등장한 이유는 IOT시대를 대비해 가전제품에서 돌아가는 언어를 제작하기 위해서였다..!


> 잡설 C언어 런타임
  - C언어에도 런타임이 존재하며 crt0라고 부릅니다
  - OS가 없는 System에서는 부트로더에서 C 런타임 환경을 만든뒤에 C언어의 main루틴을 실행시키고
  - 리눅스 OS의 경우 부팅(=커널이 RAM에 로드) 시점에 C언어 런타임이 실행된다. 그래서 알필요가 없지만.. 굳이 궁금하다면 아래 링크를 참고
    - https://ko.wikipedia.org/wiki/Crt0
    - https://shinluckyarchive.tistory.com/266
    - https://fr2eware.tistory.com/29

<br> 
<br> 

## JVM 구성 요소 
- JVM은 대략 아래 4가지로 구성되는데요
  1. Class Loader
  2. GC(Garbage Collector)
  3. Execution Engine
  4. Runtime Data Area

- 하나씩 자세히 살펴보면
  - Class Loader
    - JRE의 일부로, 바이트코드를 실행할 때 class 객체를 메모리에 생성하는 요소이다.
    클래스의 인스턴스를 생성하면 Class Loader를 통해 메모리에 로드한다.
  - GC(Garbage Collector)
    - 자바 언어는 메모리 관리를 App 개발자가 아닌 언어차원에서 알아서 해준다.
    - 특히 JVM이, 그중에서도 GC는 더이상 참조되지 않는 메모리를 정리해준다.
    - GC가 언제 호출되는지는 알 수 없다
    - 사용자가 GC 호출하더라도 메모리 정리할 필요가 없다고 판단되면 실행조차 되지 않는다
  - Execution Engine
    - 메모리에 로드 된 바이트코드를 실행함
    - Class Loader를 통해 Runtime Data Area에 배치된 바이트코드는 Execution Engine에 의해 (인터프리터/ JIT) 둘중 하나의 방식으로 실행한다.

  - Runtime Data Area
    - JVM의 메모리 영역이며 
    - 역할별로 크게 4 부분으로 나눠서 보면
      1. Class 영역 : 실행에 필요한 클래스들을 로드하여 저장한다. 내부에서 메소드 영역과 상수 영역으로
      2. Heap (가비지 컬렉션 힙 영역) 
         - GC에 의해 관리되는 영역이다. 
         - 동적 메모리 할당 영역 이라고도 하며, 소스상에서 new 연산자로 객체를 만들때 할당되는 영역이다.
      3. Stack 1 (런타임 스택 영역)
         - 프로그램 실행 중 발생하는 메소드 호출과 복귀에 대한 정보를 저장한다.
      5. Stack 2 (네이티브 메소드 스택 영역)
         - 자바에는 하드웨어를 직접 제어하는 기능이 없기 때문에, 필요할 경우 C언어와 같은
            이때 사용하는 기술이 JNI (Java Native Interface) 기술로 네이티브 메소드들이 바이트 코드로 변환 되면서 사용되고 기록하는 영역

<br> 
<br> 

# JAVA의 컴파일과 실행
- 자바파일이 실행되기까지의 흐름 (java(bin) 이라는 용어는 언어명 java와 혼동을 피하기 위해 실행가능한 바이너리 라는 의미)
  - ##.java >>>javac>>> ##.class >>>java>>> (실행)
    - javac 은 자바 컴파일러
    - java(bin) 는 JVM이라는 인터프리터를 실행시켜주는 로더?/자바가 인터프리터인가? 개념정리 필요(모호한듯)
  - java(bin) 로 실행 시 JVM의 구성요소인 클래스로더가 fileName.class 파일을 메모리상의 JVM으로 가져온다.
  - 또 java(bin)는 내부적으로 아래 두 단계를 거친다
    - Byte Code Verifier : 바이트코드 변조 확인
    - Execution Engine : 진짜 실행을 하는 단계
  - 여기서 특히 Execution Engine에서는 명령어 단위 실행은 2가지 방식이 있는데
  - (그러니까 바이트코드 형식의 ##.class파일을 진짜 CPU에 기계어 형태로 넣어줘 컴퓨터를 동작시키기 위해서는)
    - Interpreter 방식: 명령어를 하나씩 수행 하는 방식
    - JIT(Just In Time compiler) 방식: 전체 바이트코드를 네이티브 코드로 변환하고 그 이후에는 네이티브 코드로 실행하는 방식
  - 위 두가지가 있다고 한다. (항상 그렇지만 CPU는 어셈블리어(Most Likly기계어) 말고 다른 언어는 알지못한다)

> javac(자바 컴파일러) 옵션

| Option          | discription                                     | example                             |   |   |
|-----------------|-------------------------------------------------|-------------------------------------|---|---|
| -classpath, -cp | 클래스패스, 즉 실행할 클래스의 위치를 지정한다. | javac -cp "/Users/home/A.java"      |   |   |
| -d              | 어디에 클래스파일을 생성할지 지정한다.          | javac -d "/User/home/path"          |   |   |
| -encoding       | 소스 파일에 사용된 인코딩을 지정한다.           | javac -encoding "uft-8" A.java      |   |   |
| -g              | 모든 디버깅 정보를 출력                         | javac -g                            |   |   |
| -verbose, -v    | 컴파일러가 진행하는 작업을 모두 출력한다.       | javac -verbose                      |   |   |
| -sourcepath     | 소스파일 위치 지정                              | javac -sourcepath "/User/home/path" |   |   |
| -source         | 소스파일 자바 버전 지정                         | javac -source 1.8 ~~~               |   |   |
| -target         | 타겟파일 자바 버전 지정                         | javac -target 1.8 ~~~               |   |   |

- Byte(바이트)코드 VS Binary(bit,바이너리) 코드
  - Byte(바이트)코드
    - 자바 소스 코드를 자바 가상 머신이 이해할 수 있는 언어로 변환한 형태 (궁금하면 메모장에 ##.class파일을 열어봐라)
    - 자바 컴파일러로 변환되는 코드의 명령어 크기가 1바이트라서 바이트코드라고 불린다고 한다.
    - OS에 종속적이지 않기 위해서 JVM 이 이해할 수 있는 언어인 바이트코드 형태로 제공되고, OS(요즘 말로는 플랫폼이라고 하던데..)에 따라 JVM을 만들어 주면 APP 개발 입장에서는 똑같이 실행된다!
  - Binary(bit,바이너리)
    - 

> code once run everywhere, 코딩은 한번만 하면 모든 플랫폼에서 동작해유!
  - 자바의 캐치 프레이즈, 아래 몇가지 농담 버전도 있다.
    - code once deploy everywhere
    - code once debug everywhere
    - code once test everywhere

<br> 
<br> 

# JIT 컴파일
- JIT 컴파일이란? (JIT 컴파일(just-in-time compilation) 또는 동적 번역(dynamic translation))
  - 실제 바이트코드를 실행하는 시점에서 자바 가상 머신이 바이트코드를 JIT 컴파일을 통해 기계어로 변환하는 컴파일 기법
  - 원래는 인터프리터로 동작하면 느리다는 단점을 해결하기 위해서 등장한 JIT 컴파일
  - 자바코드를 바이트 코드까지 컴파일 하는게 아니라, 진짜 바이너리(기계어) 수준으로 만들어서 사용하는 개념
    - 전체 Compile 후 Cashing 
    - 이후 변경된 부분만 컴파일하고 나머지는 캐시에서 가져다가 바로 실행한다!
    - 코드 수행속도가 Interpreter 방식에 비해서 빠르다, 바로 꺼내서 사용하고 변경 부분만 컴파일 하기 때문
  - 두 가지의 방식을 혼합함
    - 실행 시점에서 인터프리트 방식으로 기계어 코드를 생성하면서 그 코드를 캐싱하고ㅡ
    -  같은 함수가 여러 번 불릴 때 매번 기계어 코드를 생성하는 것을 방지한다.
- JIT 컴파일러 동작원리
  1. 인라인(Inlining)
     - 인라인은 작은 메서드의 트리를 병합하거나 '인라인'하여 그들의 호출 트리를 만든다. 이렇게하면 자주 호출되는 메서드의 호출 속도가 빨라진다.
  2. 지역 최적화(Local optimizations)
     - 지역 최적화는 한 번에 코드의 작은 부분을 분석하고 성능을 향상시킨다. 주로 코드의 중복된 연산제거, 예측가능한 값의 대치 등이다.
  3. 제어 흐름 최적화(Control flow optimizations)
     - 제어 흐름 최적화는 메서드나 그 내부의 제어 흐름을 분석하고 코드 경로를 재정렬하여 효율성을 향상시킨다.
  4. 전역 최적화(Global optimizations)
     - 전역 최적화는 전체 메서드에서 즉시 작동한다. 그들은 더 비싼 컴파일 시간을 요구하지만 성능을 크게 향상시킬 수 있다.
  5. 네이티브 코드 생성(Native code generation)
     - 네이티브 코드 생성은 플랫폼 아키텍처에 따라 다르다. 일반적으로 컴파일러는 이 단계에서 메서드 트리를 네이티브 코드로 변환한다. 일부 작은 최적화가 아키텍처 특성에 따라 수행된다.

<br> 
<br> 

# JDK와 JRD의 차이
- JDK : Java Development Kit, 개발도구
- JRE : Java Runtime Environment, 실행환경
- 해설 : 개발을 위해서는 DK, 프로그램 실행만을 위해서는 RE

<br> 
<br> 
<br> 

# 끝


<br> 
<br> 
<br> 

#


<br> 
<br> 
<br> 

#
