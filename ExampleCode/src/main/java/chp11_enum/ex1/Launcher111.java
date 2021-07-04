package chp11_enum.ex1;
//public class Launcher111 {
//}

enum Gogi {PORK, BEEF, CHICKEN, TURKEY}

public class Launcher111 {
    public static void main(String[] args) {

        Gogi pok = Gogi.PORK; // 가장 흔하게 쓰이는 방식 Enum 에 .(dot)연산으로 열거형의 원소에 접근합니다

        Gogi kfc = Gogi.valueOf("CHICKEN"); // 이렇게 문자열에서 Enum으로 변경하며 대입도 가능합니다 1

        Gogi sirloin = Enum.valueOf(Gogi.class, "BEEF"); // 이렇게 문자열에서 Enum으로 변경하며 대입도 가능합니다2

        Gogi samgyeobsal = Gogi.PORK; // 예를들어 "삼겹살"이라는 변수이름에 고기 이넘을 넣어줄 수 있습니다.


        //들어가 있는 값 확인
        System.out.println("inserted : pok = " + pok);
        System.out.println("inserted : kfc = " + kfc);
        System.out.println("inserted : Sirloin = " + sirloin);
        System.out.println("");

        //이넘끼리 동등비교도 됩니다.
        System.out.println("compare : pok == kfc? : " + (pok == kfc));
        System.out.println("compare : pok == Sirloin? : " + (pok == sirloin));
        System.out.println("compare : pok == samgyeobsal? : " + (pok == samgyeobsal));
        System.out.println("compare : Sirloin == beef? : " + (sirloin == Gogi.BEEF));
        System.out.println("");

        //equals 메서드 사용도 가능합니다
        System.out.println("pok equals Sirloin : " + pok.equals(sirloin));
        System.out.println("pok equals samgyeobsal : " + pok.equals(samgyeobsal));

        //compareTo 메서드 사용도 가능합니다.
        System.out.println("pok comp kfc : " + (pok.compareTo(kfc)));
        System.out.println("pok.comp Gogi.Beef : " + (pok.compareTo(Gogi.BEEF)));

        //열겨형으로 반복문을 돌리면 이렇게 됩니다.
        System.out.println("\n for loop Enum.values() method");
        Gogi[] gogis = Gogi.values();

        for (Gogi gogi : gogis) {
            System.out.printf("%s = %d%n", gogi.name(), gogi.ordinal());
        }

        System.out.println( Gogi.BEEF.name()); //BEEF 출력됨
    }
}
