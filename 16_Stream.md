

# **자바 Java Stream 인터페이스**

### **자바 Java Stream 인터페이스**

`스트림stream`은 자바 8 API에 새로 추가한 기능이다. 스트림을 이용해서 선언형으로 콜렉션 데이터를 처리하도록 구현할 수 있다.

### **filter**

요구사항은 파일 문자 중 길이가 12보다 큰 문자의 수를 구한다.

```java
// next.fp.StreamStudy countWords method

String contents = new String(Files.readAllBytes(
  Paths.get("../ war-and-peace.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 0;
for (String w : words) {
  if (w.length() > 12) count++;  
}
코드복사
```

---

### **filter 활용해 구현**

```java
String contents = new String(Files.readAllBytes(
  Paths.get("../alice.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 
  words.stream().filter(w -> w.length() > 12).count();
코드복사
```

---

### **map**

List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.

```java
// next.fp.StreamStudy 클래스의 doubleNumbers method 참고
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> dobuleNumbers =
  numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
코드복사
```

---

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

[목차로]()

---

---
