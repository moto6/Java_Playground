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
- 설명을 위한 예제코드
```java
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 100;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() throws Exception{
	// The FileWriter constructor throws IOException, which must be caught.
    
        PrintWriter fileHandler = new PrintWriter(new FileWriter("output.txt"));
    
        for (int i = 0; i < SIZE; i++) {
            // The get(int) method throws IndexOutOfBoundsException, which must be caught.
            fileHandler.println("Value at: " + i + " = " + list.get(i));
        }
        fileHandler.close();
    }

    public static void main(String[] args) throws Exception{
        ListOfNumbers lom = new ListOfNumbers();
        lom.writeList();
    }
}
```
- PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

이 부분에서 OutFile.txt 파일을 성공적으로 열지 못한다면 IOException이 발생할 것입니다.

그리고 두번째 부분은 ArrayList에서 get Method를 통해 값을 가지고 오려고 할 때 해당 인덱스 값이 없다면 IndexOutOfBoundsException이 발생할 수 있습니다.


# 2) 자바가 제공하는 예외 계층 구조
# 3) Exception과 Error의 차이는?
# 4) RuntimeException과 RE가 아닌 것의 차이는?
# 5) 커스텀한 예외 만드는 방법