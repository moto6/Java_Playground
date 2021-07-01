# 자바 스터디 2주차 : 자바 데이터 타입, 변수 그리고 배열
- 목표 : 자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.

<br>

- 학습할 것
  - 프리미티브 타입 종류와 값의 범위 그리고 기본 값
  - 프리미티브 타입과 레퍼런스 타입
  - 리터럴
  - 변수 선언 및 초기화하는 방법
  - 변수의 스코프와 라이프타임
  - 타입 변환, 캐스팅 그리고 타입 프로모션
  - 1차 및 2차 배열 선언하기
  - 타입 추론, var

<br>

- 참고링크
```

깊은복사 얕은복사 : https://woovictory.github.io/2020/04/22/Java-Array-Copy/
```


# 목차
```
```

<br> 
<br> 

# 프리미티브 타입 (Primitive type / 원시타입)
## 프리미티브 타입 종류와 값의 범위 그리고 기본 값
- primitive type (프리미티브 타입) 원시 타입/기본형 타입 이라고 부른다
- type(타입)이란 Data Type의 줄임말로 우리말로는 "자료형" 입니다.
  - 컴퓨터 관점에서 
  - 메모리공간에 주소<0x ##~> 위치에 <010101..> 저장되어 있는 이 값이 int형인지 Double인지 구분하기 위해서 필요함
  - 
| 프리미티브 타입 | 메모리 크기 | 기본값 | 설명 | 표현범위 | 
|------------|-----------|------------|------------|------------|
| boolean    | 1 bit..|  false|논리|  T/f    |
| byte       | 1 Byte |  0   |정수|  -128/+7    |
| short      | 2 Byte |  0   |정수|  -32,768/+7   |
| int        | 4 Byte |  0   |정수|  -2,147,483,648/+7  |
| long       | 8 Byte |  0   |정수|  -9,223,372,036,854,775,808/+7  |
| float      | 8 Byte |  0   |정수| |
| double     | 8 Byte |  0   |정수|  |
| char       | 2 Byte |  0   |정수|  |
- 여기서 눈여겨볼것은 char은 기본 2바이트이고 유니코드를 지원한다.
- C/C++에서는 char이 1byte - SBCS(Single Byte Character Set) 
- 자바에서는 2byte임을 기억하자 MBCS(Multi Byte Character Set)
- unsigned 형도 없다.
- (설..) byte든 short이든 JVM 내부에서는 그냥 다 4바이트로 관리하니까 무적권 int만 쓰기를 추천 ->> 추후 조사필요
   - 크기가 큰 배열의 경우 이야기가 다르지만..

<br> 
<br> 

# 레퍼런스 타입 (Reference type / 참조형 타입)
- 위에서 프리미티브 타입은 배웠는데, 그러면 레퍼런스 타입은 뭘까?
- 위에서 말한 기본형(프리미티브) 타입 제외하고 나머지 자료형 모두 다!
  - 레퍼런스 타입 = Reference type = 참조형 타입
- 빈 객체를 의미하는 Null이 존재하는데, 실제로 프로그래머가 사용하지는 못하지만 포인터라는걸 알수 있다
- 주소만을 저장하고 있고, 실제 데이터는 주소가 가르키는 곳에 가지고 있다.(레퍼런스 타입은 일종의 포인터변수처럼 동작)
- 힙(Heap) 메모리에 저장된다.
  - 프리미티브 타입은 스텍이다.
- 그래서 자바에서는 런타임 에러중에서 NullPointException이 꽤 흔히 발생하는데, Null 값을 받는경우 발생한다.
- 구체적으로 레퍼런스 타입에 뭐가있는지 살펴보면

| 레퍼런스 타입 | 메모리 크기 | 기본값 | 설명 | 예제 |
|------------|------------|------------|------------|------------|------|
| Array(배열)        | 4/8 Byte  |  Null  |       | int[] arr = new |int[7];     |
| Enumeration(열겨)  | 4/8 Byte  |  Null  |       |       |
| Class(클래스)      | 4/8 Byte  |  Null  |       | String mystr = "hi world";      |
|  -     | 4/8 Byte  |  Null  |       |       |
|||||

- 설명
  - 4/8 Byte 인 이유는 포인터이니까 
    - 32비트 시스템에서는 4바이트(machine, JVM 둘중 하나라도 32비트라면)
    - 64비트 시스템인경우 8바이트(컴퓨터, JVM 모두 64비트 이어야 함)
- 레퍼런스 타입이 포인터이기 때문에 아래의 "Deep Copy Shallow Copy" 문제를 겪을 수 있다

<br> 
<br> 

# Deep Copy Shallow Copy 이슈
  - = 연산자는 얕은 복사를 수행
  - 참조형 클래스 사용 시 아래의 변수 할당 방식을 사용시 할당된 변수가 변경되는 원소스에 해당되는 변수도 같이 변형됨
  - 원소스에 해당되는 인스턴스와 별개로 할당 변수를 사용하기 위해서는 clone 내지 별개의 힙 메모리에 복사를 하여 사용하는 것이 안전
  - 사실, Array와 Class가 레퍼런스 타입이라 당연히 그래야하는거임.
    - 왜냐하면, 비용이 많이 소모되는(컴퓨팅시간과, 메모리 공간 측면) 대량의 메모리 할당, 생성 수정을 막기 위해서.
  
  ## Shallow Copy(얕은 복사)
  - 원본에서 수정이 발생되면 사본에서도 영향을 끼쳐 같아지게 되는 현상(배열, 혹은 객체)
    - 이유는 얕은 복사는 레퍼런스 타입의 주소만 가지고 있다 > 주소만을 복사하기 때문
    - 코더의 의도는 새로운 객체를 생성하기를 원하나, 실제 동작은 포인터 변수만 하나 추가된것
    - 복사된 배열이 원본 배열이 함께 변경되는 경우이며
    - 원인은 "= 연산자" 는 얕은 복사를 수행하기 때문 (아래 코드 참조)
  
    ```java
    int[] a = new int[2];
    a[0] = 1;
    a[1] = 2;
    int[] b = a;
    b[0] = 7;
    b[1] = 8;

    System.out.println("a:" + a[0]+", "+a[1]);
    System.out.println("b:" + b[0]+", "+b[1]);

    // 결과
    //a:7, 8
    //b:7, 8
    ```
  
  ## Deep copy(깊은 복사)
  - 새로운 메모리 공간을 만들고(할당받아) 원본 Value를 복사해오는 방식
  - 원본 배(or 객체)와 과 새로 생긴 사본 한쪽에서 일부 혹은 전부가 수정되더라도 다른쪽에 영향을 받지 않는 복사방식
  - 1차원 객체 배열
    ```java
    private static void ObjectArray() {
        Position[] pos = new Position[10];
        for (int i = 0; i < pos.length; i++) pos[i] = new Position(i, i);

        Position[] copy = deepCopy(pos);
        copy[0].a = 100;
        copy[0].b = 200;

        for (int i = 0; i < pos.length; i++) {
            System.out.print("(" + pos[i].a + ", " + pos[i].b + ")");
        }
        System.out.println();

        for (int i = 0; i < copy.length; i++) {
            System.out.print("(" + copy[i].a + ", " + copy[i].b + ")");
        }
    }

    private static Position[] deepCopy(Position[] original) {
        if (original == null) return null;
        Position[] result = new Position[original.length];
        for (int i = 0; i < result.length; i++) result[i] = new Position(original[i].a, original[i].b);

        return result;
    }

    // 결과
    (0, 0)(1, 1)(2, 2)(3, 3)(4, 4)(5, 5)(6, 6)(7, 7)(8, 8)(9, 9)
    (100, 200)(1, 1)(2, 2)(3, 3)(4, 4)(5, 5)(6, 6)(7, 7)(8, 8)(9, 9)
    ```
- System.arraycopy를 이용
    ```java
    private static int[][] deepCopyUseSystemArrayCopy(int[][] original) {
        if (original == null) return null;
        int[][] result = new int[original.length][original.length];
        for (int i = 0; i < result.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
    // 결과
    1 0 0 0 0 
    0 0 0 0 0 
    0 0 0 0 0 
    0 0 0 0 0 
    0 0 0 0 0 

    0 2 0 0 0 
    0 0 0 0 0 
    0 0 0 0 0 
    0 0 0 0 0 
    0 0 0 0 0
    ```
> 위 예제는 ""님의 블로그를 참고하였습니다
>> https://woovictory.github.io/2020/04/22/Java-Array-Copy/
<br> 
<br> 

# 래퍼 클래스 (Wrapper Class)
## 원시타입과 연결
- wrapper class는 각 primitive type을 클래스로 만든 것이다. 
-  stack 메모리에 저장됨

| 원시 타입 | 래퍼 클래스 |설명|
|------|------|------|
|int |Integer| 2의 보수로 메모리에 저장됨| 
|long|Long| 초기값0L, 2의 보수로 저장, 상수는 뒤에 꼭 L을 붙여야함|
|double|Double| 부동소수점 방식으로 메모리에 저장,화폐와 같이 정확한 값을 요하는곳에 double을 사용하면 안됨|
|char |Character| 16 비트 유니 코드 문자|
|boolean |Boolean|1bit의 정보를 표현, 사용하는 메모리 크기는 정확히 정해져 있지 않음 |

<br> 
<br> 


# 리터럴

- 리터럴은 실제로 저장되는 값 그 자체로 메모리에 저장되어있는 변하지 않는 값 
- 컴파일 타임에 프로그램 안에 정의되어 그 자체로 해석 되어야 하는 값
 - 그냥 코드 내에서 직접 쓴 값, 상수
 - 그 종류로는 정수, 실수, 문자, 부울(논리), 문자열 등이 있다. RO 인건가?
 - 예제 코드
```java

public class Exam_002 {
  public static void main(String[] args) {
    System.out.println("===== 정수 리터럴 =====");
    int int_v1 = 0b10; // 접두문자 0b -> 2진수
    int int_v2 = 010; // 접두문자 0 -> 8진수
    int int_v3 = 10; // 접두문자 없음 -> 10진수
    int int_v4 = 0x10; // 접두문자 0x -> 16진수
    long long_v1 = 10L; // 접미문자 l 또는 L -> long 타입 리터럴
    System.out.println("2진수 정수 리터럴 : " + int_v1);
    System.out.println("8진수 정수 리터럴 : " + int_v2);
    System.out.println("10진수 정수 리터럴 : " + int_v3);
    System.out.println("16진수 정수 리터럴 : " + int_v4);
    System.out.println("long 타입 정수 리터럴 : " + long_v1);
    System.out.println();
    System.out.println("===== 실수 리터럴 =====");
    // 실수 타입 리터럴은 double 타입으로 컴파일 되므로
    // float 타입인 경우 명시적으로 f 또는 F 를 명시해줘야 한다.
    // double 타입도 d나 D를 명시해줘도 되지만, 안해줘도 상관 없다.
    float float_v1 = 1.234F;
    double double_v1 = 1.234;
    double double_v2 = 1.234d;
    double double_v3 = 1234E-3d;
    System.out.println("float 타입 실수 리터럴 : " + float_v1);
    System.out.println("double 타입 실수 리터럴 1 : " + double_v1);
    System.out.println("double 타입 실수 리터럴 2 : " + double_v2);
    System.out.println("double 타입 실수 리터럴 3 : " + double v3);
  }
}
```

<br> 
<br> 

# 변수 선언 및 초기화하는 방법
- 자바에서 변수를 선언하는 방법은 아래 코드
  1. 변수의 타입(자료형) 다음에 변수의 이름을 작성한다
  2. 한 번에 여러개의 변수를 선언할수도 있다
  3. 대입 연산자 "=" 기호를 사용해 생성과 초기화를 동시에 할 수 있다.
    ```java
    public class Exam_003 {
      public static void main(String[] args) {
        int v1; // 1. 변수의 타입(자료형) 다음에 변수의 이름을 작성한다
        
        int v2, v3; // 2. 한 번에 여러개의 변수를 선언할수도 있다

        int v4 = 4; // 3. 대입 연산자 "=" 기호를 사용해 생성과 초기화를 동시에 할 수 있다.

      }
    }
    ```

<br> 
<br> 

# 변수의 스코프와 라이프타임

<br> 
<br> 

# 타입 변환, 캐스팅 그리고 타입 프로모션

- 리터럴은 다른 데이터 타입으로 변환할 수 있다.
  - ex) int 형 변수의 값을 long 변수에 담을수 있다.
```java
public class test {
  public static void main(String[] args) {
    int v1 = 10;
    long v2 = v1;
    System.out.println("v1 : " + v1);
    System.out.println("v2 : " + v2);
  }
}
//실행하면 둘다 100이 정상적으로 찍힘 
```
- 위 상황처럼 개발자가 따로 처리를 해주지 않아도 4바이트에 저장된 int 정수값이 8byte long 형 공간에 변환되서 들어가는데 이를 "묵시적 타입캐스팅" 이라고 부르는데요.
  - 타입변환 에서의 캐스팅과 프로모션에 대하여 알아보면 아래 두가지
  - Type Promotion (타입 프로모션) : 표현 범위를 모두 포함한 데이터 타입으로의 변환.
    - 작은자료형에서 큰자료형으로 변환
    - 프로모션이 승진(Promotion)의 의미로 사용
  - Type Casting (타입 캐스팅) : 표현 범위를 모두 포함하지 못한 데이터 타입으로의 변환. 
    - 큰 자료형에서 작은 자료형으로
    - long(10^9L) 데이터를  int형으로 보내는 경우다, 위의 예시와 반대
    - 데이터에 손실의 가능성이 있다.
  - 캐스팅이던 프로모션이던 객체사이의 변환이라면 무조건 부모자식 관계(서로 상속관계)이어야 한다

- 위 두가지 모두 Type Conversion (형 변환) 이라고 하는데, 이때 명시적이나, 묵시적이냐 두가지 경우로 나뉜다
  - Explicit type casting/promo (명시적)
    - 객체에서는 
      - 단. 좌항과 우항은 서로 상속관계에 있어야 한다. (명시적/ 묵시적)
      - 문제가 있는경우 런타임이 아닌 컴파일타임에 에러가 발생하게 된다(추가 조사 필요)
      - Java에서는 "instanceof" 키워드로 묵시적 형변환이 가능한지 확인이 가능하다
    - C++에서는 explicit 는 묵시적 형변환을 불가능하게 막고, 명시적인 형변환만 혀용하는 키워드

  - Implicit type casting/promo (묵시적/암시적)
    - 코드에 표기하지 않고 누군가가(컴파일러든 JVM이든/확인필요) 알아서 자동으로 형을 변환해주는경우
    - 에러가 발생하지는 않지만 큰
    - 여기서 버그가 발생하는 경우, 코드를 잘 읽어야 보이기 때문에(암시적으로 형변환이 되기 때문에) 버그 찾느라 고생할 수 있어서 조심해야 한다.
      - 대표적으로 overflow 에러나, 
      - 매우 큰 양수가 갑자기 음수로 변한다거나 반대의 경우도 발생
        - byte형에서 : -128 -1 = +127 << 와 같은 경우가 발생한다
      - 필자도 과거 기계적인 진동을 값으로 표현해서 저장하고/모터로 재현하는 일을 한적이 있는데, 이때 long 형과 double 형 사이의 묵시적인 형 변환 과정에서 데이터의 소실이 있어서 진동이 양자화된적이 있다. (그러니까 진폭에 Level이 생긴다랄까? 마치 수소원자 스펙트럼처럼)



<br> 
<br> 

# 1차 및 2차 배열 선언하기
- 배열 : 같은 자료형의 데이터가 연속적으로 배치
- 컴퓨터에서 가장 빠른 탐색이 배열의 인덱스 접근하는게 제일 빨라서 많이 쓴다.
- 주의할점은 인덱스는 0부터 시작하므로 arr[1] 은 두번째 원소이다. 첫번째 원소는 arr[0]
- Java에서는 특히 참조타입 변수로 배열에 접근한다 아래 코드를 참고하면
  ```java
  public class arrtest {
    public static int main(String[] args) {
      int arr1[] = new int[6];
      int arr2[] = new int[] {0,1,2,3,4,5};
      int arr3[]
    }
  }
  ```
  - 위 코드에서 선언한 arr1,arr2,arr3 변수는 JVM의 런타임 스텍 영역에 생성된다.
  - 그리고 배열은 레퍼런스 타입이기 떄문에 실제 < sizeof(int) * 6(원소갯수) > 만큼의 크기를 갖는 메모리 공간은 GC Heap 영역에 객체가 생성된다. 
  - 배열 변수는 "GC Heap 영역에 객체" 의 주소만을 가지고 있다!

<br> 
<br> 

# 타입 추론, var
- 타입 추론이란 : 란 값을 보고 컴파일러가 데이터 타입이 무엇인지 추론 한다
  - 타입 추론이 사용되는 예시를 살펴보면
    ```java
    public class inference {
      public static void main(String[] args) {
        HashMap<String, Integer> myhmap = new HashMap<>();
        //myhmap.add()...

      }
    } 
    ```
  - 위 코드에서 HashMap 객체를 할당할 때 new HashMap<String, Integer>() 를 써도 되지만
  - new HashMap<>() 으로 할당할수 있었는데 이를 다이아몬드 연산자 방식이라고 한다
    - myhmap 변수에 담길 데이터 타입이 HashMap<String, Integer> 라는 것을 알수있고, 정해져 있기에 가능하다.
  - 제네릭, 람다 등을 더 찾아보다(보충 필요)
- 자바에서 var 키워드는 Generic과 Lamda를 사용할때 타입추론을 하는데, 이는 코드 작성 당시 타입이 정해지지 않았지만, 컴파일러가 그 타입을 유추해서 알맞게 돌리는걸 의미한다.
- 자바 10버전 이상에서 추가되었다
   - javascript에서는 변수 선언시 var, let, const 키워드를 사용하는데 영향을 받은듯 하다(자료형이 자유라니..!?!)

자바에서처럼 int, long, boolean 등의 데이터 타입을 명시하지 않고 사용한다.
타입 추론에 대해선 대표적으로 제네릭

# 추가!
## C++과 자바간 차이
1. 언어의 지향점 : 언어별 탄생배경, 개발 목적이 다르기때문에 
   - 설계가 달라지고, 원리가 달라지고, 트레이트 오프에 차이가 생겼다(실행속도, 메모리공간, 개발속도, 확장유지보수성 등등 사이의 Trade-off)
   - C++
     - C언어 확장판이라 절차지향을 중심으로 개발됨
     - 객체지향은 C++이 지원하는 기능일뿐(근데 패러다임이 바뀌어야한다.)
   - Java
     - 태생부터 객체지향
     - 출발은 가전제품에 탑재되어 네트워크 컴퓨팅을 지원하기 위해서 만들었다
     - JVM 위에서 실행되기 때문에 안정성과 이식성이 있다.
2. Porting시 해야할일(플랫폼 이사갈떄)
   - C++ : 컴파일 + 코드변경
     - 콘솔에 Hello world 찍는 수준이 아니라면 코드변경이 필요한데, 개발시 얼마나 Porting 가능성을 염두했는지에 따라 1% ~ 70% 정도까지 코드 수정이 필요할 수 있다.(Linux-Windows 기준)
3. C++ VS 자바 간 큰틀에서 정리
      
    |요소|C++|Java|내생각|
    |---|---|---|---|
    |타언어|C와 하위호환|X|C14, C++17 이상버전부터는 다르다 <역1>|
    |System Call|직접 호출가능|자바 네이티브 인터페이스를 사용||
    |저수준 시스템 접근 가능|가능|JVM까지만 접근가능||
    |out of range|선택적으로 검사|항상 검사||
    |unsigned|지원함|지원안함||
    |Call-by-Value||||
    |Call-by-Reference||||
    |메모리 관리|프로그래머가 알아서, GC는 추가로 라이브러리|항상 GC 자동으로 알아서!||
    |자료형 재정의|명시적으로 재정의 가능|자료형 안정성 엄격, 굳이 쓰려면 새로운 Class필요||
    |기본 제공 라이브러리|STL|너무나 방대해..||
    |연산자 오버로딩|가능|연산자 재정의 불가능|Array * Array를 생각해보자, 행렬곱인지, 원소끼리 곱인지, 2차원 배열 2개를 조합해 3차원 배열을 만들껀지는 정의하기 나름 |
    |||||

  - <역1> C언어가 C++의 Subset이라고 하는건 10년전에는 맞았다. 하지만 2020년 기준에서는 다르다.
  - 야크쉐이빙 너무 심하게 해부려따.. 여기까지만

<br> 
<br> 

# 끝

<br> 
<br> 

# 