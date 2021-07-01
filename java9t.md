# 9주차 자바의 예외 처리
- 학습할 내용
```
자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
자바가 제공하는 예외 계층 구조
Exception과 Error의 차이는?
RuntimeException과 RE가 아닌 것의 차이는?
커스텀한 예외 만드는 방법
```

# 1) 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)

### try-catch 문
- 설명을 위한 예제코드
```java
try {
    // 예외가 발생할 가능성이 있는 코드
} catch (Exception1 e1) {
    // Exception1이 발생했을 때, 이를 처리하기 위한 코드
} catch (Exception2 e2) {
    // Exception2가 발생했을 때, 이를 처리하기 위한 코드
} catch (ExceptionN eN) {
    // ExceptionN이 발생했을 때, 이를 처리하기 위한 코드
}
```
- try블럭에는 여러개의 catch 블록이 올 수 있다
- 이 중에서 발생한 예외의 종류와 일치하는 단 한개의 블록만 수행됩니다




# 2) 자바가 제공하는 예외 계층 구조
# 3) Exception과 Error의 차이는?
# 4) RuntimeException과 RE가 아닌 것의 차이는?
# 5) 커스텀한 예외 만드는 방법