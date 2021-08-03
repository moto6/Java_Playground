package chp_var;


//2018년 3월에 출시된 Java 10부터 var를 지원합니다.
//java8은 안되고 java11은 된다!

import java.util.ArrayList;
// var a = 1; // var는 지역변수에서만 사용 가능



public class Varex {
    public static void main(String[] args) {
        var myIny = 1; // int로 추론
        var myStr = "Java"; // String으로 추론
        System.out.println(myIny);
        var stringList = new ArrayList<String>(); // ArrayList<String>으로 추론
        stringList.add("무지개빛");
        stringList.add("총공격이다");
        System.out.println(stringList.toString());

        int var = 142857; // 식별자로 사용 가능
        System.out.println(var);
        //var는 예약된 타입 이름으로 키워드가 아니기 때문에 식별자로 사용할 수 있습니다





        // var x = 1, y = 2; // ,와 함께 사용 불가능

        // var str = null; // null은 String에서만 사용할 수 있는 것이 아니므로 타입 추론 불가능

        // var myErr; // var를 사용할 때는 초기화를 바로 해야 함 (타입 추론이 불가능하므로)

        // var l = () -> {} // 람다식에서 사용 불가능

    }
}
