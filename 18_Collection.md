# Java Collection Interface 정리

## Java Collection Interface소개
- Java Collection이란 자바에서 제공하는 일종의 interface 입니다 그런데 아래 몇가지를 곁들인
  - collection hierarchy : 컬렉션 인터페이스를 상속(extends)받은 interface들이 있는데, 인자 하나짜리 인터페이스들의 root interface들이 바로 Collection입니다
    - Map은 인자가 2개라 Collection을 상속받은 인터페이스는 아니지만 컬렉션이라 불립니다.
  - represents a group of elements : 다수의 객체를 다루기 위해 만들어진 인터페이스
  - "다수의 데이터"를 "집합" 혹은 "그룹" 이라고 표현하는데 아무튼 여러개 원소들을 자바 언어에서 쉽게 편하게 다루기 위해 존재합니다.
    - 왜 편하냐면, Java에서 미리 만들어놓은 100% 검증된 큐, 스텍, 리스트 등의 자료구조를 그냥 가져다 쓰면 되는거라 개발자들이 매번 큐,스텍,리스트를 구현하지 않아도 쓸수 있습니다

### Collection Interface의 메서드
- Collection Interface 를 implements하기 위해서 최소한 구현해야 할 메서드들의 리스트 (from OpenJDK11)
  - ``int size()`` 
  - ``boolean isEmpty()``
  - ``Iterator<E> iterator()``
  - ``<T> T[] toArray(T[] a)`` : 제네릭이 궁금하다면? [Link]()
  - ``boolean remove(Object o)``
  - ``boolean addAll(Collection<? extends E> c)``
  - ``boolean removeAll(Collection<?> c)``
  - ``void clear()``
  - ``default Stream<E> stream()`` : 여기서 바로 Stream이 나옵니다!

### Collection Interface의 계층구조
- Super-interfaces : Iterable\<E>
- Sub-interfaces:
  - BeanContext, BeanContextServices, 
  - Deque\<E>, Queue\<E>
  - List\<E>, 
  - Set\<E>, SortedSet\<E>,
- 이외
  - Map : 입력파라미터 갯수가 두개라서 Collection을 상속받지는 못하지만 일반적으로 컬렉션 범주에 포함시킵니다
- ![상속구조](https://user-images.githubusercontent.com/31065684/126153023-a2d2da7c-89e2-41f6-a3cd-35011b72c3cc.png)


### Collection Interface 도대체 왜 편하다는걸까?
- Collection Interface가 편하다 편하다라고 하는데 왜 편한지 비전공자가 나름 추측을 해보면
- 컴공 1학년때 C언어를 배우고 >> 2학년때 자료구조를 배우는데, c언어는 언어 자체만으로 List, Set, Map, Tree 자료구조는 제공해주지 않으므로 한학기동안 열심히 구현하면서 자료구조를 배우고 하게 되는데
- 자바는 Collections Framework를 통해서 **``List, Set, Map, Tree 자료구조는 제공해주니까 "너희들이 자료구조를 직접 만들지 않아도 쓸수 있다" 라는 편리함``** 이라고 해서 >> "Collection Interface는 편하다" 라는 말을 하는게 아닐까??
  - 이상 비전공자의 뇌피셜이였습니다..

<br><hr><br>

## Java Collections Framework(이하 JCF)  
- Java Collections Framework는 데이터들을 저장하고 관리하는 자료구조를 제공하는데
  - 이미 구현이 끝나서 바로 사용할수 있는 "완성된 클래스"를 제공 : 대표적으로 ArrayList, HashMap, HashSet 등등..
  - 이미 만들어진 자료구조에서 마음대로 추가해서 쓸 수 있도록 "정의된 인터페이스"도 제공 : List, Map, Set...
    - 그러니까 인터페이스만 제공해주고 개발자들이 입맛에 맞게 구현해서 사용할 수 있도록 틀을 제공
    - This interface is typically used to pass collections around and manipulate them where maximum generality is desired : 이 인터페이스는 일반적으로 컬렉션을 전달하고 최대한의 일반성이 필요한 곳에서 컬렉션을 조작하는 데 사용
- 정의된 인터페이스를 제공하는 이유 
  - 당장 JCF 가 제공하는 List가 두개인데 : ArrayList, 그리고 LinkedList 두가지가 존재한다, 어떻게 구현하느냐에 따라 인터페이스(API)는 같아도 동작, 성능특성은 모두 다르다!
    - ArrayList : 편하게 쓰는 배열 : 삽입이 O(n)이지만 탐색과 접근은 O(1)
    - LinkedList : 링크드 리스트 : 삽입은 O(1)이지만 탐색과 접근은 O(n)
- 아래 표는 대표적인 컬렉션 프레임워크 주요 인터페이스

| 인터페이스 | 설명                                                         | 구현된 클래스들           |      |
| ---------- | ------------------------------------------------------------ | ------------------------- | ---- |
| Set\<E>     | 순서가 없는 데이터의 집합. 중복을 허용하지 않음              | HashSet, TreeSet              |      |
| List\<E>    | 순서가 있는 데이터의 나열, 중복허용                       | LinkedList, Vector, ArrayList |      |
| Queue\<E>   | 순서가 있는 데이터의 나열, 중복허용, FIFO                 | LinkedList, PriorityQueue     |      |
| Stack\<E>   | 순서가 있는 데이터의 나열, 중복허용, FILO                 | Stack                         |      |
| Map\<K,V>   | 키(Key), 값(Value)의 쌍으로 이루어진 데이터으 집합, 순서는 없음, 키(Key)의 중복을 허용하지 않으나 값(Value)의 중복은 허용 | HashMap, TreeMap, Hashtable, Properties   |      |

## JCF Set
## JCF List
## JCF Map

# 추가해야할 부분

<br><hr><br>

## 간단하게 자바로 자료구조 구현하기
### MySet 구현하기
### MyList 구현하기
### MyMap 구현하기

# 구현하면서 공부해야할 부분

<br><hr><br>

## TMI자료구조 리마인드

### 자료구조(data structure)란 데이터의 효율적인 접근&수정(Read&Write) 하는 자료의 조직, 관리, 저장하는 방법
  - 정확히 말해, 자료 구조는 데이터 값의 모임, 또 데이터 간의 관계, 그리고 데이터에 적용할 수 있는 함수나 명령을 의미
  - 상황에 알맞게 적절하게 선택한 자료구조는 컴퓨터가 효율적으로 동작해 성능이 개선되는데 
    - 실행시간 혹은 메모리 용량과 같은 자원을 최소한으로 사용하면서 연산을 수행하도록 해준다.
    - 또한 보다 더 효율적인 알고리즘을 사용할수 있다(정렬이 되어있는 리스트라면 이진탐색이 가능하다거나)
  - 자료구조의 선택문제는 대개 추상 자료형의 선택으로부터 시작하는 경우가 많다

### 자료구조별 특징
- 여러 종류의 자료구조는 각자의 장단점과 특장이 있어서 목적과 상황에 따라 최적의 자료구조는 선택해 사용
  - B-트리 : 데이터베이스에 효율적이며(클러스터링 인덱스 구조, B+트리, 바이너리 트리 아님)
  - 라우팅 테이블 : 네트워크(인터넷, 인트라넷)에 효율적인 자료구조 
    - 라우터의 자료구조는 "라우팅 테이블" 이라는 자료구조이다..
  - HashTable 자료구조 : DB에 소금뿌릴때 사용..
  - List : 삽입은 O(1)이지만 탐색과 접근은 O(n)
  - Array : 삽입이 O(n)이지만 탐색과 접근은 O(1)
  - Heap : 완전이진트리,부모노드가 배열의n번 인덱스라면, 왼쪽자식은 2n, 오른쪽자식은 2n+1이 보장되는 자료구조, 배열에 맵핑된 트리
  - tree : 비선형 자료구조로.... 이걸 다 쓰면 너무 멀리가버려서 이후로는 skip

###  프로그램을 설계할 때, 어떠한 자료구조를 선택할지는 가장 우선적으로 고려해야할 대상
  - 구현의 난이도나 최종 결과물의 성능이 자료구조에 크게 의존
  - 자료구조가 선택되면 적용할 알고리즘은 상대적으로 명확해짐, 알고리즘은 자료구조에 의존적
  - 알고리즘이 필요해서 자료구조가 강제되는 경우도 있는데 
    - 목표로 하는 연산이 특정한 알고리즘을 반드시 필요로 하며, 해당 알고리즘은 특정 자료구조에서 가장 나은 성능을 발휘할 때와 같은 경우 한정
- 대부분의 언어에서 검증된 자료구조체의 구현은 감춘 채 인터페이스만을 이용하여 다양한 프로그램에서 사용
  - C++, 자바와 같은 객체지향 프로그래밍 언어는 특별히
  - 최근의 프로그래밍 언어 및 개발 환경은 다양한 표준 라이브러리를 제공
    - C++의 STL(표준 템플릿 라이브러)
    - Java의 Collections API
    - C# .NET / Base Class Library


<br><hr><br>

## TIM 모 전자회사 썰
- 취준생들이(과거의 나도..) 선망하는 모 전자회사는 S직군 책임연구원>수석연구원 승진하기 위해서 필요한 "SW역량테스트 C등급"이 필요했는데
- 이 SW역량테스트 C등급 시험에서 뭘 보냐면 백지상태 코드에서 큐, 트리, 스텍 같은 자료구조를 구현하는걸 본다, 이걸 4시간동안 인터넷 차단하고 온전히 머리속에서 쥐어짜내서 코딩해야 하는거고, 시험준비는 위 자료구조들을 여러번 반복적으로 구현하는걸 연습하고, 시험장에서 똑같이 쏟아내고 오면 된다. 
- 자바나 파이썬은 이런 기본적인 자료구조를 언어차원에서 바로지원 하므로 아예 사용이 불가능하고 C/C++ 로 짜야한다.. (Visual Studio 사용)
- 예전생각에는 " 아 그만큼 기초가 중요하다는거구나 역시 멋져..!" 이런생각을 좀 했었는데, 이제 더이상 그렇게 생각하지는 않는다.
- 뭐랄까 방향이 정 반대랄까.. 테크리더라면 자료구조 하나하나를 어떻게 구현해야되는지 머리속에 담아두는게 중요한게 아니라 기술적으로 가능하고 불가능한 부분을 나누고 앞으로 나갈 방향을 정해야 한다고 생각한다. 근데 뭐 또 생각해보면 지금 뭘로 돈벌어먹고 사는 회사인지 생각해보면 오히려 자료구조 구현하는게 더 합리적일 수도 있고..??
- 물론 2019년 즈음 그땐 그랫다는거지 더이상 아닐수도 있다. 그냥 Latte is Horse 썰