package chp17_stream;


import java.util.HashMap;
import java.util.Map;

//JCF 동일객체 동일리턴 파악해보기
// 이거 중요한 개념이야
public class Launcher172 {

    public static void main(String[] args) {


        Map<Integer, Fighter> texts = new HashMap<>();

        Fighter eagle = new Fighter(15, "F15 Eagle");
        texts.put(1, eagle);

        Fighter fulcrum = new Fighter(19, "Mig29 Fulcrum");
        texts.put(2, fulcrum);

        Fighter raptor = new Fighter(22, "F22 Raptor");
        texts.put(3, raptor);


        texts.put(4, new Fighter(27, "Su27 Flanker"));

        Fighter fighter = texts.get(3);

        System.out.println("is same? : " + (fighter == raptor));
        System.out.printf("wtf? : fighter=%s  ,  raptor=%s",fighter,raptor);

    }

}

class Fighter {
    int code;
    String nickname;

    public Fighter(int code, String nickname) {
        this.code = code;
        this.nickname = nickname;
    }
}
