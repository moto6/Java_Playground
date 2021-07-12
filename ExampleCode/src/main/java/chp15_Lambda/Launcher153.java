package chp15_Lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Launcher153 {

    public static void main(String[] args) {

        // Greeting의 함수를 사용
        UnaryOperator<String> hi = (s) -> "hi ";
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi.apply("하이1"));
        System.out.println(hi2.apply("하이2"));

        Greeting greting = new Greeting();
        // hello 참조
        UnaryOperator<String> hello = greting::hello;
        System.out.println(hello.apply("헬로ㄸ@"));

        // 파라미터 있는 생성자
        Function<String, Greeting> jinSeokGreeting = Greeting::new;
        Greeting jinSeok = jinSeokGreeting.apply("JinSeok");
        System.out.println(jinSeok.getName());

        // 파라미터 없는 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;


        //임의 객체의 인스턴스 메소드 참조(불특정 다수)
        String[] names = {"JinSeok", "JinSeok2", "Handsome"};


//		Arrays.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				여기서 두개의 값을 비교하여 return(음수, 0, 양수)
//				return 0;
//			}
//		});

        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }

}


class Greeting {
    private String name;

    public Greeting() {

    }
    public Greeting(String name) {
        this.name = name;
    }

    public static String hi(String ins) { // 이 메서드는 스타틱임
        return "hi" + ins;
    }

    public String hello(String ins) {
        return "ins" + ins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DoNothing {
    public static void main(String[] args) {
        // 정수를 받아 문자열을 내보내는 함수
        // 구현을 하는게 아니라, 기존의 메서드들을 참조하는, 펑셔널 인터페이스의 구현체로 사용
        Function<Integer, String > integerToStringFunction = (i) -> "i am itoa : "+Integer.toString(i);

    }
}