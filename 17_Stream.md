# **``Java Stream API``** 학습내용 정리

<br><hr><br>

## Java Stream 은 뭘까?
- **``Stream은 operations(연산) 입니다!!``** 근데 단순한 연산은 아니고 
  - 이런 연산들을 할수있어요 : sequential(순차 연산), parallel(병렬 연산), aggregate(집계 연산) 
  - elements(원소)들을 sequence(순차적)하게 연산해줘요
  - 원문 : A sequence of elements supporting sequential and parallel aggregate operations
  - 제가 들은 백기선님의 [The Java8 강의]()에서는 스트림을 "컨베이어 벨트" 메타포로 설명해주셨습니다. StreamAPI는 컨베이어벨트처럼 동작합니다 
    - 컨베이어 벨트를 [시각적으로 느껴보고 오기 위한 링크](https://youtu.be/5AJzx-6sQ5M?t=76) : 심지어 영상도 EBS Collection에서 제작했는데요, 이 영상은 Java 개발자들에게 Stream이라는 컨베이어 벨트는 Collection에서만 사용 가능하다는걸 알려주고자하는 의지가 아니였...?..다고 합니다
- 데이터를 담고 있는 저장소 (List나 Set같은 컬렉션)이 아니고 저장소도 아닙니다!
  - **``Stream은 operations 입니다!!``** (중요해서 한번더 강조)
- 선언형으로 컬렉션(프레임워크) 데이터를 처리할수 있는 자바가 기본 지원하는 API(Java 8 이후 사용)
- Java의 Collection이 가지고 있는 메소드들 중 관련있는 메서드들은
  - stream() / parallelStream()
  - removeIf(Predicate)
  - spliterator()

### Stream 예제
- Stream을 사용한 예제를 먼저 살펴보면서 도대체 이게 왜 필요한지 생각해보겠습니다
```java
Collection<Widget> wiget = new ArrayList<>();
// 여기서 Collection은 좀더 구체적으로 set이나 list가 될 수 있습니다
```
- 위와같은 Widget 클래스의 Collection 에서  Widget의 Color가 RED인 요소들의 Weight 합계를 구하는 작업을 수행해야 할때 아래와 같은 스트림으로 처리할수 있습니다.
```java
int sum = widgets.stream()
    .filter(w -> w.getColor() == RED)
    .mapToInt(w -> w.getWeight())
    .sum(); 
```
- stream을 사용하지 않고 for문을 사용한다면 아래와 같습니다.
```java
int sum = 0;
for(Widget w : wiget) {
  if(w.getColor() == RED) {
    sum += w.getWeight();
  }
}
```
- forLoop를 통한 방식 vs Stream + Lambda 를 이용한 코드 사이에 결과는 같지만 몇가지 차이가 있는데요
  - 차이를 알아보기 위해서는 Java Stream의 특징을 알아야합니다

### Java Stream의 특징

- Funtional in nature : 스트림이 처리하는 데이터 소스를 변경하지 않음, 원본데이터는 그대로 두고 복사본을 만들어 작업합니다
- 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
- 스트림으로 들어오는 데이터의 길이(컬렉션의 원소 갯수)는 제한이 없습니다. 무한히 긴것도 처리 가능!
  - 단 limit() 와 같은 Short Circuit 메소드를 사용해서 길이제한도 가능
- 중개 오퍼레이션은 근본적으로 lazy 하다.
- parallelStream : 병렬 처리(멀티쓰레드)를 쉽게 사용할수 있다! (parallelStream 메서드 사용)
  - Lambda Expression과 Stream을 같이 쓰면 환상의 콤비
- Stream Pipeline
  - 저는 처음 학습할 때 Stream pipeline과 Steam API와 혼동했던적이 있었습니다. 이 글을 읽으시는 분들은 Stream 에서 pipeline과 API는 서로 다르다는 점을 기억해주세요!

<br><hr><br>

## Stream-Pipeline이란? 
- 파이프라인이란, 여러개의 Stream Operations들이 다단계로 연결되어 있는 구조를 의미합니다
  - ![파이프라인](https://user-images.githubusercontent.com/31065684/126059897-8baefc75-0ce7-4676-9779-5d9f44949d86.png)
- 파이프라인의 구성은 두가지
  - 중개 오퍼레이션 (intermediate operation)
    - 입력도 출력도 모두 Stream type 인 오퍼레이션
    - 여러개가 무한히 붙을수도 있고, 없을수도 있음
    - `Stateless` / `Stateful` 오퍼레이션으로 나눠짐
      - `Stateless` 오퍼레이션 : filter, map, limit, skip 등등.. 대부분의 API가 Stateless 임
      - `Stateful` 오퍼레이션 : distinct나 sorted 처럼 이전 이전 소스 데이터를 참조하는 경우 드물게
  - 종료 오퍼레이션 (terminal operation)
    - Stream을 리턴하지 않는 오퍼레이션
    - 맨 뒤에 종료오퍼레이션 하나 붙여서 Stream을 종료하는 역할
      - collect, allMatch, count, forEach, min, max, ...
    - 데이터 소스는 오직 터미널 오퍼네이션을 실행할 때에만 처리한다()....?? 레이지로딩인가??)


<br><hr><br>

## Stream API 사용예시
- Stream 중 많이쓰는 중요한 API 예제코드와 함께 설명
  - filter 
  - map
  - reduce

### **filter** : 말그대로 필터

- 요구사항 : 파일 문자 중 길이가 12보다 큰 문자의 수
- steam 안쓰고 구현
```java
// next.fp.StreamStudy countWords method

String contents = new String(Files.readAllBytes(
  Paths.get("../ war-and-peace.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 0;
for (String w : words) {
  if (w.length() > 12) count++;  
}

```

- **filter 활용해 구현**

```java
String contents = new String(Files.readAllBytes(
  Paths.get("../alice.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 
  words.stream().filter(w -> w.length() > 12).count();
```


### **map** : 맵...

List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.

```java
// next.fp.StreamStudy 클래스의 doubleNumbers method 참고
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> dobuleNumbers =
  numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
코드복사
```

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

<br><hr><br>


### 참고

https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html
https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html
https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html



