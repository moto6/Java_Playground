# Executor Service(쓰레드 풀)

### 출처 : 이것이 자바다 12강 스레드풀

: [https://www.youtube.com/watch?v=pKn0YtYhD-Q](https://www.youtube.com/watch?v=pKn0YtYhD-Q)

오리지날 뿌롬 : [https://www.notion.so/Excutor-Service-1facb29935eb44eb88950b31f2eebd53]()

# Executor Service, 쓰레드 풀 의 정의

- 

# 동작방식

- 동작원리

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled.png)

    - 쓰레드 갯수는 미리 정해진 수 만큼 동작하므로(CPU의 갯수만큼)
    - 갑자기 많은 요청이 들어오면, 작업큐의 용량만 늘어날뿐이지, 쓰레드가 증가하지 않아서 시간당 처리량은 꾸준히 유지할 수 있음.
    - 네트워크 서버프로그램은 반드시 쓰레드풀을 생성할 수 뿐이 없음.

# 사용법

- 메소드

![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%201.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%201.png)

- 초기 쓰레드 수
    - 스레드풀 처음만들때 기본들어가있는 쓰레드의 수
- 코어 스레드 수(최소)
    - 사용량이 적을경우, 제거하지않고 유지해야할 최소한의 스레드 숫자
    - 작업량이 증가함에 따라 쓰레드들을 만들다가, 최대스레드 수까지 만들고 더이상 증가하지 않는데,
    - 작업량이 감소함에 따라 최대 스레드 수를 줄여

### newCachedThreadPool()

![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%202.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%202.png)

- 해당 매서드는 코어 쓰레드수가 0이다
- 60초동안 스레드가 아무 작업도 하지 않으면 스레드가 종료됨

### newFixedThreadPool(int nThread)

![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%203.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%203.png)

- 현 CPU의 코어 갯수만큼 Fixed Thred 수를 얻음
    - 가장 이상적인 병렬처리는 CPU 가 가진 코어갯수만큼 쓰레드가 동작하며 동시성으로 처리됨
    - 그래서 위 예제코드는 딱 코어의 수만큼만 최대스레드
    - 개인적으로 코어*1.5배로 컴파일을 돌리는데 제일 빨랏다(make -j4)
    - 

- 동시성과 병렬성
- 동시성 : CPU 코어 하나가 시간을 쪼개서(TDD) 동시에 동작하는거처럼 보임
- 병렬성 : CPU 코어의 수 만큼,동시에 동작함

### ThreadPoolExecutor

![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%204.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%204.png)

- 쓰레드 풀을 직접 만들어서 내가 원하는대로, 입맛대로 쓰레드풀을 만들수 있음
- 쓰레드의 수를 자동으로 관리하고 싶은 경우, 직접 생성
- 예제

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%205.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%205.png)

# 쓰레드 풀의 종료

- 스레드풀의 쓰레드는 기본적으로 데몬쓰레드가 아니다
    - 데몬 : 주쓰레드가 종료되면, 따라서 종료되는 쓰레드, 일반쓰레드는 같이 종료되지 않는다
- 쓰레드풀의 쓰레드는 기본 자동으로 종료되지 않으므로, 모든 스레드풀을 종료시켜야 한다
- 종료하는 방법 3가지

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%206.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%206.png)

    - 종료하는 방법에는 3가지가 존재하는데

         : shutdown(), shutdownNow(), awaitTermination()

        - 세가지 차이는 종료시점에 큐가 남아있을때의 정책에 따라 바뀌는데

            ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%207.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%207.png)

    ### shutdownNow()

    - 1번, 워크큐에 처리되지 않은 작업은 리턴해주고, 처리중이였던 작업은 버린다
    - 버리긴 하지만, 남아있는 작업은 List형태로 리턴해준다(러너블 객체의 List)
    - 비추하는데, 이유는 처리중인 작업이 불완전하게 종료되기 때문에 데이터의 손실 우려가 있다.

    ### shutdown(),

    - 2번, 모든 작업을 처리한 후에 끝낸다, 끝가지 모든 작업을 다 하고 가는데
    - 워크 큐에 있는거까지 다하고 간다

    ### awaitTermination()

    - 3번, 일은 다 끝내고 가는데, 시간이 너무 오래 걸리면 기다렸다가 종료된다.

# 쓰레드풀 작업의 생성

- 다시한번 전체 구조를 보면

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%208.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%208.png)

- Runnable과 Callable 객체의 차이

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%209.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%209.png)

    - Runnable : 만들함수는 void run()

        : 작업 완료 후 리턴값이 없다. 실행만 하고 끝난다

    - Callable : 만들함수는 <T> call()

        : 작업 완료 후 리턴값이 있다! 실행후 리턴을 

- 쓰레드풀의 작업 처리란 결국
    - Work Q에서 객체(러너블/콜러블)을 가져와
    - 각각의 쓰레드로 실행하게 함(각각 void run() 혹은 <T> call() )

# 작업 처리 요청

- 작업처리 요청 매서드

![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2010.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2010.png)

- 작업 처리 요청이란?
    - Runnable과 Callable 객체를 ExecutorService 작업 큐에 넣는 행위 자체를 의미
    - 작업처리 요청을 위해 execute, submit 두가지 매소드를 제공

### 메서드 설명

- execute : Runnable과 짝궁, 그러므로 작업처리 결과 리턴 없음
- submit  : Callable과 짝궁, 결과값이 리턴 됨
    - 3개로 오버로딩이 되는데, 결과값이 저장될 객체를 넣거나
    - 결과를 리턴받는 방식으로 두가지 방식이 더 오버로딩메소드 존재

### 작업 처리 도중 예외가 발생경우

- execute : 스레드 자체가 종료됨
- submit  : 스레드는 종료되지않음, 재사용됨

- 예제코드

```
package w4_Async.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0; i<10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("작업 처리");
                    //스레드 총 개수 및 작업 스레드 이름 출력
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
                    //예외 발생 시킴
                    int value = Integer.parseInt("삼");// number format exception 발생
                }
            };

            //executorService.execute(runnable);// 예외 발생할경우 제거되고 새로운 쓰레드 생성
            executorService.submit(runnable);

            Thread.sleep(10);
        }

        executorService.shutdown();
    }
}
```

- 실행결과1

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2011.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2011.png)

- 실행결과2

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2012.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2012.png)

- 실행결과3

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2013.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2013.png)

# 블로킹 방식의 작업완료 통보받기

### 사용법

- 블로킹 방식?

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2014.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2014.png)

    - 작업요청후, 결과 오기까지 기다리는 방식

- Future 객체

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2015.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2015.png)

    - Future 객체란,  지연완료객체,
        - 결과값이 아니다! 미래에 작업이 완료되면 돌려준다는 의미
        - 작업이 완료될 때 까지 기다렸다가 최종 결과를 얻기 위해 get() 메소드를 사용

- submit 과 함께

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2016.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2016.png)

    - 위에 두개는 러너블, 아래 하나는 콜러블
    - 작업 처리 완료 후 리턴타입은

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2017.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2017.png)

### Future의 get() 은 UI 스레드에서 호출하면 안된다

- Future의 get() 메서드는 블로킹 함수이기 때문에 그런데
    - UI 를 변경하고 이벤트 처리하는 스레드가 get() 메서드를 호출하면

        : 작업을 완료할때 까지 UI의 모든 처리가 잠긴다(먹통) 이벤트 처리도 안된다

    - UI 스레드에서는 블록킹함수나, 시간이 오래걸리는 일들을 할때는 항상 주의해야함

- 새로운 스레드를 생성해서 호출

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2018.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2018.png)

    - 

- 스레드풀의 스레드가 호출

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2019.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2019.png)

    - submit() 이라는 메서드에 넣어줌

- 이외에 다른 메서드

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2020.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2020.png)

    - 모두 boolean 값의 리턴형을 가지고 있음

# 예제 : 리턴값이 없는 작업 완료 통보

### 1단계 스니핏

- 리턴값이 없는 작업 객체 만들기 : (러너블+submit+get)

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2021.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2021.png)

- 예시, 1~10 까지의 합을 구하는 submit, get, 러너블, run

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2022.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2022.png)

- 두가지 예외가 발생하는 경우

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2023.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2023.png)

```java
try {
      future.get();//여기서 작업이 끝날때까지 걸려있음(블로킹 됨!!)

      // 사실 get 메서드는 오브젝트를 리턴하고, 리턴값이 없음 Null을 리턴함
      System.out.println("[작업 처리 완료]");
  } catch(ExecutionException e) {
      System.out.println("[실행예외] " + e.getMessage());

  } catch (InterruptedException e) {
      System.out.println("[인터럽트 발생] " + e.getMessage());
  }
```

- 종료시 정책(워크 큐에 뭔가가 남아있을때

![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2024.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2024.png)

```java
executorService.shutdown();//모든 스레드를 처리한 이후에 종료해라
//퇴근하고싶으면 이 일 다 하고 가라..

//executorService.awaitTermination(@@)
//executorService.shutdownNow(@@)
```

### 2단계 : 실행코드

- 예제코드 작성 : 02_Blocking_NoResultExample

```java
package w4_Async.study;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class E2_NoResultExam {

    public static void main(String[] args) {
        ExecutorService  executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
                // 지금 컴퓨터의 코어갯수만큼 쓰레드 생성
        );

        System.out.println("[작업 처리 요청]");
        Runnable runnable = new Runnable() {//러너블 익명객체 만들기

            @Override // 재정의하는거 알지  void run매서드
            public void run() {
                int sum = 0;
                for(int i=1; i<=10; i++) {
                    sum += i;
                }//이 for문은 1~10까지 더하는 코드를 작성함
                System.out.println("[처리 결과] " + sum);//처리결과를 출력, 항상 55가 계산되서 나옴
            }
            //여기까지 작업객체를 만들어준거고

        };

        //이제 쓰레드풀에 새로 작업을 요청및 할당할껀데
        Future future = executorService.submit(runnable);// 퓨처객체는 작업값이 아닌거 알지?
        //위 작업이 리턴값이 있으면? : 퓨쳐를 리턴받음, 입력파라미터는 두가지 떠올려
        //리턴값이 없으면 : 입력파라미터

        //위 코드는 리턴값이 없고, 계산만하고 출력하고 끝나기때문에, 리턴값이 없음 그래서

        try {
            future.get();//여기서 작업이 끝날때까지 걸려있음(블로킹 됨!!)

            // 사실 get 메서드는 오브젝트를 리턴하고, 리턴값이 없음 Null을 리턴함
            System.out.println("[작업 처리 완료]");
        } catch(ExecutionException e) {
            System.out.println("[실행예외] " + e.getMessage());

        } catch (InterruptedException e) {
            System.out.println("[인터럽트 발생] " + e.getMessage());
        }

        executorService.shutdown();//모든 스레드를 처리한 이후에 종료해라
        //퇴근하고싶으면 이 일 다 하고 가라..

        //executorService.awaitTermination(@@)
        //executorService.shutdownNow(@@)

    }

}
```

- 실행결과

    ![Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2025.png](Executor%20Service(%E1%84%8A%E1%85%B3%E1%84%85%E1%85%A6%E1%84%83%E1%85%B3%20%E1%84%91%E1%85%AE%E1%86%AF)%201facb29935eb44eb88950b31f2eebd53/Untitled%2025.png)

- 가장 중요하게 기억해야할 부분은 get 메서드를 UI(콘솔이나 프롬프트화면에서라도)에서 호출하지 않는것이 중요하다!
    - 프로그램에서 사용자접점과 먹통이되는것만큼 답답한일이 없다
    - 자바 FX나 안드로이드 메인쓰레드에서는 호출하지 말라고..