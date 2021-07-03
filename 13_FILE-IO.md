# 자바 13주차 I/O

- 참고 [https://github.com/kyu9/WS_study/blob/master/week13.md](https://github.com/kyu9/WS_study/blob/master/week13.md)

# 스트림

- 데이터를 전달하는 통로이며 물의 흐름(stream)에 비유
- FIFO(First In First Out) 에 단방향특성을 가짐
    - 입력과 출력(send, recv)구현시 두개를 묶음으로 사용해야한다
- 연속된 데이터의 흐름으로 입출력 진행시 다른 작업을 할 수 없는 블로킹(Blocking) 상태가 된다.
- 입출력 대상을 변경하기 편하며 동일한 프로그램 구조를 유지
    - 입출력 대상 변경 : 파일 / 소켓 / 하드웨어 <←- 스트림으로 읽

### 바이트 스트림(Byte Stream)

- 데이터를 Byte 단위로 주고 받는 것을 의미
- binary 데이터를 입출력하는 스트림
- 이미지, 동영상등 모든 종류의 데이터들을 송수신할 떄 주로 사용
- 대표적인 바이트 스트림에는 데이터 입력의 InputStream과 데이터 출력의 OutputStream이 있고 이 두 추상 클래스는 byte기반 stream의 최고 조상이다

### 문자 스트림 (Character Stream)

- 문자 단위로 인코딩 처리를 하는 스트림
- 텍스트 파일등을 송수신할 떄 주로 사용

# InputStream 과 OutputStream

### InputStream

- 바이트 기반 입력 스트림의 최상위 추상 클래스
- 모든 바이트 기반 입력 스트림은 이 클래스를 상속 받아서 만들어 진다.
- 버퍼, 파일, 네트워크 단에서 입력되는 데이터를 읽어오는 기능을 수행한다.

### OutputStream

- 바이트 기반 출력 스트림의 최상위 추상 클래스
- 모든 바이트 기반 출력 스트림은 이 클래스를 상속 받아서 만들어 진다.
- 버퍼, 파일, 네트워크 단으로 데이터를 내보내는 기능을 수행한다.

# 표준스트림

### **표준 스트림 = (System.in  +  System.out  +  System.err)**

- System 클래스는 실행시간 환경과 관련된 속성과 메소드를 가지고 있다.

System 클래스에서 제공되는 out과 in을 이용한 표준 입력, 출력, 에러 출력에 관한 클래스 변수, 외부적으로 정의된 프로퍼티 및 환경 변수의 접근, 파일 및 라이브러리의 로딩 방법, 객체를 복사해주는 메소드와 프로그램을 작성할 때 사용할 수 있는 유용한 메소드

### **System.in**

System.in 의 변수 타입이 InputStream 형태로 지정이 되어있다.

위에서 언급했지만 InputStream은 최상위 클래스이면서 추상 클래스이기 때문에 InputStream은 객체를 생성할 수 없는 클래스다

System.in 을 통해서 접근하는 객체는 JVM이 메모리로 올라오면서 미리 객체를 생성해 두는 대표적인 객체이다. 자료형이 InputStream이기 떄문에 바이트 단위로만 입출력된다.

키보드에서 입력하는 자료는 때에 따라서 두 바이트가 합쳐져야 의미를 가지는 경우가 있다. 그래서 System.in을 통해서 읽을 때는 영문과 한글의 처리를 분리해서 구성해야 잘 인식된다.

### **System.out**

가장 흔하게 System.out.println으로 사용하면서 본 함수이다

System.out 변수는 표준 출력 장치 객체를 가리키는 대표적인 출력 변수이다.

System.out은 PrintStream 타입으로 되어있는데 여기서 PrintStream이란 OutputStream 클래스의 후손 클래스로 Exception을 안전하게 처리할 메소드로만 구성이 되어있다. 그래서 굳이 try-catch 문 같이 따로 처리를 해주지 않아도 괜찮다

### **System.err**

System.err 객체는 표준 에러 출력 장치를 의미한다. 오류가 발생하게 되면 System.err로 알려줘야 하는 내용이 나온다고 생각하면 된다.

System.err 는 PrintStream 클래스 타입으로 System.out을 사용하는 방법과 같다.

# 체널

- 데이터가 통과하는 쌍방향 통로
    - 체널 내부에서 데이터를 주고 받을때 사용되는게 버퍼
- 자바 NIO(New I/O)는 자바 1.4 버전부터 추가된 API
- 넌블로킹(Non-blocking) / 스트림이 아닌 채널(Channel) 사용
- 채널에서 데이터를 주고 받을 때 사용 되는 것이 버퍼

    ![%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2013%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20I%20O%2008eb50cd54f44391822d59988753a436/_2021-04-17__12.21.05.png](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%2013%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20I%20O%2008eb50cd54f44391822d59988753a436/_2021-04-17__12.21.05.png)

# 버퍼

- 고속의 장치와 저속의 장치 간의 속도 차이로 인해 발생하는 비효율성 제거를 위한 "데이터를 임시 저장공간"
- 저속의 장치가 작업 진행시간 동안 고속의 장치가 기다려야하는 현상을 줄여주는 기술
- byte, char, int 로 대표되는 premitive type (기본 데이터 타입)을 저장할 수 있는 임시 저장소로서
- 배열과 마찬가지로 제한된 크기(capacity) 에 순서대로 데이터를 저장
- 실제로 버퍼가 사용되는 것는 채널을 통해서 데이터를 주고 받을 때 사용
- **채널을 통해서 소켓, 파일 등에 데이터를 전송할 때나 읽어올 때 버퍼를 사용하게 됨으로써 가비지량을 최소화 시킬 수 있게 되며, 이는 가바지 콜렉션 회수를 줄임으로써 서버의 전체 처리량을 증가시켜준다.**

### 버퍼를 사용해

- 운영체제의 API 호출 횟수를 줄여서 입출력 성능을 개선할 수 있다.
- 자바 문자열 입력시 (알고리즘 문제) 풀때
    - 입력 : Scanner 보다는 >> BufferedReader방식이 빠르고
    - 출력 : System.out.println 보다 >> BufferedWrite 방식이 시간을 줄일수 있다

### 버퍼 사용법

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// BufferedReader를 사용하기 위해서는 throws IOException을 해 주어야 함.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

		int N = Integer.parseInt(br.readLine()); // readLine으로 받은 입력 데이터 String임.
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
	}

}
```

```java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// BufferedWriter를 사용하기 위해서는 throws IOException을 해 주어야 함.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언
		bw.write("Hello World");
		bw.flush(); // write로 담은 내용 출력 후, 버퍼를 비움.
		bw.close(); 
	}

}
```