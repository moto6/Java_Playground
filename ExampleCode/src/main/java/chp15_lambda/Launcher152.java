package chp15_lambda;

public class Launcher152 {
    public static void main(String[] args) {
        int testNum = 20;

        System.out.println("1 - old java way");
        Something runSomething = new Something() {
            @Override
            public int justDoIt(int number) {
                //testNum++; 사이드 이펙트를 만들 수 없다.(함수 밖에 있는 값을 변경하지 못한다.)
                return number + 10;
            }
        };
        System.out.println(runSomething.justDoIt(10));
        // 익명 내부 클래스 방식이 사용되던 과거



        System.out.println("2 - after Java8, use Lambda");
        Something runSomeLambda = (number) -> {
            //testNum++; // 변경안됨 1
            return number + 20 + testNum;
        };
        //System.out.println(testNum++); // 람다식 내부에 쓰인 변수들은 수정할수 없는 effectively final 상태가 된다

        // testNum++ 주석처리한 이유 : 컴파일 에러 발생
        // 람다식 내부에서 side-effect 만들 수 없도록 컴파일 에러 발생(Variable used in lambda expression should be final or effectively final)
        // 함수 밖에 있는 값을 변경하지 못한다 = make atomic
        System.out.println(runSomeLambda.justDoIt(10));



    }
}


@FunctionalInterface // 자바에서 지원하는 어노테이션
interface Something {
    int justDoIt(int number);
}