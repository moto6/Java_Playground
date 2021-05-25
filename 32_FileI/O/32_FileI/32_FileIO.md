# 스트림 : 연속적인 데이터의 흐름(자바에서만 쓰는)
  - 읽어들이기 >> 자바속으로 : 인풋 스트림
  - 자바에서 >> 밖으로 출력 : 아웃풋 스트림

# 처리 데이터 : byte / char 
- byte와 char 두 종류뿐
- 텍스트 위주의 데이터 입출력시 char로 처리하며
-  텍스트가 아닌 이미지, 동영상 등의 파일들은 다 byte로
-  한글은? 
### 처리 구현
- byte로 처리하는 클래스의 최상위 클래스는 InputStream과 OutputStream이다. 항상 입력과 출력은 쌍으로 제공되며 두 클래스는 추상클래스이기 때문에 실제 구현은 하위 일반클래스가 담당한다. byte로 처리하는 하위클래스들의 이름을 보면 다 stream으로 끝난다는 특징이 있다.

- char로 처리하는 클래스의 최상위클래스는 입력을 담당하는 Reader와 출력을 담당하는 Writer가 있다. 이 두 개 역시 추상클래스이다. 하위클래스의 이름이 reader 또는 writer로 끝난다는 걸 알 수 있다.


# 표준입출력
- 표준입력 : 키보드에서 입력받은 문자 데이터
- 표준출력 : 터미널로 출력(터미널의 문자를 모니터로 확인)하는 문자 
- 자바에서 표준 입출력은 java.lang.System 클래스가 담당한다. 
### 구닥다리 라떼이야기
- 프로그램이 하나 실행되면 파일이 3개가 자동으로 열리는데(From C언어)
  - 표준입력/표준출력/표준에러
- 이게 왜 표준입출력이냐면, 키보드로 입력해서 터미널로 보는게 지금은 당연하지만 과거에는 아니여서 텔레타이프(tty)나 시리얼통신(RS-232)을 입출력 체널로 설정하는 경우도 많고, 지금도 일부 임베디드 장비에서 그러고 있기 때문

### System.in
표준입력으로 키보드에서 데이터 읽어들일 때 사용한다. 변수 in의 데이터형은 InputStream이다. 기본적으로 바이트처리된다는 의미이다.

### System.out
표준출력으로 PrintStream이 out의 데이터형이다. 이 클래스의 출력메소드로 print와 println 오버로딩 메소드가 제공된다.


# 키보드 입력처리
```java
System.out.println("데이터를 입력하시오");
InputStream is = System.in;
try {
    int n = is.read();
    System.out.println((char)n);
}catch(IOException e) {
    e.printStackTrace();
}finally {
    try {
        if(is!=null) is.close();
    }catch (IOException e) {
        e.getStackTrace();
    }
}	
```
- InputStream.read() 메소드는 입력된 데이터를 1바이트씩 처리 
  - hello를 입력했을 때 h만 읽어들여서 아스키코드 값을 출력
  - 따라서 char로 형변환을 해야하며 한글은 2바이트라 출력하지 못하는 비효율적인 입력 처리 방식
- 입력스트림을 사용한 후 반드시 close()메소드를 사용해 스트림을 닫는다
  - 자바의 I/O는 반드시 예외처리를 해야한다. 

 
```java
InputStreamReader reader = null;
try {
    System.out.println("데이터를 입력하시오");
    reader = new InputStreamReader(System.in);
    int n = reader.read();
    System.out.println("입력값: "+(char)n);
}catch(IOException e) {
    e.printStackTrace();
}finally {
    try {
        if(reader != null)reader.close();
    }catch (IOException e) {
        e.printStackTrace();
    }
}
```
- InputStreamReader 클래스를 사용하여 키보드 입력을 처리하는 방법이다.
  - char로 처리하기 때문에 여러 글자를 읽어올 수 있으며 한글 처리가 가능하다. 
  - InputStream의 처리방식인 byte를 InputStreamReader의 처리방식인 char로 변경하려면 클래스의 생성자 인자로 전달하면 된다. 
  - 여전히 byte에서 char로 형변환을 해야하며 한 글자만 처리하기 때문에 때문에 비효율적인 처리방식이다.

 
```java
BufferedReader buffer = null;
try {
    System.out.println("데이터를 입력하시오");
    buffer = new BufferedReader(new InputStreamReader(System.in));
    String str = buffer.readLine();
    System.out.println("입력 값: " + str);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (buffer != null)buffer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
- BufferedReader 클래스를 추가해서 키보드 입력을 처리하는 방법이다. BufferedReader의 생성자에 byte에서 char로 변경한 InputStreamReader를 넣는다. 간단한 char처리 방식에서 한줄씩 읽어들이는 단계로 업그레이드 되었다. readLine() 메소드는 입력받은 데이터를 한줄씩 읽기 때문에 위 방법보다 더 효율적으로 입력처리를 할 수 있다. 

키보드 입력 처리는 Scanner 클래스를 사용하면 더 쉽다.

 

 

자바의 입출력처리를 담당하는 클래스
Node 계열

byte나 char로 가공되지 않은 원시데이터를 직접 처리하는 클래스 계열이다. 입출력의 상위 클래스들인 InputStream, OutputStream, Reader, Writer가 여기 속하며 비효율적으로 입출력한다는 것이 특징이다. 콘솔을 이용할 땐 노드계열을 사용한다.

Filter 계열

노드 계열에서 효율적인 데이터 처리를 위해 추가할 수 있는 클래스 계열이다. InputStreamReader과 BufferedReader, PrintWriter 클래스가 해당된다.

 

 

 

파일 처리
File 클래스는 파일과 디렉토리에 관한 메타데이터를 처리하는 클래스이다. 파일명, 디렉토리명, 파일크기, 읽기모드,쓰기모드, 디렉토리 정보, 파일삭제, 디렉토리 생성 등의 작업을 담당한다.

new File("디렉토리");
new File("파일명");
new File("디렉토리/파일명");
new File("디렉토리","파일명");
File 클래스의 생성자에 다음과 같이 파일명, 디렉토리 객체, 파일경로를 사용하여 메타정보를 알아보기 위한 객체를 생성할 수 있다.

		File f = new File("c:\\Test","IOTest.java");
		
		System.out.println("파일크기: "+ f.length());
		System.out.println("파일이름: "+ f.getName());
		System.out.println("파일경로: "+ f.getPath());
		System.out.println("파일절대경로: "+ f.getAbsolutePath());
		System.out.println("파일이냐?: "+ f.isFile());
		System.out.println("디렉토리이냐?: "+ f.isDirectory());
		System.out.println("파일이 존재? "+ f.exists());
		System.out.println("실행가능하냐: "+ f.canExecute());
		System.out.println("write 가능?: "+ f.canWrite());
		System.out.println("read 가능?: "+ f.canRead());
		//System.out.println(f.delete());
위와같이 File 클래스의 메소드를 사용해 메타정보를 출력할 수 있다.

 

 

파일 입출력
일반 txt 파일에 접근할 땐 char 단위로 처리하는 게 효율적이기 때문에 FileReader 및 FileWriter 같은 Node계열 클래스를 사용해 처리할 수 있다. 여기에 BufferedReader와 PrintWriter와 같은 Filter 계열 클래스를 추가해서 구현하면 더 효율적인 파일 입출력이 가능하다.

이미지 파일과 같은 바이너리 파일에 접근할 땐 byte 단위로만 처리되는 FileInputStream과 FileOutputStream을 사용한다.

 



출처: https://xianeml.tistory.com/43 [미현 개발 TIL]


### 해커랭크에서 좋아보이는거
 //위의 skip함수와 동일
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");\

scanner.skip을 이용해서 줄바꿈 부분을 처리하는 부분은 처음봤는데요.
대부분 scanner.nextLine()으로 처리하는거 같은데 줄바꿈 외에도 다른 input값에 대한 처리를 완벽하게 해주기 위함인가 싶기도 합니다.

BufferedWriter
Scanner


# 참고문헌
- 이 글은 https://docs.oracle.com/javase/8 사이트를 기준으로 요약 정리한 글 입니다.
- https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
- https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html
- https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html