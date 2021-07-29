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


## 공통
- Collection은 Iterable 인터페이스를 확장했는데, 이는 Iterator 인터페이스를 사용해 데이터를 순차적으로 가져올 수 있게 된다.
- 왠만하면 한 가지 종류의 객체만 저장하자. .여러 객체는 DTO 객체를 만들어 담자.
- 그래서 컬렉션 관련 클래스 객체 선언은 제네릭을 이용하자.
- 저장되는 초기 크기는 기본이 10이라 데이터가 더들어가면 크기가 자동 증가는 되지만 성능상 크기가 어느정도 예측가능하면 아싸리 크게 잡는걸 권장
- Collection을 매개 변수로 갖는 생성자가 존재한다. 셋과 큐 등을 복사하기 위함.
  - list2.add(list); 처럼 list2에 list를 추가하며 복사해도 된다.
  - 근데 다음 생성자를 통해 사용하면 편하다. ArrayList list2 = ArrayList<>(list);
  - list2 = list; 처럼 치환해버리면 list 객체가 참조되고 있는 주소를 사용하겠다는 의미다.
- 하나의 Collection 관련 객체를 복사할 땐 생성자나, addAll()을 사용하는걸 권장한다.
- 데이터를 배열로 뽑아 낼 땐 toArray()를 사용한다.
  - toArray() : ArrayList객체에 있는 값을 Object[] 타입의 배열로 만든다.
  - toArray(T[] a) : ArrayList 객체에 있는 값들을 매개변수 T 타입의 배열로 만든다. 위보다 이렇게 쓰는걸 더 추천한다.
    - 매개변수로 배열의 타입을 넘기는데, toArray(new String[0]); 처럼 의미 없이 타입만 지정하기위해 사용할 수도 있다.
    - 크기가 0인 배열을 넘겨주는 것이 가장 좋다.
- remove()는 매겨변수로 넘어온 객체와 동일한 첫 번쨰 데이터만 삭제하고, removeAll()은 매개변수로 넘어온 컬렉션에 있는 데이터와 동일한 모든 데이터를 삭제한다.
- 값을 변경하는 set() 메서드가 있는데 이거 모르면 특정 위치 삭제하고 그 위치에 add해야 한다...set(int index, E element);
- treimToSize()는 ArrayList 객체 공간의 크기를 데이터 개수만큼 변경한다.
- 빈컬렉션
  - Collections 클래스의 emptyList(), emptySet, emptyMap() 등의 빈 컬렉션을 취득할 수 있다.
  - 싱글톤 컬렉션 인스턴스를 반환해서 빈 컬력션을 반환하는 경우 스스로 생성한 컬렉션을 반환하는것 보다 메모리나 인스턴스 생성 비용을 줄일 수있다.

- removeIf()
  - 람다식에서 지정한 조건에 일치하는 요소를 삭제할 수 있다.
  - list.removeIf(s -> s.startWith("J"));
- 정렬
  - Collection.sort()를 이용
### stack
- Stack은 Vector를 확장해 만들었다.
- Vector보단 ArrayList를 많이 사용한다.
- Stack
  - 웹 개발엔 잘 사용 안한다.
  - 마지막에 들어온 데이터를 가장 처음 꺼내는 기능 구현할 때 필요하다.
    - 이기능을 위해선 ArrayDeque 클래스를 사용할 것을 권장한다. (쓰레드에 안전하진 않음). 쓰레드에 안전하려면 Stack써.
  - Stack은 Vector를 상속받고 있는데, 원래 취지인 LIFO를 생각하면 잘 못받은 클래스다. (하위호환위해 남아있음).


## JCF List


### List Interface

### ArrayList Class
- 배열은 크기가 정해져 있을 때 유용하다.
- Vector와 ArrayList는 기능이 거의 동일한데, Vector는 Thread Safe 하고, ArrayList는 그러지 않다.
- ArrayList는 중복이 가능해서 앞에서부터 찾을땐 indexOf()를 뒤에서 부터 찾을 땐 lastIndexOf()를 사용한다.
- ArrayList는 쓰레드에 안전하지 않으므로 안전하게 만들려면 다음과 같이 한다.
  - List list = Collections.synchronizedList(new ArrayList(...));
  - 이렇게 안하면 원하지 않은 데이터가 나올 수 있다.

### LinkedList Class
- LinkedList는 List에도 속하지만 큐에도 속한다.

## JCF Set

### Set Interface

- 순서에 상관 없이 어떤 데이터가 존재하는 지 확인 하는 용도로 사용한다. 중복 방지
- HashSet : 순서가 필요 없는 데이터를 해시 테이블에 저장. Set중 성능이 가장 좋음
  - 데이터가 같은지 확인하는 작업이 핵심이다. equals(), hashCode()를 구현한느건 중요하다.
  - 생성자 인자에 로드팩터가 나오는데, 로드팩터 = 데이터의 개수/저장공간 을 의미한다.
  - 로드팩터가 클수록 공간은 넉넉햊지만, 데이터 찾는 시간은 증가한다.
  - 출력방법은 for문과, iterator를 사용하는 방법이 있다.
- TreeSet : 저장된 데이터의 값에 따라 정렬되는 셋. red-black이라는 트리 타입으로 값이 저정된다.(이진트리))
- LinkedHashSet : 연결된 목록 타입으로 구현된 해시 테이블에 데이터 저장. 저장 된 순서에 따라 값이 정렬.
## JCF Map


### Queue

- 사용자들의 요청을 들어온 순서대로 처리할 떄 큐를 사용한다.

### LinkedList

- List도 되고, Queue, Deque도 된다.
  - List, Queeue, Deque 인터페이스를 구현하고 있다.
- 생성자로 객체의 생성크기를 지정하지 않는다.
- push()는 앞쪽에 데이터 추가.
- add(), offer()는 뒤쪽에 데이터 추가.
- set() 데이터 수정
- 같은기능 하는 함수가 있으니 남들이 볼때 혼동안되게 한가지만 사용하자.
- 조회 함수는 기본이 아페껄 가져온다. getFirst()권장.
- 삭제의 경우 여러 함수가 있는데, 혼동을 피하려면 remove 붙은 함수를 사용하자.
- ListIterator가 있는데, Iterator의 다음 데이터만 검색하는 단점을 보완 햇다.
  - descendingIteratort()도 있다. 뒤에서부터 검색.

### Map

- 키와 값이 1:1로 매칭된다. 키는 중복 안된다.
- keySet() : 키 목록을 Set타입으로 리턴
- values() : 값 목록을 Collection 타입으로 리턴.
- entrySet() : Map 안에 Entry라는 타입의 Set을 리턴. Entry엔 단 하나의 키와 값만 저장된다.
- Hashtable(JDK1.0 부터 나옴)
  - Map 인터페이스를 구현했긴 했다.
  - Map은 컬렉션 뷰를 이용하고, Hashtable은 Enumeration 객체를 통해 데이터 처리한다.
  - Map은 이터레이션을 처리하는 도중 데이터를 삭제하는 안전한 방법을 제공하지만 Hashtable은 그렇지 못하다.
  - HashMap은 키나 값에 null 저장 가능하지만 해시테이블은 그렇지 못하다.
  - HashMap은 여러 쓰레드에 안전하지 않고, 해시테이블은 안전하다.
- 해시 테이블을 제외한 Map으로 끝나는 클래스들은 여러 쓰레드 동시접근에 안전 하지 않다.
  - Map map = Collections.synchronizedMap(new HashMap(...)); 이렇게 쓰자
  - 이름에 Concurrent가 포함되잇는 것도 스레드에 안전하게 사용할 수 있다. ex) ConcurrentHashMap...
- HashMap
  - 생성자는 기본으로 쓰는게 좋지만, 담을 데이터가 많다면 초기 크기를 지정해 줄것을 권장한다.
  - 키는 기본형과 참조 자료형 모두 가능하다.
  - 키가 되는 객체 클래스를 직접 만들어 작성할 떈 개발툴에서 제공하는 hashCode(), equals()를 생성하자. p.641 다시 보기
  - get()으로 키가 없는 걸 불러오면 null을 리턴한다.(Collection 에서는 익셉션 발생 했엇음)
  - 추가 수정 모두 put()을 사용
  - 맵에 키를 확인하려면 keySet()을 이용한다. get()을 사용하려면 키를 알아야 해서.
  - 값을 받아올떄는 values()만 쓰면 된다. 리턴타입이 Collection 타입의 목록이다.
  - 데이터를 꺼내는 다른 방법으로 entrySet() 메서드가 있다.
    - Map에 선언된 Entry 타입 객체를 리턴한다. Entry에는 단 하나의 키와 값만 저장된다. Enrty의 getKey() getValue()로 꺼내오면 된다.
  - 무작정 get()으로 키나 값이 있는지 확인하는 거보단, containsKey(), containsValue()를 사용하는게 좋다.
- TreeMap(정렬된 키의 목록))
  - 키를 정렬하려면 HashMap은 여러 과정이 필요하다.
  - Arrays 클래스를 사용해도 되는데 불필요한 객체가 생기는 단점이 있따.
  - 정렬된 목록을 원할 떄 TreeMap 사용한다.
- Prperties 클래스
  - System 클래스에 Properties 라는 클래스가 있고 이는 Hashtable을 확장함
  - Hashtable, HashMap 대신 쓰는 이유는 load(), store() 등의 함수 때문이다.
  - 데이터 저장과 읽기를 한줄로 할 수 있다.




<br><hr><br>

# 추가해야할 부분

## JPA에서 One-Many or Many-Many 관계일때 Set? List
- 제 결론은 Set 쓰는걸 추천하고, List가 꼭 필요한 상황일때만 List(+중복을 허용해야 하는경우)

### 봐도 모르겠음
- 하이버네이트 공식독스 : https://docs.jboss.org/hibernate/orm/4.1/manual/en-US/html/ch20.html#performance-collections-mostefficientupdate
- http://assarconsulting.blogspot.com/2009/08/why-hibernate-does-delete-all-then-re.html
- https://joont92.github.io/jpa/%EC%BB%AC%EB%A0%89%EC%85%98%EA%B3%BC-%EB%B6%80%EA%B0%80%EA%B8%B0%EB%8A%A5/
- 자바 컬렉션과 JPA 관계에 대해서 공부가 추가적으로 필요하다..
모른다는건 확실히 배워가는점..!!
- JPA - ManyToMany 관계시 Set과 List의 차이 -

<br><hr><br>

## TMI자료구조 리마인드

### 자료구조(data structure) : DATA(자료)를 접근&수정(Read&Write)효율적으로 처리하기 위해서 고민해서 나온 결과물들을 배우는 시간
- 구체적으로, 어떤 구조로 데이터들을 다뤄야 효율적인지 고민한 선배님들의 결론을 배우는 과목
  - 배우는 내용은, 자료 구조는 데이터 값의 모임, 또 데이터 간의 관계, 그리고 데이터에 적용할 수 있는 함수나 명령을 의미
    - 상황에 알맞게 적절하게 선택한 자료구조는 컴퓨터가 효율적으로 동작해 성능이 개선됨!
    - 실행시간 혹은 메모리 용량과 같은 자원을 최소한으로 사용하면서 연산을 수행하도록 해줌
    - 또한 보다 더 효율적인 알고리즘을 사용할수 있다(정렬이 되어있는 리스트라면 이진탐색이 가능하다거나)
  - 자료구조의 선택문제는 대개 추상 자료형의 선택으로부터 시작하는 경우가 많다
- 기존의 자료구조보다 훨씬 우월하게 

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




## 간단하게 자바로 자료구조 구현하기
### MySet 구현하기
### MyList 구현하기
### MyMap 구현하기

# 구현하면서 공부해야할 부분 >> 이거 따로 빼자