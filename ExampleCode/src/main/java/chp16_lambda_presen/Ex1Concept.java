package chp16_lambda_presen;

import java.util.List;
import java.util.function.Consumer;

public class Ex1Concept {
    public static void main(String[] args) {

        //runnableTest();


        List<String> strings = List.of("lamda", "stream", "reactor");
        iterable(strings);



    }

    private static void runnableTest() {

        //익명내부클래스로 구현
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("익명내부클래스로 러너블을 구현");
            }
        });
        t1.start();


        //람다식으로 구현
        Thread t2 = new Thread(() -> System.out.println("람다식으로 러너블을 구현"));
        t2.start();
    }



    private static void iterable(List<String> strings) {
        //익명 내부 클래스로 구현
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("익명내부클래스 : " + s);
            }
        });

        // 람다식으로 구현
        strings.forEach((str) -> System.out.println("람다식 : " + str));


        // 메서드 레퍼런스
        System.out.println("메서드 레퍼런스");
        strings.forEach(System.out::println);
    }


}
